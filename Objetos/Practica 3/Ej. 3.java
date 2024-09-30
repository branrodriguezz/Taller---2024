/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author branroodriguez
 */
public class Estante {
    
    private Libro [] vector;
    private int dimL;
 
    //constructor que permita iniciar el estante sin libros.
    public Estante () {
        vector = new Libro [20];
        int dimL = 0;
    }
    
    //metodos 
    

    public Libro[] getVector() { //DEVUELVE UN LIBRO
        return vector;
    }
    
    //(i) devolver la cantidad de libros que almacenados
    public int getDimL() { //DEVUELVE LA CANTIDAD DE LIBROS
        return dimL;
    }

    public void setVector(Libro[] unVector) { //MODIFICO UN LIBRO
        vector = unVector;
    }

    public void setDimL(int unDimL) { //MODIFICO LA CANTIDAD DE LIBROS 
        dimL = unDimL;
    }
    
    //(ii) devolver si el estante está lleno
    public Boolean estaLleno () {
        Boolean aux = dimL == 20;
        return aux;
    }
    
    //(iii) agregar un libro al estante
    public void agregarLibro (Libro unLibro){
        if (dimL < 20) {
            vector [dimL] = unLibro;
            dimL++;
        }
        
    }
    
    //(iv) devolver el libro con un título particular que se recibe.
    public Libro tituloLibro (String titulo) {
        int i;
        for (i = 0; i < dimL; i++) { //preguntar por el metodo equals, puedo usarlo en este caso?
            if (vector[i].getTitulo().equals(titulo)) {
                return vector [i]; //preguntar
            }
        }
        return null;
    }
    
    public void imprimir () {
        for (int i = 0; i < dimL; i++) {
            System.out.print (" | Libro " + (i+1) + " |");
            System.out.print (vector[i].toString());
            System.out.println ();
            System.out.print (" ------------------------------------------------------------------------------------------------- ");
        }
    }
}

//programa
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import PaqueteLectura.Lector;

/**
 *
 * @author branroodriguez
 */
public class ej03 {
    /*
    B- Realice un programa que instancie un estante. Cargue varios libros. 
    A partir del estante, busque e informe el autor del libro “Mujercitas”.
    */
    
    public static void main (String [] args) {
        
        Estante estanTe = new Estante ();
        String titulo, nombre, biografia, origen, editorial, isbn;
        int annio;
        double precio;
        
        System.out.print ("Titulo: ");
        titulo = Lector.leerString();
        
        while ((estanTe.estaLleno() == false) && (!titulo.equals("Mafalda"))) {
          
            System.out.print ("Nombre: ");
            nombre = Lector.leerString();
            
            System.out.print ("Biografia: ");
            biografia = Lector.leerString();
            
            System.out.print ("Origen: ");
            origen = Lector.leerString();
            
            Autor autore = new Autor (nombre, biografia, origen);
            
            System.out.print ("Editorial: ");
            editorial = Lector.leerString();
            
            System.out.print ("Año de edicion: ");
            annio = Lector.leerInt();
            
            System.out.print ("ISBN: ");
            isbn = Lector.leerString();
            
            System.out.print ("Precio: ");
            precio = Lector.leerDouble();
            
            Libro libro = new Libro (titulo, autore, editorial, annio, isbn, precio);
            
            estanTe.agregarLibro(libro);
            
            System.out.print ("Titulo: ");
            titulo = Lector.leerString();
             
        }
        
        System.out.println (" ----------------- Estante de libros ------------------- ");
        System.out.println ();
        estanTe.imprimir(); //imprimo el estante de libros
        
        //busco e informo el autor del libro mujercitas
        System.out.println ();
        System.out.println ("Libro Mujercitas: " + estanTe.tituloLibro("Mujercitas").getPrimerAutor());
    }
}
