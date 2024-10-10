/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2.practica.de.repaso;
import PaqueteLectura.Lector;
/**
 *
 * @author branroodriguez
 */
public class Ejercicio2PracticaDeRepaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        d) Realice un programa que instancie un estacionamiento con 3 pisos y 3 plazas por piso. 
        Registre 6 autos en el estacionamiento en distintos lugares.
        Muestre la representación String del estacionamiento en consola.
        Muestre la cantidad de autos ubicados en la plaza 1.
        Lea una patente por teclado e informe si dicho auto se encuentra en el estacionamiento o no.
        En caso de encontrarse, la información a imprimir es el piso y plaza que ocupa.
        */
        
        System.out.println ("------------------ Estacionamiento ------------------- ");
        System.out.println();
        
        System.out.print ("Nombre: ");
        String nombre = Lector.leerString();
        
        System.out.print ("Direccion: ");
        String direccion = Lector.leerString();
        
        System.out.print ("Hora de apertura: ");
        String horaA = Lector.leerString();
        
        System.out.print ("Hora de cierre: ");
        String horaC = Lector.leerString();
        
        System.out.print ("Pisos: 3 ");
        
        System.out.print ("Plazas: 3 ");
        
        Estacionamiento estacionamiento = new Estacionamiento (nombre,direccion,horaA,horaC,3,3);
       
        System.out.println ();
        
        for (int i = 0 ; i < 6; i++){
            System.out.println();
            
            System.out.println ("---------- Ingrese un auto ----------------");
            
            System.out.print ("Nombre: ");
            String nombreA = Lector.leerString();
        
            System.out.print ("Patente: ");
            String patente = Lector.leerString();
            
            Auto auto = new Auto (nombreA, patente);
            
            System.out.print ("Piso: ");
            int piso = Lector.leerInt();
        
            System.out.print ("Plaza: ");
            int plaza = Lector.leerInt();
            
            estacionamiento.registrarAuto(auto, piso, plaza);
        }
        
        System.out.println (estacionamiento.toString(3, 3));
        System.out.println();
        System.out.println (" La cantidad de autos ubicados en la plaza 1 es: " + estacionamiento.obtenerCantAutos(1, 3));
        System.out.println ();
        System.out.print (" Ingrese una patente: ");
        String patente1 = Lector.leerString();
        System.out.println (estacionamiento.obtenerString(patente1, 3, 3));
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Estacionamiento {
    /*
    2- Queremos un sistema para gestionar estacionamientos. Un estacionamiento conoce su nombre, 
    dirección, hora de apertura, hora de cierre, y almacena para cada número de piso (1..N) y 
    número de plaza (1..M), el auto que ocupa dicho lugar. De los autos se conoce nombre del dueño y patente.
    */
    private String nombre;
    private String direccion;
    private String horaApertura;
    private String horaCierre;
    private Auto [][] matriz;
    
    
    //constructores
    /*
    - Un constructor debe recibir nombre y dirección, e iniciar el estacionamiento con hora de apertura “8:00”,
        hora de cierre “21:00”, y para 5 pisos y 10 plazas por piso. El estacionamiento inicialmente 
    no tiene autos.
    - Otro constructor debe recibir nombre, dirección, hora de apertura, hora de cierre, el número de pisos (N)
    y el número de plazas por piso (M) e iniciar el estacionamiento con los datos recibidos y sin autos.
    */
    
    public Estacionamiento (String unNombre, String unaDireccion){
        this.setNombre (unNombre);
        this.setDireccion (unaDireccion);
        this.setHoraApertura ("8:00");
        this.setHoraCierre ("21:00");
        
        matriz = new Auto [5][10]; 
        
        /*for (int i = 0; i < 5; i++){
            for (int j = 0; j < 10; j++){
                matriz[i][j]= null;
                
            }
        }
        */
    }
    
    public Estacionamiento (String unNombre, String unaDireccion, String unaHoraA, String unaHoraC, int Pisos, int Plazas){
        this.setNombre (unNombre);
        this.setDireccion (unaDireccion);
        this.setHoraApertura(unaHoraA);
        this.setHoraCierre(unaHoraC);
        
        matriz = new Auto [Pisos][Plazas];
   
        /* for (int i = 0; i < Pisos; i++){
            for (int j = 0; j < Plazas; j++) 
                matriz [i][j] = null; 
        */
            
        
    }

    //metodos
    /*
    c) Implemente métodos para:
    - Dado un auto A, un número de piso X y un número de plaza Y, registrar al auto en el estacionamiento 
    en el lugar X,Y. Suponga que X, Y son válidos (es decir, están en rango 1..N y 1..M respectivamente) 
    y que el lugar está desocupado.
    - Dada una patente, obtener un String que contenga el número de piso y plaza donde está dicho auto en 
    el estacionamiento. En caso de no encontrarse, retornar el mensaje “Auto Inexistente”.
    - Obtener un String con la representación del estacionamiento. 
    Ejemplo: “Piso 1 Plaza 1: libre Piso 1 Plaza 2: representación del auto ...
    Piso 2 Plaza 1: libre ... etc”
    - Dado un número de plaza Y, obtener la cantidad de autos ubicados en dicha
    plaza (teniendo en cuenta todos los pisos).
    */
    
    
    public void registrarAuto (Auto A, int Piso, int Plaza){     
        matriz [Piso - 1][Plaza - 1] = A;
    }
    
    //preguntar por los parametros
    public String obtenerString (String patente, int piso1, int plaza2){ //obtener y retornar son lo mismo?
        int i = 0;
        int j, piso = 0, plaza = 0;
        boolean encontre = false;
        while (i < piso1 && encontre == false) { //recorro hasta 3 y 3?
            j = 0;
            while (j < plaza2 && encontre == false){
                if (matriz[i][j] != null) {
                    if (matriz [i][j].getPatente().equals(patente)) {
                        encontre = true;
                        piso = i;
                        plaza = j;
                    }
                }
                j++;
            }
            i++;
        }
        String aux;
        if (encontre == true) {
            aux = " La patente se encuentra en el piso: " + (piso+1) + " , plaza: " + (plaza+1);
        }
        else
            aux = "No se encontro la patente";
        return aux;
    } 
    //- Obtener un String con la representación del estacionamiento. 
   // Ejemplo: “Piso 1 Plaza 1: libre Piso 1 Plaza 2: representación del auto ...
    //Piso 2 Plaza 1: libre ... etc”
    
    public String toString (int piso, int plaza){ //preguntar x los parametros o directamente recorro de 3 a 3 
        String aux = " -------------------------- Estacionamiento ----------------------------" + "\n";
                    for (int i = 0; i < piso; i++){
                        for (int j = 0; j < plaza; j++){
                            aux = aux +  " Piso " + (i+1) + " Plaza " + (j+1) + ":";
                            if (matriz [i][j] == null)  //preg
                                aux = aux + " Libre " + "\n";
                            else
                                aux = aux + matriz[i][j].toString() + "\n";
                        }
                        aux =  aux + " ------------------------------------------------------ " + "\n";
                    }
                    return aux;
    }
    
    //- Dado un número de plaza Y, obtener la cantidad de autos ubicados en dicha
    //plaza (teniendo en cuenta todos los pisos).
    
    public int obtenerCantAutos (int numPlaza, int piso){ //preg por el param piso
        int cant = 0;
        for (int i = 0; i < piso; i++){
            if (matriz[i][numPlaza - 1] != null){
                cant = cant + 1;
            }
        }
        return cant;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.practica.de.repaso;

/**
 *
 * @author branroodriguez
 */
public class Auto {
    private String nombreDuenio;
    private String patente;
    
    public Auto (String nombreD, String patentee){
        this.setNombreDuenio (nombreD);
        this.setPatente (patentee);
    }
    
    //METODOS 

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public String getPatente() {
        return patente;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    @Override
    public String toString (){
        String aux = "" + " Dueño: " +
                    this.getNombreDuenio() + 
                    " Patente: " +
                    this.getPatente();
        return aux;
    }
    
}
