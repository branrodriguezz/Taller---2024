/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author branroodriguez
 */
public class ej02 {
    /*
    2- Utilizando la clase Persona. 
    Realice un programa que almacene en un vector a lo sumo 15 personas. 
    La información (nombre, DNI, edad) se debe generar aleatoriamente hasta obtener edad 0. 
    Luego de almacenar la información:
    - Informe la cantidad de personas mayores de 65 años.
    - Muestre la representación de la persona con menor DNI.
    */
    public static void main (String[] args ) {
        int DF = 15;
        
        Persona [] vector = new Persona [DF];
        
            GeneradorAleatorio.iniciar();
            
            int edad = GeneradorAleatorio.generarInt(6);
            int DL = 0;
            String nombre;
            int DNI;
            
            //CARGO EL VECTOR DE A LO SUMO 15 PERSONAS
            while ((edad != 0) && (DL < DF)){
                nombre = GeneradorAleatorio.generarString(8);
                DNI = GeneradorAleatorio.generarInt(40000);
                vector [DL] = new Persona (nombre, DNI, edad);
                DL++;
                edad = GeneradorAleatorio.generarInt(100);
            
            }
            
            System.out.println(" VECTOR DE PERSONAS ");
            System.out.println();
            //IMPRIMO EL VECTOR DE PERSONAS
            int i;
            for (i = 0; i < DL; i++) {
                System.out.println (vector[i].toString());
                System.out.println (" ");
            }
            
            //BUSCO LA CANTIDAD DE PERSONAS MAYORES A 65 AÑOS Y LA PERSONA CON MENOR DNI
            int cant65 = 0;
            int min = 9999;
            Persona perMin = null;
            
            for (i = 0; i < DL; i++) {
                if (vector [i].getEdad() > 65 )
                    cant65 = cant65 + 1;
                
                if (vector [i].getDNI() < min) {
                    min = vector [i].getDNI();
                    perMin = vector [i];
                }
                
            }
            
            //INFORMO LO PEDIDO
            
            System.out.println ("La cantidad de personas mayores a 65 años es: " + cant65);
            System.out.println();
            
            if (perMin != null) 
                System.out.println ("La persona con menor DNI es: " + perMin.toString());
            else
                System.out.println ("No hay personas en el vector");
    }
}
