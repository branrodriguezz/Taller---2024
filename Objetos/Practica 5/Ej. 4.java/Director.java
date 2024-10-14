/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Director extends Persona {
    //conoce el nombre, DNI, edad y la antigüedad (un número entero). 
    private int antigüedad;
    
    //constructor
    public Director (String nombre, int DNI, int edad, int antigüedad){
        super (nombre, DNI, edad);
        this.setAntigüedad(antigüedad);
    }

    public void setAntigüedad(int antigüedad) {
        this.antigüedad = antigüedad;
    }

    public int getAntigüedad() {
        return antigüedad;
    }
    
    @Override
    public String toString (){
        String aux = "";
        aux = aux + super.toString() + 
                    " Antigüedad: " + this.getAntigüedad();
        return aux;
    }
}
