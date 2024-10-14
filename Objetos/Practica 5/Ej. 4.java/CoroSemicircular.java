/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class CoroSemicircular extends Coro{
    /*
    ● agregar un corista al coro.
    o En el coro semicircular los coristas se deben ir agregando de izquierda a derecha
    */
    private int cantCoristas;
    private Corista[] coroSemicircular;
    private int dimL;
    
    public CoroSemicircular (String nombre, Director director, int cantCoristas){
        super (nombre, director);
        this.setCantCoristas(cantCoristas);
        this.coroSemicircular = new Corista [cantCoristas];
        this.inicializarVector();
    }
    //metodos
    /*
    ● agregar un corista al coro.
    o En el coro semicircular los coristas se deben ir agregando de izquierda a derecha
    */
    
    @Override
    public void agregarCorista (Corista corista){
        if (this.getDimL() < this.getCantCoristas()){
            this.coroSemicircular[this.getDimL()] = corista;
            this.incrementarDimL();
        }
    }
    
    @Override
    public boolean estaLleno (){
        boolean aux = false;
        if (this.getDimL() == this.getCantCoristas()){
            aux = true;
        }
        return aux;
    }
    
    /*
    ● determinar si un coro (se supone que está lleno) está bien formado. Un coro está bien formado si:
    o En el caso del coro semicircular, de izquierda a derecha los coristas están ordenados de mayor a 
    menor en cuanto a tono fundamental.
    */
    @Override
    public boolean bienFormado (){
        boolean aux = true;
        int i = 1;
        
        while (i < this.getDimL() && aux == true) {
            if (this.coroSemicircular [i-1].getTonoFundamental() > this.coroSemicircular [i].getTonoFundamental()){
                i++;
            }
            else 
                aux = false;
        }
        return aux;
    }
    
    public void inicializarVector (){
        for (int i = 0; i < this.getCantCoristas(); i++){
            this.coroSemicircular[i]= null;
        }
    }
    
    public void incrementarDimL (){
        this.dimL++;
    }
    
    public void setCantCoristas(int cantCoristas) {
        this.cantCoristas = cantCoristas;
    }

    private void setDimL(int dimL) {
        this.dimL = 0;
    }

    public int getCantCoristas() {
        return cantCoristas;
    }

    private int getDimL() {
        return dimL;
    }
    
    //● devolver la representación de un coro formada por el nombre del coro, todos los 
    //datos del director y todos los datos de todos los coristas.
    @Override
    public String toString (){
        String aux = "" + super.toString();
                for (int i=0; i < this.getDimL(); i++){
                    aux = aux + " | " + this.coroSemicircular [i].toString() + " | " + "\n";
                }
        return aux;
    }
}
