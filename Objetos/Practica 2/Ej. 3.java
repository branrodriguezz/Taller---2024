/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author branroodriguez
 */
public class ej03 {
    /*
    3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y 
    en cada día se entrevistarán a 8 personas en distinto turno.
    a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide nombre, 
    DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las personas 
    primero completan el primer día en turnos sucesivos, luego el segundo día y así siguiendo. 
    La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de casting.
    Una vez finalizada la inscripción:
    b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
    NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. 
    Para comparar Strings use el método equals.
    */
    
    public static void main (String[] args) {
        
        int Dias = 5;
        int Turnos = 8;
        String CORTE = "ZZZ";
        Persona [][] matriz = new Persona [Dias][Turnos];
        
        String nombre;
        int DNI;
        int edad;
        
        int DL = 0; //dimension logica de los 5 dias
        int DLT; //dimension logica de los turnos, necesaria??
        
        int i, j;
        
        //CONSULTAS
        //inicializo la matriz? hasta donde? 
        //esta mal si en un dia no hay 8 personas?
        
        System.out.print ("Nombre: ");
        nombre = Lector.leerString();
        
        GeneradorAleatorio.iniciar();
        
        //carga de informacion
        while (DL < Dias && !nombre.equals(CORTE)){ 
            for (j = 0; j < Turnos && !nombre.equals(CORTE); j++) {
                DNI = GeneradorAleatorio.generarInt(40000); //esta bien si yo declaro la variable dentro del bucle?
                edad = GeneradorAleatorio.generarInt(100);
                matriz [DL][j] = new Persona (nombre, DNI, edad);
                System.out.print ("Nombre: ");
                nombre = Lector.leerString();
            }
            DL++;
        }
        
        System.out.println ();
        System.out.println ("La dimension logica o los dias de casting son en total: " + DL);
        System.out.println();
        
        System.out.println ("------- MATRIZ DEL CASTING -------");
        
        //chequeo si la matriz se cargo bien
        for (i = 0; i < DL; i++ ){
            System.out.println ("Dia: " + (i+1)); //preguntar
            System.out.println ("--------------------------------------------------------------------------------");
            for (j = 0; j < Turnos; j++) {
                if (matriz [i][j] != null) {
                    System.out.print ("Turno: " + (j+1) + " | "); //preguntar
                    System.out.println ("Persona a entrevistar: " + matriz [i][j].toString() + " | ");
                }
            }
            System.out.println ("--------------------------------------------------------------------------------");
        }
        
        
    }
}
