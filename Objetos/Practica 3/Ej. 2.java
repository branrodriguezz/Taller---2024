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
     
    
    public Libro(  String unTitulo,  String unaEditorial, 
    int unAñoEdicion,  Autor unPrimerAutor, String unISBN, double unPrecio){
         titulo = unTitulo;
         editorial = unaEditorial; 
         añoEdicion= unAñoEdicion;
         primerAutor = unPrimerAutor;
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
        aux= titulo + " por " + primerAutor + " - " + añoEdicion + " - " + " ISBN: " + ISBN;
       return ( aux);
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
        String aux = "Nombre: " + nombre + " biografia " + biografia + " origen " + origen;
        return aux;
    }
    
    
}

/*
Demo que crea objetos Libro invocando a los constructores definidos. 
 */
package tema3;

/**
 *
 * @author vsanz
 */
public class Demo01ConstructoresLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
            B- Modifique el programa Demo01Constructores (carpeta tema3) para instanciar los libros con su autor, 
            considerando las modificaciones realizadas. 
            Luego, a partir de uno de los libros instanciados, obtenga e imprima la representación del autor de ese libro.
        */
        
        Autor autor = new Autor ("Herbert Schildt", "Profesor", "Escoces");
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,   
                                  autor , "978-0071809252", 21.72);
        Autor autor2 = new Autor ("John Horton", "Bombero", "Frances");
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                                autor2 , "978-1512108347");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        System.out.println(libro2.getPrimerAutor());
    }
    
}
