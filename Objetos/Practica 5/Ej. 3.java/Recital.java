/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public abstract class Recital {
    /*
    3- Un productor musical desea administrar los recitales que organiza, que pueden ser: eventos ocasionales y
    giras.
● De todo recital se conoce el nombre de la banda y la lista de temas que tocarán durante el recital.
● Un evento ocasional es un recital que además tiene el motivo (a beneficio, show de TV o show privado),
    el nombre del contratante del recital y el día del evento.
● Una gira es un recital que además tiene un nombre y las “fechas” donde se repetirá la actuación.
    De cada “fecha” se conoce la ciudad y el día. Además la gira guarda el número de la fecha en la que se 
    tocará próximamente (actual).
a) Genere las clases necesarias. Implemente métodos getters/setters adecuados.
    */
    private String nombreBanda;
    private String [] listaTemas;
    private int cantTemas;
    private int dimL;
    
    //constructor
    //b) Implemente los constructores. El constructor de recitales recibe el nombre de la banda y 
    //la cantidad de temas que tendrá el recital. 
    
    public Recital (String nombreBanda, int cantTemas){
        this.setNombreBanda(nombreBanda);
        this.setCantTemas(cantTemas);
        
        listaTemas = new String [this.getCantTemas()];
        //aca haria el for para inicializar el vector?
    }
    
    //metodos
    //i. Cualquier recital debe saber responder a los mensajes:
    //● agregarTema que recibe el nombre de un tema y lo agrega a la lista de temas.
    
    public void agregarTema (String nombre){
        if (this.getDimL() < this.getCantTemas()){ //esta mal si esto de chequear si hay espacio no lo hago en otro metodo?
            listaTemas [this.getDimL()] = nombre;
            this.incrementarDimL();
        }
    }
    
    //● actuar que imprime (por consola) para cada tema la leyenda “y ahora
    //tocaremos...” seguido por el nombre del tema.
    
    public String actuar (){
        String aux = "";
        for (int i = 0; i < this.getDimL(); i++){
            aux = aux + "Y ahora tocaremos..." + listaTemas [i] + "\n";
        }
        return aux;
    }
    
    public abstract double calcularCosto ();
    
    public String getNombreBanda() {
        return nombreBanda;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    private void setCantTemas(int cantTemas) {
        this.cantTemas = cantTemas;
    }
    
    private int getDimL (){
        return dimL;
    }
    private void setDimL (){
        this.dimL = 0;
    }
    
    public void incrementarDimL (){
        this.dimL++;
    }
}
