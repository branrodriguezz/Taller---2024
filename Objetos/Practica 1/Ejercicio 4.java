package tema1;

import PaqueteLectura.GeneradorAleatorio;

public class Ej4  {
    /*
    4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso (1..4). 
    Realice un programa que permita informar la cantidad de personas que concurrieron a cada oficina
    de cada piso. 
    Para esto, simule la llegada de personas al edificio de la siguiente manera: a cada persona se le pide el nro. 
    de piso y nro. de oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar 
    un nro. de piso 9. Al finalizar la llegada de personas, informe lo pedido.
    */

public static void main(String[] args) {
    
    int [][] matriz = new int [8][4];
    
        int i,j;
        
        //prueba de la matriz 
        
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 4; j++)
                matriz [i][j] = GeneradorAleatorio.generarInt(3);
        }
        
        System.out.print ("---- MATRIZ DE ENTEROS (8X4) ----");
        
        for (i = 0; i < 8; i++) {
            System.out.println ();
            for (j = 0; j < 4; j++)
                System.out.print ("Pos: (" + i + "," + j + ") " + matriz [i][j] + " | ");
                }
        System.out.println ();
        
        //inicializo la matriz de enteros 
        
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 4; j++)
                matriz [i][j] = 0;
        }
    
        GeneradorAleatorio.iniciar();
    
        //cargo la matriz
        int piso;
        int oficina;
        piso = GeneradorAleatorio.generarInt(9) + 1;
        oficina = GeneradorAleatorio.generarInt(4) + 1;
        while (piso != 9) {
            matriz [piso-1][oficina-1]= matriz [piso - 1][oficina - 1] + 1;
             System.out.println ("Piso: " + (piso) );
             System.out.println ("Oficina: " + (oficina) );
        
            piso = GeneradorAleatorio.generarInt(9) + 1;
            oficina = GeneradorAleatorio.generarInt(4) + 1;
        }
        
        //imprimo matriz de personas
        System.out.println();
        System.out.print ("---- MATRIZ DE PERSONAS (8X4) ----");
        for (i = 0; i < 8; i++) {
            System.out.println();
            System.out.println ("Piso: " + (i+1));
            for (j = 0; j < 4; j++) {
                System.out.print ("Oficina: " + (j+1) + " | ");
                System.out.print ("Personas: " + matriz [i][j] + " | ");
            }
            System.out.println ();
        }
    }

}
