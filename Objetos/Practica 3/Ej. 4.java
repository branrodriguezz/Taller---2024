/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

public class Persona {

    private String nombre;
    private int DNI;
    private int edad;

    public Persona(String unNombre, int unDNI, int unaEdad) {
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad;
    }

    public Persona() {

    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int unDNI) {
        DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    @Override
    public String toString() {
        String aux;
        aux = "Nombre: " + nombre + ", DNI: " + DNI + " Edad: " + edad + " años.";
        return aux;
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
public class Habitacion {
    //De cada habitación conoce costo por noche, si está ocupada y, en caso de estarlo, 
    //guarda el cliente que la reservó (nombre, DNI y edad).
    private Double costo;
    private Boolean ocupada;
    //solo si la habitacion esta ocupada.
    private Persona cliente;
    
    //constructor que recibe un costo y lo inicializo en el constructor del hotel
    public Habitacion (Double Uncosto, Boolean Ocu){
        costo = Uncosto;
        ocupada = Ocu;
    }
    
    //constructor para crear una habitacion con costo, si esta ocupada o no, y un cliente
    public Habitacion (Double unCosto, Boolean unOcupada, Persona unCliente) {
        costo = unCosto;
        ocupada = unOcupada;
        cliente = unCliente;
    }

    public void setCosto(Double uncosto) {
        costo = uncosto;
    }

    public void setOcupada(Boolean unocupada) {
        ocupada = unocupada;
    }

    public void setCliente(Persona uncliente) {
        cliente = uncliente;
    }

    public Double getCosto() {
        return costo;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    public Persona getCliente() {
        return cliente;
    }
    
    public void cargarCliente (Persona uncliente) {
        cliente = uncliente;
    } 
    
    @Override
    public String toString (){ //chequea si la variable ocupada esta en true - signfica que esta ocupada la habitacion
        String aux;
        if (ocupada.equals(true))
           return aux = " Costo: " + costo + " Ocupada " + cliente.toString();
        else //sino imprimo que esta libre
           return aux =  " Costo: " + costo + " Libre ";
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author branroodriguez
 */
public class Hotel {
    //el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/ 2000 y 8000.
    //vector porque nunca aclara nada de pisos.
    private Habitacion [] vector;
    
    //constructor que recibe un entero N que determina la cantidad de habitaciones del Hotel; 
    //cada una desocupada y con costo aleatorio e/ 2000 y 8000.
    int num;
    public Hotel (int N){
        num = N;
        //creo un hotel
        vector = new Habitacion [N]; //preguntar
        for (int i = 0; i < num; i++) {
            //inicializo todas las habitaciones con costo e/ 2000 y 8000 y habitaciones desocupadas
            Double costo = GeneradorAleatorio.generarDouble(8000) + 2000;
            Boolean ocupad = false;
            vector[i] = new Habitacion (costo, ocupad);
        }
    }
    
    

    public Habitacion[] getVector() {
        return vector;
    }

    public void setVector(Habitacion[] unvector) {
        vector = unvector;
    }
    
    /*
    (iii) Implemente en las clases que corresponda todos los métodos necesarios para:
    - Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
    en el rango 1..N) y que la habitación está libre.
    - Aumentar el precio de todas las habitaciones en un monto recibido.
    - Obtener la representación String del hotel, siguiendo el formato:
    {Habitación 1: costo, libre u ocupada, información del cliente si está ocupada} ...
    {Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
    */
    
    //- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
    //en el rango 1..N) y que la habitación está libre.
    //recibo un boolean de si la hab. esta ocupada o no.
    public void ingresarCliente (Persona C, int X, Boolean Ocup) {
        vector [X].cargarCliente(C);
        vector [X].setOcupada(Ocup);
    }
    //- Aumentar el precio de todas las habitaciones en un monto recibido.
    //la variable num guardo en el constructor la cantidad de habitaciones
    public void aumentarPrecio (double costito) {
        for (int i = 0; i < num; i++) //preg
            vector[i].setCosto(vector[i].getCosto() + costito);
    }
    /*
    - Obtener la representación String del hotel, siguiendo el formato:
    {Habitación 1: costo, libre u ocupada, información del cliente si está ocupada} ...
    {Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
    */
    
    public void imprimir (){ //preguntar; habia q hacer un to string?
        for (int i = 0; i < num; i++) {
            System.out.print (" | Habitacion " + (i+1) + " |");
            System.out.print (vector[i].toString()); //imprimo siempre si esta o no esta ocupada.
            System.out.println ();
            System.out.print (" ------------------------------------------------------------------------------------------------- ");
            System.out.println();
        }
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
public class ej04 {
    /*
    B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
    muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
    NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe delegar la 
    responsabilidad de la operación.
    */
    
    public static void main (String[] args) {
        
        Hotel hotel = new Hotel (5); //instancio un hotel de 5 habitaciones e inicializo todas libres y con costos aleatorios e/ 2000 y 8000
        String nombre;
        int edad, DNI;
        //ingreso clientes en distintas habitaciones
        System.out.print ("Nombre: ");
        nombre = Lector.leerString();
        
        int i = 0;
        while (i < 5 && !nombre.equals("ZZZ")) {
            System.out.print ("DNI: ");
            DNI = Lector.leerInt();
        
            System.out.print ("Edad: ");
            edad = Lector.leerInt();
            
            Persona cli = new Persona (nombre, DNI, edad);
            
            hotel.ingresarCliente(cli, i, true); //pongo la vi de la habitacion en ture para simbolizar que ya esta reservada
            
            System.out.print ("Nombre: ");
            nombre = Lector.leerString();
            
            i++;
        }
        
        System.out.println (" -------------------------- HOTEL CON N HABITACIONES --------------------------------");
        //muestro el hotel
        hotel.imprimir();
        System.out.println ();
        
        //aumento el precio de las habitaciones
        hotel.aumentarPrecio(1000);
        
        System.out.println (" -------------------------- HOTEL CON N HABITACIONES POST AUMENTO DEL COSTO -------------------");
        //muestro de nuevo el hotel
        hotel.imprimir();
    }
}
