/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public abstract class Coro {
    /*
    4- Una escuela de música arma coros para participar de ciertos eventos. 
    Los coros poseen un nombre y están formados por un director y una serie de coristas. Del director se
    conoce el nombre, DNI, edad y la antigüedad (un número entero). De los coristas se conoce el nombre, DNI, edad 
    y el tono fundamental (un número entero). Asimismo, hay dos tipos de coros: coro semicircular en el que los 
    coristas se colocan en el escenario uno al lado del otro y coro por hileras donde los coristas se organizan 
    en filas de igual dimensión.
    */
    private String nombre;
    private Director director;
    
    //constructor
    /*
    Implemente las clases necesarias teniendo en cuenta que los coros deberían crearse con un director
    y sin ningún corista, pero sí sabiendo las dimensiones del coro.
    */
    public Coro (String nombre, Director director){
        this.setNombre (nombre);
        this.setDirector(director);
    }

    //metodos
    public abstract void agregarCorista (Corista corista);
    public abstract boolean estaLleno ();
    public abstract boolean bienFormado ();
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public Director getDirector() {
        return director;
    }
   
    /*
    ● devolver la representación de un coro formada por el nombre del coro, 
    todos los datos del director y todos los datos de todos los coristas.
    */
    @Override
    public String toString (){
        String aux = "";
                   aux = aux + " Nombre del coro: " + this.getNombre() + " Datos del director: " + this.getDirector() + "\n" + 
                         " ------------------ Datos de los coristas: ------------------------ " + "\n";
        return aux;
    }
}
