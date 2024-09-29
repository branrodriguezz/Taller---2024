/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author branroodriguez
 */
public class Triangulo {
    /*
    1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
    tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String). 
    Provea un constructor que reciba todos los datos necesarios para iniciar el objeto. 
    Provea métodos para:
    - Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
    - Calcular el perímetro y devolverlo (método calcularPerimetro)
    - Calcular el área y devolverla (método calcularArea)
    */
    
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    
    //constructor con 5 parametros
    public Triangulo (double unLado1, double unLado2, double unLado3, String unColorRelleno, String unColorLinea){
        lado1 = unLado1;
        lado2 = unLado2;
        lado3 = unLado3;
        colorRelleno = unColorRelleno;
        colorLinea = unColorLinea;
    }
    
    public Triangulo (double unLado1, double unLado2, double unLado3){
        lado1 = unLado1;
        lado2 = unLado2;
        lado3 = unLado3;
    }
    
    //metodos 
    
    public double getLado1 () {
        return lado1;
    }
    
    public double getLado2 (){
        return lado2;
    }
    
    public double getLado3 (){
        return lado3;
    }
    
    public String getcolorRelleno (){
        return colorRelleno;
    }
    
    public String getcolorLinea () {
        return colorLinea;
    }
    
    public void setLado1 (double unLado1) {
        lado1 = unLado1;
    }
    
    public void setLado2 (double unLado2) {
        lado2 = unLado2;
    }
    
    public void setLado3 (double unLado3) {
        lado3 = unLado3;
    }
    
    public void setColorRelleno (String unColorRelleno) {
        colorRelleno = unColorRelleno;
    }
    
    public void setColorLinea (String unColorLinea) {
        colorLinea = unColorLinea;
    }
    
    public String calcularPerimetro (){
        double aux = lado1 + lado2 + lado3;
        String aux1 = "El perimetro de este triangulo es: " + aux;
        return aux1;
    }
    
    public String calcularArea () {
        double aux = (lado1 + lado2 + lado3) / 2 ;
        double area = Math.sqrt(aux * (aux - lado1) * (aux - lado2) * (aux - lado3));
        String aux1 = "El area de este triangulo es: " + area;
        return aux1;
    }
    
    public static double leerLado (){
        System.out.print ("Lado: ");
        double aux = Lector.leerDouble();
        return aux;
    }
    
    public String leerColorRelleno (){
        System.out.print ("Color de relleno: ");
        String aux = Lector.leerString();
        return aux;
    }
    
    public String leerColorLinea () {
        System.out.print ("Color de linea: ");
        String aux = Lector.leerString();
        return aux;
    }
    
    @Override
    public String toString (){
        String aux = "Este triangulo tiene como lados : " + lado1 + " , " + lado2 + " , " + lado3;
        return aux;
    }
}

//programa 
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author branroodriguez
 */
public class ej01 {
    /*
    B- Realizar un programa que instancie un triángulo, le cargue información leída desde teclado e 
    informe en consola el perímetro y el área.
    NOTA:Calcular el área con la fórmula Á𝑟𝑒𝑎 = 𝑠(𝑠 − 𝑎)(𝑠 − 𝑏)(𝑠 − 𝑐) ,dondea,byc son los lados y 𝑠 = 𝑎+𝑏+𝑐 /2. 
    La función raíz cuadrada es Math.sqrt(#)
    */
    
    public static void main (String[] args) {
        
        System.out.println ("Ingrese los lados del triangulo: ");
        double lado1 = Triangulo.leerLado ();
        double lado2 = Triangulo.leerLado ();
        double lado3 = Triangulo.leerLado ();
        Triangulo t;
            
        t = new Triangulo (lado1, lado2, lado3);
        
        System.out.println (t.toString());
        
        System.out.println (t.calcularPerimetro());
        
        System.out.println (t.calcularArea());
    }
}
