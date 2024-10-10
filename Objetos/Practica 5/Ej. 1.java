/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1.practica.de.repaso;
import PaqueteLectura.Lector;
/**
 *
 * @author branroodriguez
 */
public class Ejercicio1PracticaDeRepaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //iii) Escriba un programa que instancie un proyecto con tres investigadores. 
        //Agregue dos subsidios a cada investigador y otorgue los subsidios de uno de ellos. 
        //Luego imprima todos los datos del proyecto en pantalla.
        
        UNLP proyecto = new UNLP ("No mas paros", 123, "Juan");
        
        //se puede hacer con un for?
        for (int i = 0; i < 3; i++){
            System.out.println ();
            System.out.print ("Investigador numero: " + i);
            System.out.println ();
            System.out.print ("Nombre: ");
            String nombre = Lector.leerString();
            System.out.print ("Categoria de (1 a 5): ");
            int cat = Lector.leerInt();
            System.out.print ("Especialidad: ");
            String especialidad = Lector.leerString();
            
            Investigador investigador = new Investigador (nombre, cat, especialidad);
            
            System.out.println ("------------- Subsidio del investigador ----------------- ");
            for (int j = 0; j < 2; j++){
                System.out.print ("Monto: ");
                double monto = Lector.leerDouble();
                System.out.print ("Motivo: ");
                String motivo = Lector.leerString();

                Subsidio subsidio = new Subsidio (monto, motivo );
                investigador.agregarSubsidio(subsidio);
                proyecto.agregarInvestigador(investigador);
            }
        }
        
        System.out.println ("------------------ Otorgar el subsidio de uno de ellos -------------------- ");
        System.out.print ("Nombre: ");
        String nombre = Lector.leerString();
        proyecto.otorgarTodos(nombre);
        
        //informo
        System.out.println (proyecto.toString());
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class UNLP { //administra proyectos
    /*
    1- La UNLP desea administrar sus proyectos, investigadores y subsidios. 
    Un proyecto tiene: nombre, código, nombre completo del director y los investigadores que participan en 
    el proyecto (50 como máximo). De cada investigador se tiene: nombre completo, categoría (1 a 5) y especialidad. 
    Además, cualquier investigador puede pedir hasta un máximo de 5 subsidios. 
    De cada subsidio se conoce: el monto pedido, el motivo y si fue otorgado o no
    */
    
    private String nombre;
    private int codigo;
    private String director;
    private Investigador [] vectorInvestigadores; //50 como max
    private int dimLInvestigador; //preguntar
    
    
    //constructor
    public UNLP (String unNombre, int unCodigo, String unDirector){
        this.setNombre (unNombre);
        this.setCodigo (unCodigo);
        this.setDirector (unDirector);
        
        //inicializo el vector de investigadores en null
        
        vectorInvestigadores = new Investigador [50];
        for (int i = 0; i < 50; i++) {
            vectorInvestigadores [i] = null;
        }
    }
    
    //metodos
    
    //a. void agregarInvestigador(Investigador unInvestigador);
    // agregar un investigador al proyecto.
    
    public void agregarInvestigador (Investigador unInvestigador) {
        if (this.getDimLInvestigador() < 50) {
            vectorInvestigadores[this.getDimLInvestigador()] = unInvestigador;
            this.setDimLInvestigador(1); //preguntar
        }
    }
    //c. double dineroTotalOtorgado();
    //devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
    //todos los subsidios otorgados de todos los investigadores)
    public double dineroTotalOtorgado (){
        double aux = 0;
        for (int i = 0; i < this.dimLInvestigador; i++) 
            aux = aux + vectorInvestigadores [i].dineroTotalOtorgadoInvestigador();
        return aux;
    }
    
    //d. void otorgarTodos(String nombre_completo);
    //otorgar todos los subsidios no-otorgados del investigador llamado
    //nombre_completo
    public void otorgarTodos (String nombre_completo){
        int i = 0;
        boolean encontre = false;
        while (i < this.dimLInvestigador && encontre == false) {
            if (vectorInvestigadores[i].getNombre().equals(nombre_completo)) 
                encontre = true;
        }
        if (encontre == true) 
            vectorInvestigadores[i].otorgarSubsidios(); //
        else 
            System.out.println ("No se encontro ese investigador");
    }
    
    //metodo to string
    //e. String toString();
    // devolver un string con: nombre del proyecto, código, nombre del director, el total de dinero 
    //otorgado del proyecto y la siguiente información de cada investigador: nombre, categoría, especialidad, 
    //y el total de dinero de sus subsidios otorgados.
    
    @Override
    public String toString (){
        String aux = " Proyecto: "  +
                     this.getNombre() + " codigo " + 
                     this.getCodigo() + " nombre del director " + 
                     this.getDirector() + " el total de dinero otorgado del proyecto es: " +
                     this.dineroTotalOtorgado();
                     for (int i = 0; i < this.getDimLInvestigador(); i++) {
                         aux = aux + " | " + vectorInvestigadores[i].toString() + " | " + "\n";
                     }
        return aux;
    }
    
    //getter y seter
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setCodigo (int codigo){
        this.codigo = codigo;
    }
    public void setDirector (String director){
        this.director = director;
    }
    
    //get
    public String getNombre (){
        return nombre;
    }
    
    public int getCodigo (){
        return codigo;
    }
    
    public String getDirector (){
        return director;
    }
    
    public int getDimLInvestigador (){
        return dimLInvestigador;
    }
    
    //preguntar si lo puedo inicializar aca o en la declaracion de variable
    private void setDimLInvestigador (int dimLInvestigador){
        this.dimLInvestigador = 0 + dimLInvestigador; //preguntar
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Investigador {
    /*
    De cada investigador se tiene: nombre completo, categoría (1 a 5) y especialidad. 
    Además, cualquier investigador puede pedir hasta un máximo de 5 subsidios. 
    De cada subsidio se conoce: el monto pedido, el motivo y si fue otorgado o no.
    */
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio [] vectorSubsidios;
    private int dimLSubsidios;
    
    //constructor
    //b. Un investigador sólo debería poder construirse con nombre, categoría y
    //especialidad.
    public Investigador (String unNombre, int unaCategoria, String unaEspecialidad){
        this.setNombre (unNombre);
        this.setCategoria (unaCategoria);
        this.setEspecialidad (unaEspecialidad);
        //inicializo el vector de subsidios
        vectorSubsidios = new Subsidio [5]; //preguntar si aca o en la declaracion de variables.
        for (int i = 0; i < 5; i++){
            vectorSubsidios [i] = null;
        }
    }
    
    
    //metodo 
    //b. void agregarSubsidio(Subsidio unSubsidio); // agregar un subsidio al investigador.
    public void agregarSubsidio (Subsidio unSubsidio) {
        if (this.getDimLSubsidios() < 5) {
            vectorSubsidios [this.getDimLSubsidios()] = unSubsidio;
            this.setDimLSubsidios(1);
        }
    }
    
    //. double dineroTotalOtorgado();
    //devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
    //todos los subsidios otorgados de todos los investigadores)
    
    public double dineroTotalOtorgadoInvestigador (){
        double total = 0;
        for (int i = 0; i < this.getDimLSubsidios(); i++) 
            if (vectorSubsidios [i].getOtorgado() == true) //no me deja usar un equals si es boolean? solo con strings?
                total = total + vectorSubsidios[i].getMontoPedido();
                
        return total;
    }
    
    //metodo otorgar - privado, porque no quiero que cualquiera otorge solo el de un nombre de investigador en especifico?
     
    public void otorgarSubsidios (){
        for (int i = 0; i < this.dimLSubsidios; i++)
            vectorSubsidios[i].setOtorgado(true);
    }
    
    //metodo to string
    //la siguiente información de cada investigador: nombre, categoría, especialidad, 
    public String toString (){
        String aux = " Nombre: " + this.getNombre() + " Categoria: " +
                     this.getCategoria() + " Especialidad: " + this.getEspecialidad() +
                     " Total de dinero de sus subsidios otorgados: " + this.dineroTotalOtorgadoInvestigador();
        return aux;
    }
    //metodos get y set
    public String getNombre (){
        return nombre;
    }
    
    public int getCategoria (){
        return categoria;
    }
    
    public String getEspecialidad (){
        return especialidad;
    }
    
    public int getDimLSubsidios (){
        return dimLSubsidios;
    }
    
    //set
    
    public void setNombre (String unNombre){
        this.nombre = unNombre;
    }
    
    //preguntar si chequeo aca si esta en el rango o cuando genero o leo numeros
    public void setCategoria (int categoria){
        if (categoria >= 1 && categoria <= 5) 
            this.categoria = categoria;
    }
    
    public void setEspecialidad (String especialidad){
        this.especialidad = especialidad;
    }
    
    private void setDimLSubsidios (int subsidios){
        this.dimLSubsidios = 0 + subsidios;
    }
            
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Subsidio {
    /*
    De cada subsidio se conoce: el monto pedido, el motivo y si fue otorgado o no.
    */
    private double montoPedido;
    private String motivo;
    private boolean otorgado;
    
    //constructor
    //c. Un subsidio sólo debería poder construirse con el monto pedido y el motivo.
    //Un subsidio siempre se crea en estado no-otorgado.
    
    public Subsidio (double monto, String motivo){
        this.setMontoPedido (monto);
        this.setMotivo (motivo);
        this.setOtorgado (false); //preguntar
    }
    //metodos get y set
    
    public void setMontoPedido (double monto){
        this.montoPedido = monto;
    }
    public void setMotivo (String motivo){
        this.motivo = motivo;
    }
    public void setOtorgado (boolean otorgado){
        this.otorgado = otorgado;
    }
    
    //get
    public double getMontoPedido (){
        return montoPedido;
    }
    
    public String getMotivo (){
        return motivo;
    }
    
    public boolean getOtorgado (){
        return otorgado;
    }
}
