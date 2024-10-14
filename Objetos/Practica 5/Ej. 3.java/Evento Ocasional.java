/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class EventoOcasional extends Recital{
    /*
    Un evento ocasional es un recital que además tiene el motivo (a beneficio, show de TV o show privado), 
    el nombre del contratante del recital y el día del evento.
    */
    private String motivo;
    private String nombreC;
    private int diaE;
    
    //constructor
    //El constructor de eventos ocasionales además recibe el motivo, el nombre del contratante y día del evento.
    
    public EventoOcasional (String nombreBanda, int cantT, String motivo, String nombreC, int diaE){
        super(nombreBanda, cantT);
        this.setMotivo (motivo);
        this.setNombreC(nombreC);
        this.setDiaE(diaE);
    }
    
    /*
    iii. El evento ocasional debe saber responder al mensaje actuar de manera distinta:
    ● Si es un show de beneficencia se imprime la leyenda “Recuerden colaborar con...“ seguido del nombre 
    del contratante.
    ● Si es un show de TV se imprime “Saludos amigos televidentes”
    ● Si es un show privado se imprime “Un feliz cumpleaños para...” seguido del
    nombre del contratante.
    Independientemente del motivo del evento, luego se imprime el listado de temas como lo hace cualquier recital.
    */
    
    public String chequearShow (){
        String aux = "";
        if (this.getMotivo().equals("A beneficio")) {
            aux = aux + " Recuerden colaborar con... " + this.getNombreC() + "\n";
        }
        if (this.getMotivo().equals("Show de TV")) {
            aux = aux + " Saludos amigos televidentes " + "\n";
        }
        if (this.getMotivo().equals("Show Privado")){
            aux = aux + " Un feliz cumpleaños para... " + this.getNombreC() + "\n";
        }
        return aux;
    }
    
    @Override
    public String actuar (){
        String aux = "" + this.chequearShow() + super.actuar();
        return aux;
    }
    //metodos
    
    @Override //Si es un evento ocasional devuelve 0 si es a beneficio, 50000 si es un show de TV y 150000 si es privado
    public double calcularCosto(){
        double aux = 0;
        if (this.getMotivo().equals(" A beneficio "))
            aux = aux + 0;
        else {
            if (this.getMotivo().equals(" Show de TV "))
                aux = aux + 50.000;
            else
                aux = aux + 150.000;
        }
        return aux;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getNombreC() {
        return nombreC;
    }

    public int getDiaE() {
        return diaE;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public void setDiaE(int diaE) {
        this.diaE = diaE;
    }
    
}
