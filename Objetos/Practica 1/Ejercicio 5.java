package tema1;

import PaqueteLectura.Lector;

public class Ej05 {
    
public static void main(String[] args) {
    
    /*
    5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen (con puntaje de 1 a 10) 
    los siguientes aspectos: (0) Atención al cliente (1) Calidad de la comida (2) Precio (3) Ambiente.
    Escriba un programa que lea desde teclado las calificaciones de los cinco clientes para cada uno de los 
    aspectos y almacene la información en una estructura. Luego imprima la calificación promedio 
    obtenida por cada aspecto.
    */
    
    int [][] matriz = new int [5+1][4]; //matriz de 5 clientes con sus puntajes a cada uno de los 4 aspectos.
        
        int i,j;
        
        //inicializo el vector de puntajes enteros (1..10)
        for (i = 1; i <= 5; i++) {
            for (j = 0; j < 4; j++)
                matriz [i][j] = 0;
        }
        
        int puntaje;
                
        //cargo el matriz de puntajes de enteros (1..10)
        for (i = 1; i <= 5; i++) {
                System.out.println("Ingrese un puntaje (entre 1 y 10) de atencion al cliente: ");
                puntaje = Lector.leerInt ();
                matriz [i][0] = puntaje;
                
                System.out.println("Ingrese un puntaje (entre 1 y 10) de calidad de comida: ");
                puntaje = Lector.leerInt ();
                matriz [i][1] = puntaje;
                
                System.out.println("Ingrese un puntaje (entre 1 y 10) de precio: ");
                puntaje = Lector.leerInt ();
                matriz [i][2] = puntaje;
                
                System.out.println("Ingrese un puntaje (entre 1 y 10) de comida: ");
                puntaje = Lector.leerInt ();
                matriz [i][3] = puntaje;
        }
        
        System.out.print ("---- Puntajes (5X4) ----");
        System.out.println ();
        
        for (i = 1; i <= 5; i++) {
            System.out.println ();
            System.out.println ("Cliente: " + i + " | ");
            System.out.print ("Atencion: " + matriz [i][0] + " | ");
            System.out.print ("Calidad de comida: " + matriz [i][1] + " | ");
            System.out.print ("Precio: " + matriz [i][2] + " | ");
            System.out.print ("Ambiente: " + matriz [i][3] + " | ");
            System.out.println ();
        }
        System.out.println ();
        
        double total;
        for (j = 0; j < 4; j++){//recorro las columnas de aspectos
            total = 0;
            for (i = 1; i <= 5; i++)
                total = total + matriz [i][j];
            System.out.println ("La calificacion promedio del aspecto " + j + " es " + total/5.0);
            System.out.println ();
        } 
    }
}
