package tema1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

//Paso 1. importar la funcionalidad para generar datos aleatorios

public class Ej03Matrices {
    /*
    3- Escriba un programa que defina una matriz de enteros de tamaño 5x5. 
    Inicialice la matriz con números aleatorios entre 0 y 30.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de los elementos de la fila 1
- Generar un vector de 5 posiciones donde cada posición j contiene la suma
de los elementos de la columna j de la matriz. Luego, imprima el vector.
- Leer un valor entero e indicar si se encuentra o no en la matriz. 
    En caso de encontrarse indique su ubicación (fila y columna) en caso contrario
        imprima “No se encontró el elemento”.
NOTA: Dispone de un esqueleto para este programa en Ej03Matrices.java
    */

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
	GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int [][] matriz = new int [5][5];
        int i,j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++)
                    matriz [i][j] = GeneradorAleatorio.generarInt(10);
        }
        //Paso 4. mostrar el contenido de la matriz en consola
        System.out.print ("---- MATRIZ DE ENTEROS (5X5) ----");
        for (i = 0; i < 5; i++) {
            System.out.println ();
            for (j = 0; j < 5; j++)
                    System.out.print (matriz [i][j] + " | ");
        }
        System.out.println ();
        
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        
        int suma = 0;
        for (j = 0; j < 5; j++){
            suma = suma + matriz [1][j];
        }
        System.out.println ();
        System.out.println ("La suma de los elementos de la fila 1 es: " + suma);
        System.out.println ();
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        
        int [] vector = new int [5];
        int sumita;
        
        for (j = 0; j < 5; j++){ //primero recorro las columnas y luego las filas
            sumita = 0;
            for (i = 0; i < 5; i++)
                sumita = sumita + matriz [i][j];
       
            vector [j] = sumita; //asigno a la posicion j - que tambien es la columna j de la matriz; la suma de esa columna
        }
        
        System.out.println ("--- VECTOR DE SUMAS DE LAS COLUMNAS ---");
        
        for (j = 0; j < 5; j++)
            System.out.print (vector [j] + " | ");
        
        System.out.println ();
                
        /*Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. 
        En caso de encontrarse indique su ubicación (fila y columna)
        y en caso contrario imprima "No se encontró el elemento".
        */   
        
        System.out.println ("Ingrese un valor entero: ");
        int valor = Lector.leerInt();
        boolean b = false;
        int fila = 0;
        int columna = 0;
        i = 0;
        while (i < 5 && b==false) {
            j = 0; //reinicio j a 0 para cada nueva fila
            while (j < 5 && b==false) { //necesaria?
                if (matriz[i][j] == valor){
                    b = true;
                    fila = i;
                    columna = j;
                }
                j++;
            }
            i++;
        }
        
        if (b == true) {
            System.out.println ("Ubicacion: (F" + fila + ", C" + columna + ")");
        }
        else {
            System.out.println ("No se encontro el elemento");
        }
    }
}
