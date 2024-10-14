/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Persona {
    
    private String nombre;
    private int DNI;
    private int edad;
    
   //constructor
    public Persona (String nombre, int DNI, int Edad){
        this.setNombre (nombre);
        this.setDNI (DNI);
        this.setEdad (Edad);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }
    
    @Override
    public String toString (){
        String aux = "";
               aux = aux + " Nombre: " + this.getNombre() + " DNI: " + this.getDNI() + " Edad: " + this.getEdad();
        return aux;
    }
    
}
