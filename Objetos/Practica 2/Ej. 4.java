/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author branroodriguez
 */
public class ej04 {
    /*
    4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
    a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad) y el día en que se quiere presentar al casting. 
    La persona debe ser inscripta en ese día, en el siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación. 
    La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de casting.
    Una vez finalizada la inscripción:
    b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la persona a entrevistar en cada turno asignado.
    */
    
    public static void main (String[] args){
        int F = 5; //representa los dias
        int C = 8; //representa las personas / turnos
        Persona [][] matriz = new Persona [F][C];
        //vector de dimensiones logicas. Dia 1: dimL = cantidad de personas anotadas con turno ese dia
        int [] vector = new int [5];
        
        //inicializo vector contador de dias y sus dimensiones logicas
        for (int i = 0; i < F; i++ ) {
            vector [i] = 0;
        }
        
        String nombre;
        System.out.print ("Nombre: ");
        nombre = Lector.leerString();
        int DNI;
        int edad;
        int dia;
        int i = 0;
        
        GeneradorAleatorio.iniciar();
        
        while (!nombre.equals("ZZZ") && i != 40) {
            System.out.print ("Dia: ");
            System.out.print (dia = GeneradorAleatorio.generarInt(5) + 1);
            System.out.println ();
            //aumento la cantidad de elementos 
            i++;
            if (!nombre.equals("ZZZ") && vector[dia - 1] < C) { //me fijo si no llegue al final del vector en la posicion de ese dia 
                System.out.print ("DNI: ");
                DNI = Lector.leerInt();
                System.out.print ("Edad: ");
                System.out.print (edad = GeneradorAleatorio.generarInt(100));
                System.out.println ();
                matriz [dia - 1][vector[dia - 1]] = new Persona (nombre, DNI, edad);
                vector[dia - 1]++; //aumento la dimension logica de turnos de ese dia asi se carga directamente en esa pos dentro del vector
                System.out.print ("Nombre: ");
                nombre = Lector.leerString();
            }
            else 
                System.out.println ("No existe turno disponible ese dia");
        }
        
        //informo la cantidad de inscriptos al casting para cada dia
        System.out.println ("--------------- VECTOR DE INSCRIPTOS ------------------");
        for (i = 0; i < F; i++){
            System.out.println ("La cantidad de inscriptos para el dia " + (i + 1) + " es " + vector [i]);
            System.out.println();
        }
        
        System.out.println ("--------------- MATRIZ DE PERSONAS INSCRIPTAS -----------");
        //informo el nombre de la persona a entrevistar en cada turno asignado
        for (i = 0; i < F ; i++){
            if (vector [i] != 0 ) {
                System.out.println ("Dia: " + (i+1));
                System.out.println (" ");
                    for (int j = 0; j < vector [i]; j++) {
                        System.out.print ("Turno: " + (j+1) + " | ");
                        System.out.println ("Nombre: " + matriz [i][j].getNombre() + " | ");
                    }
            }
            System.out.println (" ");
        }    
    }
}
