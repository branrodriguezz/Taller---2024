
package tema1;
import PaqueteLectura.Lector;
//Paso 1: Importar la funcionalidad para lectura de datos

public class Ej02Jugadores {

  
    public static void main(String[] args) {
        /*2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de básquet y 
            las almacene en un vector. Luego informe:
            - la altura promedio
            - la cantidad de jugadores con altura por encima del promedio NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java
        */
        
        //Paso 2: Declarar la variable vector de double 
        double [] vector;
        //Paso 3: Crear el vector para 15 double 
        int df = 5;
        vector = new double [df];
        //Paso 4: Declarar indice y variables auxiliares a usar
        int i; double suma = 0;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (i = 0; i < df; i++){
            System.out.println("Ingrese una altura");
            vector[i] = Lector.leerDouble();
            suma = suma + vector [i];
        }
        //imprimo el vector 
        System.out.println("---- VECTOR DE ALTURAS ----");
        
        for (i = 0; i < df; i++)
              System.out.print("|" + vector [i] + "|");
        
        System.out.println ();
        
        //Paso 7: Calcular el promedio de alturas, informarlo
        System.out.println ();
        double promedio = suma/df;
        System.out.println("La altura promedio de los jugadores es: " + promedio);
        
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        int cant = 0;
        for (i = 0; i < df; i++) {
                if (vector [i] > promedio)
                    cant = cant + 1;
        }
        //Paso 9: Informar la cantidad.
        System.out.println("La cantidad de jugadores por encima del promedio es: " + cant);
    }
    
}
