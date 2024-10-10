/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author branroodriguez
 */
public class ej01 {
    
    public static void main (String[] args) {
        /*Realizar un programa que instancie un triángulo y un círculo. Muestre en consola la representación 
        String de cada uno. Pruebe el funcionamiento del método despintar.
        */
        
        Triangulo t = new Triangulo (" Verde ", " Azul " , 10, 10, 10);
        Circulo c = new Circulo (5.5, "Amarillo" , "Violeta");
        
        System.out.println ("La representacion del Triangulo : " + "\n" + t.toString() + "\n");
        System.out.println ("La representacion del Circulo: " + "\n" + c.toString() + "\n");
        
        t.despintar(); //peguntar
        c.despintar();
        
        System.out.println ("La representacion del Triangulo : " + "\n" + t.toString() + "\n");
        System.out.println ("La representacion del Circulo: " + "\n" + c.toString() + "\n");  
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;


public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;
   
    public Figura(String unCR, String unCL){
        setColorRelleno(unCR);
        setColorLinea(unCL);
    }
    
     @Override
    public String toString(){
        String aux = "Area: " + this.calcularArea() +
                     " Perimetro: " + this.calcularPerimetro() +
                     " CR: "  + getColorRelleno() + 
                      " CL: " + getColorLinea();             
             return aux;
       }
    
    //Añada el método despintar que establece los colores de la figura a línea “negra” y relleno “blanco”. 
    //Piense ¿dónde debe definir el método: en cada subclase o en Figura?
    public void despintar (){
        setColorRelleno ("Blanco");
        setColorLinea ("Negro");
    }
    
    public String getColorRelleno(){
        return colorRelleno;       
    }
    public void setColorRelleno(String unColor){
        colorRelleno = unColor;       
    }
    public String getColorLinea(){
        return colorLinea;       
    }
    public void setColorLinea(String unColor){
        colorLinea = unColor;       
    }
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author branroodriguez
 */
public class Circulo extends Figura{
    
    private Double radio;
    
    public Circulo (double radioO, String colorR, String colorL){
        super (colorR, colorL);
        setRadio (radioO);
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }
    
    @Override
    public double calcularPerimetro (){
        return (getRadio() * 2) * Math.PI;
    }
    
    @Override
    public double calcularArea (){
        return (getRadio() * getRadio ()) * Math.PI;
    }
    
    @Override
    public String toString (){
        String aux = super.toString() + 
                     " Radio: " + getRadio();
        return aux;
    }
}
package tema4;


public class Cuadrado extends Figura{
    
    private double lado;
    
    public Cuadrado(double unLado, String unColorR, String unColorL){
        super(unColorR,unColorL);
        setLado(unLado);

    } 
    
    public double getLado(){
        return lado;       
    }
  
    public void setLado(double unLado){
        lado=unLado;
    }

    public double calcularArea(){
       return (getLado()* getLado());
    }
    
    public double calcularPerimetro(){
       return (getLado()*4);
    }
    
    public String toString(){
       String aux = super.toString() + 
                    " Lado: " + getLado();
       return aux;
    }

 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public class Rectangulo extends Figura{
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura, String unColorR, String unColorL){
        super(unColorR,unColorL);
        setBase(base);
        setAltura(altura);
    } 

    public double getBase() {
        return base;
    }

    public void setBase(double unaBase) {
        base = unaBase;
    }
    
    public double getAltura() {
        return altura;
    }

    public void setAltura(double unaAltura) {
        altura = unaAltura;
    }

    @Override
    public double calcularArea() {
        return (getBase()*getAltura()); 
    }

    @Override
    public double calcularPerimetro() {
        return (2*getBase()+2*getAltura());
    }
    
    @Override
    public String toString(){
       String aux = super.toString() + 
                    " Base: " + getBase() +
                    " Altura: " + getAltura();
       return aux;
    }

    
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author branroodriguez
 */
public class Triangulo extends Figura {
    /*
    Incluya la clase Triángulo a la jerarquía de figuras. Triángulo debe heredar de Figura todo lo que es común 
    y definir su constructor y sus atributos y métodos propios. Además debe redefinir el método toString.
    */
    private Double lado1;
    private Double lado2;
    private Double lado3;
    
    //constructor
    
    public Triangulo (String colorRelleno, String colorLinea,double ladoone, double ladotwo, double ladothree){
        super(colorRelleno, colorLinea); 
        this.setLado1(ladoone); 
        this.setLado2 (ladotwo);
        this.setLado3 (ladothree);
    }

    public Double getLado1() { //preguntar x mayusculas y minisculas de los datos 
        return lado1;
    }

    public Double getLado2() {
        return lado2;
    }

    public Double getLado3() {
        return lado3;
    }

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(Double lado3) {
        this.lado3 = lado3;
    }
    
    @Override
    public double calcularPerimetro (){ //puede ir antes el calcular perimetro? hay algun problema?
        return (getLado1()+ getLado2()+getLado3());
    }
    
    @Override 
    public double calcularArea (){
        double aux = (this.calcularPerimetro()/2); //preguntar por el this?
        return Math.sqrt(aux * (aux - lado1) * (aux - lado2) * (aux - lado3));
    }
    
    @Override
    public String toString (){
        String aux = super.toString() + " Lado 1: " + getLado1() +
                    " Lado 2: " + getLado2() + 
                    " Lado 3: " + getLado3();
        return aux;
    }
}
