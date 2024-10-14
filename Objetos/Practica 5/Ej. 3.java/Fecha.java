/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Fecha {
    private String ciudad;
    private int dia;
    
    //constructor
    public Fecha (String unaCiudad, int unDia){
        this.setCiudad (unaCiudad);
        this.setDia (unDia);
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getDia() {
        return dia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return " Ciudad: " + ciudad + ", dia: " + dia;
    }
    
    
}
