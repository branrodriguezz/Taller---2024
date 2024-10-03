/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author branroodriguez
 */
public class Autor {
    private String nombre;
    private String biografia;
    private String origen;
    
    public Autor (String unNombre, String unaBiografia, String unOrigen){
        nombre = unNombre;
        biografia = unaBiografia;
        origen = unOrigen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setNombre(String unnombre) {
        nombre = unnombre;
    }

    public void setBiografia(String unabiografia) {
        biografia = unabiografia;
    }

    public void setOrigen(String unorigen) {
        origen = unorigen;
    }
    
    @Override
    public String toString (){
        String aux = "- Nombre " + nombre + " - Biografia " + biografia + " - Origen " + origen;
        return aux;
    }
    
    
}
/*
Clase Libro a la cual se agregaron constructores. 
 */
package tema3;

/**
 *
 * @author vsanz
 */
public class Libro {
    /*
    2-A- Modifique la clase Libro.java (carpeta tema3) para ahora considerar que el primer autor 
    es un objeto instancia de la clase Autor.
    Implemente la clase Autor, sabiendo que se caracterizan por nombre, biografía y origen y 
    que deben permitir devolver/modificar el valor de sus atributos y devolver una representación 
    String formada por nombre, biografía y origen.
    Luego realice las modificaciones necesarias en la clase Libro.
    */
   private String titulo;
   private Autor primerAutor; 
   private String editorial;
   private int añoEdicion;
   private String ISBN; 
   private double precio; 
     
    
    public Libro(  String unTitulo,  Autor unPrimerAutor, String unaEditorial, 
    int unAñoEdicion, String unISBN, double unPrecio){
         titulo = unTitulo;
         primerAutor = unPrimerAutor;
         editorial = unaEditorial; 
         añoEdicion= unAñoEdicion;
         ISBN =  unISBN;
         precio = unPrecio;
    }
    
    public Libro(  String unTitulo,  String unaEditorial, Autor unPrimerAutor, String unISBN){
         titulo = unTitulo;
         editorial = unaEditorial; 
         añoEdicion= 2015;
         primerAutor = unPrimerAutor;
         ISBN =  unISBN;
         precio = 100;
    }
    
    public Libro(){
   
    }
        
    public String getTitulo(){
        return titulo;
    }
  
    public String getEditorial(){
        return editorial;
    }
    public int getAñoEdicion(){
        return añoEdicion;
    }
  
    public Autor getPrimerAutor(){
        return primerAutor;
    } 
    public String getISBN(){
        return ISBN;
    } 
    public double getPrecio(){
        return precio;
    }
   
    public void setTitulo(String unTitulo){
        titulo = unTitulo;
    }
   
    public void setEditorial(String unaEditorial){
         editorial = unaEditorial;
    }
    public void setAñoEdicion(int unAño){
         añoEdicion = unAño;
    }
   
    public void setPrimerAutor(Autor unPrimerAutor){
         primerAutor=unPrimerAutor;
    } 
    public void setISBN(String unISBN){
         ISBN=unISBN;
    } 
    public void setPrecio(double unPrecio){
         precio=unPrecio;
    }
   
    
   @Override
    public String toString(){
        String aux;
        aux= " Titulo: " + titulo + " | Autor " + primerAutor + " | Editorial: " + editorial + " | Año de edicion: " + añoEdicion + " | ISBN: " + ISBN + " | Precio: " + precio + " | ";
       return ( aux);
    }
    
    public String devolverAutor(){
        String a;
        a = "| Autor : " + primerAutor;
        return a;
    }
        
}
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
        dimL = 0;
    }
    
    //metodos 
    
    public Libro[] getVector() { //DEVUELVE UN LIBRO
        return vector;
    }
    
    //(i) devolver la cantidad de libros que almacenados
    public int getDimL() { //DEVUELVE LA CANTIDAD DE LIBROS
        return dimL;
    }
    
    private void setdimL (int undimL){
        dimL = undimL;
    }
    public void setVector(Libro[] unVector) { //MODIFICO UN LIBRO
        vector = unVector;
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
    public String tituloLibro (String titulo) {
        int i = 0;
        Boolean encontre = false;
        String aux = "";
        while (i < dimL && encontre.equals(false)) { 
                if (vector[i].getTitulo().equals(titulo)) {
                    encontre = true;
                    aux = vector[i].devolverAutor();
                }   
                i++;
            }
        if (encontre.equals(true))
            return aux;
        else {
            System.out.print("No existe ese libro");
            return null;
        }
    }
        
    
    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < dimL; i++) {
            info = info  + " | Libro " + (i+1) + " | " + vector[i].toString() + "\n";
            info = info + " ------------------------------------------------------------------------------------------------- ";
        }
        return info;
    }
}
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
        System.out.print (estanTe.toString()); //imprimo el estante de libros
        
        //busco e informo el autor del libro mujercitas
        System.out.println ();
        System.out.println ("Libro Mujercitas: " + estanTe.tituloLibro("Mujercitas"));
        
    }
}
