package tema2;

import PaqueteLectura.Lector;

/**
 *
 * @author branroodriguez
 */
public class PersonaLeida {
        public static void main (String[] args) {
            
            System.out.print ("Ingrese un nombre para la persona: ");
            String nombre = Lector.leerString();
            System.out.println();
            
            System.out.print ("Ingrese un dni para la persona: ");
            int DNI = Lector.leerInt();
            System.out.println();
            
            System.out.print ("Ingrese una edad para la persona: ");
            int edad = Lector.leerInt();
            System.out.println();
            
            Persona p1 = new Persona (nombre, DNI, edad);
            
            System.out.println (p1.toString());
            
        }
}
