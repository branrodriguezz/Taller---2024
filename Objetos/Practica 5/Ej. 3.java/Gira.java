/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Gira extends Recital {
    /*
    Una gira es un recital que además tiene un nombre y las “fechas” donde se repetirá la actuación. 
    De cada “fecha” se conoce la ciudad y el día. Además la gira guarda el número de la fecha en la que se 
    tocará próximamente (actual).
    */
    private String nombre;
    private Fecha[] vectorFechas;
    private int actual;
    private int cantF;
    private int dimL;
    
    //constructor
    //el constructor de giras además recibe el nombre de la gira y la cantidad de fechas que tendrá.
    public Gira (String nombreB, int cantT, String nombre, int cantF){
        super(nombreB, cantT);
        this.setCantF (cantF);
        this.setNombre (nombre);
        //inicializo el vector de fechas?
        vectorFechas = new Fecha [cantF];
    }
    
    //metodos
    
    /*● agregarFecha que recibe una “fecha” y la agrega adecuadamente.
    ● La gira debe responder al mensaje actuar de manera distinta. Imprime la leyenda “Buenas noches ...” 
    seguido del nombre de la ciudad de la fecha “actual”. Luego debe imprimir el listado de temas como
    lo hace cualquier recital. Además debe establecer la siguiente fecha de la gira como la nueva “actual”.
    */
    
    public void agregarFecha (Fecha fecha){
        if (this.getDimL () < this.getCantF()) {
            vectorFechas [this.getDimL()] = fecha;
            this.incrementarDimL();
        }
    }
    
    @Override
    public String actuar (){
        String aux = "";
        if (this.getActual() < this.getDimL()) {
            aux = aux + vectorFechas [this.getActual()].toString();
            this.actual++;
        }
        return aux;
    }
    
    @Override
    public double calcularCosto (){
        double aux = 0;
        for (int i = 0; i < this.getActual(); i++){
            aux = aux + 30.000;
        }
        return aux;
    }
    
    public void incrementarActual(){
        this.actual++;
    }
    public int getCantF (){
        return cantF;
    }
    public String getNombre() {
        return nombre;
    }

    public int getActual() {
        return actual;
    }
    
    public int getDimL () {
        return dimL;
    }

    @Override
    public void incrementarDimL (){
        this.dimL++;
    }
    public void setDimL (){
        this.dimL = 0;
    }
    public void setCantF (int cantF){
        this.cantF = cantF;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActual(int actual) {
        this.actual = 0;
    }
    
}
