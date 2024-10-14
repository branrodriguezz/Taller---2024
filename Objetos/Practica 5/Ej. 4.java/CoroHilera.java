/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class CoroHilera extends Coro{
    /*
    o En el coro por hileras los coristas se deben ir agregando de izquierda a derecha, 
    completando la hilera antes de pasar a la siguiente.
    */
    private Corista[][] coroHilera;
    private int hileras;
    private int intPorHilera;
    private int dimLHileras;
    private int dimLIntPorHileras;
    //constructor
    
    public CoroHilera (String nombre, Director director, int intPorHilera, int hileras){
        super (nombre, director);
        this.setHileras (hileras);
        this.setIntPorHilera (intPorHilera);
        this.coroHilera = new Corista[hileras][intPorHilera]; //matriz de coristas
    }
    
    //metodos
    /*
    o En el coro por hileras los coristas se deben ir agregando de izquierda a derecha, 
    completando la hilera antes de pasar a la siguiente.
    */
    
    @Override
    public boolean estaLleno (){ //ESTA MAL. NO HAY POSICIONES NULL EN EL MEDIO.
        boolean lleno = true;
        int i = 0;
        while (i < this.getHileras() && lleno == true){
            int j = 0;
            while (j < this.getIntPorHileras() && lleno == true){
                if (coroHilera [i][j] == null) 
                    lleno = false;
                else
                    j++;
            }
            i++;
        }
        return lleno;
    }
    
    
    @Override
    public void agregarCorista (Corista corista){
        if (this.estaLleno() == false){
            coroHilera [this.getDimLHileras()][this.getDimLIntPorHileras()] = corista;
            if (this.getDimLHileras() < this.getIntPorHileras()) {
                this.dimLHileras++;
            }
            else {
                 this.dimLHileras = 0;
                 this.dimLIntPorHileras++;
            }
        }
    }
   
    @Override
    public boolean bienFormado (){
        int i = 1;
        boolean ordenado = true;
        while (i < this.getHileras() && ordenado == true){
            if (this.coroHilera [i-1][0].getTonoFundamental() > this.coroHilera[i][0].getTonoFundamental()) {
                int j = 1;
                while (j < this.getIntPorHileras() &&ordenado == true){
                    if (this.coroHilera[i-1][j-1].getTonoFundamental() != this.coroHilera[i-1][j].getTonoFundamental()){
                        ordenado = false;
                    }
                    else
                        j++;
                }
            }
            else
                ordenado = false;
            
            if (ordenado == true) 
                i++;
        }
        return ordenado;
    }
    
    public void setHileras(int hileras) {
        this.hileras = 0;
    }

    public void setIntPorHilera(int intPorHilera) {
        this.intPorHilera = 0;
    }

    public int getHileras() {
        return hileras;
    }

    public int getIntPorHileras() {
        return intPorHilera;
    }

   private void setDimLHileras(int dimL) {
        this.dimLHileras = 0;
    }

    private int getDimLHileras() {
        return dimLHileras;
    }
    
    private void setDimLPorHileras (){
        this.dimLIntPorHileras = 0;
    }
    
    private int getDimLIntPorHileras (){
        return dimLIntPorHileras;
    }
    
    
    @Override
    public String toString (){
        String aux = "" + super.toString();
                     for (int i = 0; i < this.getDimL(); i++){
                         for (int j = 0; j < this.vecDimL[i]; j++){
                             aux = aux + " | " + this.coroHilera [i][j].toString() + " | " + "\n";
                         }
                     }
        return aux;
    }
    
}
