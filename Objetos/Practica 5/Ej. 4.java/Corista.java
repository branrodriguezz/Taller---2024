/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Corista extends Persona{
    /*
    De los coristas se conoce el nombre, DNI, edad y el tono fundamental (un número entero)
    */
   private int tonoFundamental;
   
   //constructor
   public Corista (String nombre, int dni, int edad, int tonoFundamental){
       super (nombre, dni, edad);
       this.setTonoFundamental (tonoFundamental);
   }

    public void setTonoFundamental(int tonoFundamental) {
        this.tonoFundamental = tonoFundamental;
    }

    public int getTonoFundamental() {
        return tonoFundamental;
    }
   
   @Override
    public String toString (){
        String aux = super.toString() + 
                    " Tono fundamental: " + this.getTonoFundamental();
        return aux;
    }
}
