/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class coroHilera extends Coro{
    /*
    o En el coro por hileras los coristas se deben ir agregando de izquierda a derecha, 
    completando la hilera antes de pasar a la siguiente.
    */
    private Corista[][] coroHilera;
    private int [] vecDimL;
    private int hileras;
    private int intPorHilera;
    private int dimL;
    //constructor
    
    public coroHilera (String nombre, Director director, int intPorHilera, int hileras){
        super (nombre, director);
        this.setHileras (hileras);
        this.setIntPorHilera (intPorHilera);
        this.vecDimL = new int [hileras]; //guarda la dimL de la hilera 
        this.coroHilera = new Corista[hileras][intPorHilera]; //matriz de coristas
        this.inicializarMatriz();
        this.inicializarVector();
    }
    
    //metodos
    /*
    o En el coro por hileras los coristas se deben ir agregando de izquierda a derecha, 
    completando la hilera antes de pasar a la siguiente.
    */
    
    public void inicializarMatriz (){
        for (int i = 0; i < this.getHileras(); i++) {
            for (int j = 0; i < this.getIntPorHileras(); j++){
                this.coroHilera [i][j] = null;
            }
        }
    }
    
    public void inicializarVector (){
        for (int i = 0; i < this.getHileras(); i++)
            this.vecDimL [i] = 0;
    }
    
    @Override
    public boolean estaLleno (){
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
            coroHilera [this.getDimL()][this.vecDimL[this.getDimL()]] = corista;
            this.vecDimL[this.getDimL()]++;
            if (vecDimL[this.getDimL()] == this.getIntPorHileras()) 
                this.dimL++;
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

   private void setDimL(int dimL) {
        this.dimL = 0;
    }

    private int getDimL() {
        return dimL;
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
