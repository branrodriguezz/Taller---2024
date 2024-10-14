/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4.practica.de.repaso;
import PaqueteLectura.Lector;
/**
 *
 * @author branroodriguez
 */
public class Ejercicio4PracticaDeRepaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        c. Escriba un programa que instancie un coro de cada tipo. Lea o bien la cantidad de coristas 
        (en el caso del coro semicircular) o la cantidad de hileras e integrantes por hilera
        (en el caso del coro por hileras). Luego cree la cantidad de coristas necesarios, 
        leyendo sus datos, y almacenándolos en el coro. Finalmente imprima toda la información de los coros
        indicando si están bien formados o no.
        */
        
        Director director = new Director ("Juan",36789021,45, 10); //nombre,dni,edad,antiguedad
        
        coroHilera CoroHilera = new coroHilera ("El evangelio", director, 3, 2); //nombre, director, integrantes x hilera, hileras
        
        for (int i = 0; i < 6; i++){
            System.out.print ("Nombre: ");
            String nombre = Lector.leerString();
            System.out.print ("DNI: ");
            int dni = Lector.leerInt();
            System.out.print ("Edad: ");
            int edad = Lector.leerInt();
            System.out.print ("Tono fundamental: ");
            int tonoFundamental = Lector.leerInt();
            Corista corista = new Corista (nombre,dni,edad,tonoFundamental);
            CoroHilera.agregarCorista(corista);
        }
        
        System.out.println ("El coro de hileras esta bien formado: " + CoroHilera.bienFormado());
        System.out.println (CoroHilera.toString());
    }
    
}
