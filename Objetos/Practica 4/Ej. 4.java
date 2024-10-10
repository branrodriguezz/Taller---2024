/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author branroodriguez
 */
public class Ej04 {
    /*
    f) Realice un programa principal que cree un Sistema con reporte anual para 3 años consecutivos a partir del 2021, para la estación La Plata (latitud-34.921 y 
    longitud -57.955). Cargue todas las temperaturas (para todos los meses y años). Informe los promedios anuales, y el mes y año en que se registró 
    la mayor temperatura.
    Luego cree un Sistema con informe mensual para 4 años a partir de 2020, para la estación Mar del Plata (latitud -38.002 y longitud -57.556). 
    Cargue todas las temperaturas (para todos los meses y años). Informe los promedios mensuales, y el mes y año en que se registró la mayor temperatura.
    */
    
    public static void main (String[] args){
        
        Estacion estacion = new Estacion ("La Plata" , - 34.921 , - 57.955);
        PromedioHistoricoAnual sistemaAnual = new PromedioHistoricoAnual (estacion, 2021, 3);
        
        //seteo las temperaturas para que no se mantengan con el valor alto
        sistemaAnual.setTemperatura(2023, 6, 50);
        
        System.out.print (sistemaAnual.toString());
        System.out.print (sistemaAnual.mayorTemperatura());
        
        /*
        Luego cree un Sistema con informe mensual para 4 años a partir de 2020, para la estación Mar del Plata 
        (latitud -38.002 y longitud -57.556). Cargue todas las temperaturas (para todos los meses y años). 
        Informe los promedios mensuales, y el mes y año en que se registró la mayor temperatura.
        */
        Estacion estacion2 = new Estacion ("Mar de Plata", - 38.002, - 57.556);
        PromedioHistoricoMensual sistemaMensual = new PromedioHistoricoMensual (estacion2, 2020, 4);
        
       //seteo las temperaturas para que no mantenga valor alto
       sistemaMensual.setTemperatura (2023, 3, 200);
       
       System.out.println (sistemaMensual.toString());
       System.out.println (sistemaAnual.mayorTemperatura());
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author branroodriguez
 */
public class Estacion {
    /*
    De la estación, interesa conocer: nombre, y latitud y longitud donde se encuentra.
    */
    private String nombre;
    private double latitud;
    private double longitud;
    
    //constructor 
    public Estacion (String unNombre, double unaLatitud, double unaLongitud){
        setNombre (unNombre);
        setLatitud (unaLatitud);
        setLongitud (unaLongitud);
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    //representacion to string de la estacion
    @Override
    public String toString (){
       String aux = "";
       aux = aux + getNombre() + " (" + getLatitud () + " S" + " - " + getLongitud() + " O" + "): " + "\n";
       return aux;
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author branroodriguez
 */
public class PromedioHistoricoAnual extends SistemaMeteorologico {
    
    //constructor que instancia una estacion previamente instanciada, y mi matriz desde el anio a hasta 
    public PromedioHistoricoAnual (Estacion estacion, int a, int n) {
        super (estacion, a, n);
    }
    
    //metodo calcular Promedio anual
    /*
    - La versión del sistema que reporta por años deberá calcular el promedio para cada año 
    (el promedio del año X se calcula con los datos mensuales de ese año).
    */
    
    @Override
    public String calcularPromedio (){
        double aux;
        String auxi = "";
        for (int i = 0; i < this.getN(); i++){
            aux = 0;
            for (int j = 0; j < 12; j++) {
               aux = aux + this.getTemperatura(i + this.getA(), j + 1); // i + 2020 y mes 0 + 1 
            } //el math round hace que tenga 2 decimales
            auxi = auxi + " - Año " + (this.getA() + i) + " : " + (double) (Math.round(aux/12) * 100) / 100.0 + "°C" + "\n";     
        } //preguntar
        return auxi;
    }
    
    @Override
    public String toString (){ //preguntar
        return super.toString();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author branroodriguez
 */
public class PromedioHistoricoMensual extends SistemaMeteorologico{
    
    //constructor
    public PromedioHistoricoMensual (Estacion estacion, int a, int n) {
        super (estacion, a, n);
    }
    
    //metodo calcularPromedio mensual
    //- La versión del sistema que reporta por meses deberá calcular el promedio para cada mes 
    //(el promedio del mes M se calcula con los datos de todos los años en ese mes).
    //Ej: “La Plata (34,921 S - 57,955 O): 
    //- Enero: 28,2 oC;
    // - Febrero: 26,8 oC; - Marzo: 24.3 oC
    //- .....”
    
    @Override
    public String calcularPromedio () {
        double aux;
        String auxi = "";
        for (int j = 0; j < 12; j++) {
            aux = 0;
            for (int i = 0; i < this.getN(); i++){
                aux = aux + this.getTemperatura((i + this.getA()), (j + 1));
            }
            auxi = auxi + " - " + this.getMeses (j) + ":" + Math.round (aux/this.getN() * 100) / 100.0 + "°C \n";
        }
        return auxi;
    }
    
    @Override
    public String toString () {  //preguntar si es necesario
        return super.toString();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author branroodriguez
 */

/*
4- El Servicio Meteorológico Nacional necesita un sistema que permita registrar, 
para una determinada estación meteorológica, la temperatura promedio mensual de N años consecutivos a partir 
de un año A dado. Además, necesita dos versiones del sistema: una que tenga funcionalidad para reportar 
el promedio histórico por años y otra que tenga funcionalidad para reportar el promedio histórico por meses. 
Esto se detalla más adelante.
*/

public abstract class SistemaMeteorologico {
    private Estacion estacion; //determinada estacion meteorologica. una clase dentro de otra.
    private int A; //año dado - inicial necesaria como variable de instancia o no?
    private int N; //años consecutivos idem al de arriba.
    private double [][] matriz; //tiene la tabla de años y meses con las temperaturas.
    private String[] meses = new String[] {"Enero", "Febrero" , "Marzo", "Abril" , "Mayo" , "Junio", "Julio" ,"Agosto", "Septiembre" , "Octubre" , "Noviembre", "Diciembre"};
    //constructor 
    /* a) Crear el sistema de registro/reporte, que funcionará en una determinada estación, 
    para N años consecutivos a partir de un año A. Inicie cada temperatura en un valor muy alto.
    */
    public SistemaMeteorologico (Estacion unaEstacion, int a, int n){
        setEstacion (unaEstacion);
        setA (a);
        setN (n);
        matriz = new double [n][12];  //preg // el 0 de i representa mi año a?
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 12; j++){
                matriz [i][j] = 100; //puede ir con set?
            }
        }
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public int getA() {
        return A;
    }

    public int getN() {
        return N;
    }

    //preguntar si esta mal 
    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public void setA(int A) {
        this.A = A;
    }

    public void setN(int N) {
        this.N = N;
    }

    public String getMeses(int j) {
        return meses [j];
    }

    public void setMeses(String[] meses) {
        this.meses = meses;
    }

    //c) Obtener la temperatura de un mes y año recibidos por parámetro. Nota: 
    //El mes está en rango 1..12 y el año está en rango A..A+N-1. En caso de no haberse registrado 
    //temperatura para ese mes/año se retorna el valor muy alto.
    public double getTemperatura (int anio, int mes){
        return this.matriz[anio - A][mes - 1]; //se puede con get?
    }
    
    //Registrar la temperatura de un mes y año recibidos por parámetro. 
    //Nota: El mes está en rango 1..12 y el año está en rango A..A+N-1.
    public void setTemperatura(int anio, int mes, double temp) {
        this.matriz[anio - A] [mes - 1] = temp; //se puede con set?
    }
    
    //d) Devolver un String que concatena el mes y año en que se registró la mayor temperatura. 
    //Nota: Suponga que ya están registradas las temperaturas de todos los meses y años.
    public String mayorTemperatura (){
        double aux = -1;
        int mes = -1,anio = -1;
        for (int i = 0; i < N; i++){
            for(int j = 0; j < 12; j++){
                if (matriz [i][j] > aux) {
                    aux = matriz [i][j];
                    anio = i;
                    mes = j;
                }
            }
        }
        return "El mes que se registro mayor temperatura fue: " + getMeses(mes) + " y el año fue: " + (anio + this.getA())+  " con " + aux + "\n";
    }
    
    //metodo abstracto que calcula el promedio ya sea anual o mensual de la estacion.
    public abstract String calcularPromedio ();
    
    @Override
    public String toString (){
        return "" + this.getEstacion() + this.calcularPromedio();
    }
}
