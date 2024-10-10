/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author branroodriguez
 */
public class Ej05 {

    public static void main(String[] args) {
        Dibujo d = new Dibujo ("Un dibujo:");
        Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
        Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
        Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
        d.agregar (c1);
        d.agregar (r);
        d.agregar (c2);
        d.mostrar();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author branroodriguez
 */
public class Dibujo {
    
 //variables de instancia
  private String titulo;
  private Figura [] vector;
  private int guardadas;
  private int capacidadMaxima = 10;
  
  //inicia el dibujo, sin figuras - constructor
  public Dibujo (String titulo){
      //seteo el titulo
      setTitulo (titulo);
      //recorro el vector y pongo todo en null porq voy a almacenar figuras
      vector = new Figura [this.getCapacidadMaxima()];
      for (int i = 0; i < this.getCapacidadMaxima(); i++) {
          vector [i] = null; 
      }
  }
  
  //METODOS
  //agrega la figura al dibujo
    public void agregar(Figura f){
        vector [this.getGuardadas()] = f; //esta bien?
        this.setGuardadas(1);
        System.out.println("La figura: " +
                        f.toString() +
                        " se ha guardado" + "\n");
    }
    
    
    
    //calcula el área del dibujo: //suma de las áreas de sus figuras 
    public double calcularArea(){
        double aux = 0;
        for (int i = 0; i < this.getGuardadas(); i++){
            aux = aux + vector [i].calcularArea();
        }
        return aux;
    }

    public void mostrar(){
        String aux = this.getTitulo();
                    for (int i = 0; i < this.getGuardadas(); i++) 
                         aux+= "\n" + vector [i].toString()
                     + "Area del dibujo" + this.calcularArea() + "\n";
    }       
    
    //retorna está lleno el dibujo
    public boolean estaLleno() {
    return (guardadas == capacidadMaxima);
    }

  //metodos getter y setter - necesarios en este caso?

    public String getTitulo() {
        return titulo;
    }

    public int getGuardadas() {
        return guardadas;
    }
    
    //privada porque no quiero que nadie me modifique la capacidad maxima del vector de figuras
    private int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGuardadas(int guardadas) {
        this.guardadas = 0 + guardadas;
    }
    //seteo solo el set o el get tmb?
    private void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;


public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;
   
    public Figura(String unCR, String unCL){
        setColorRelleno(unCR);
        setColorLinea(unCL);
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
    
    @Override
    public String toString (){
        String aux = "" + "Area: " + this.calcularArea() +
                   " Color de relleno: " + this.getColorRelleno() +
                    " Color de linea: " + this.getColorLinea();
        return aux;
    }
     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author branroodriguez
 */
public class Rectangulo extends Figura {
    private double base;
    private double altura;
    
    //constructor 
    public Rectangulo (double unaBase, double unaAltura, String unColorR, String unColorL) {
        super(unColorR,unColorL);
        this.setBase (unaBase);
        this.setAltura (unaAltura);
    }
    
    //metodos get y set
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    @Override
    public double calcularArea(){
       return (this.getBase()* this.getAltura());
    }
    
    @Override
    public String toString(){
       String aux = " Rectangulo " + super.toString() + 
                    " Base " + this.getBase() +
                    " Altura " + this.getAltura() + "" ;
       return aux;
    }
    
}
package Ejercicio5;


public class Cuadrado extends Figura{
    
    private double lado;
    
    public Cuadrado(double unLado, String unColorR, String unColorL){
        super(unColorR,unColorL);
        this.setLado(unLado);
    } 
    
    public double getLado(){
        return lado;       
    }
  
    public void setLado(double unLado){
        lado=unLado;
    }
    
    @Override
    public double calcularArea(){
       return (getLado()* getLado());
    }
    
    @Override
    public String toString(){
       String aux = " Cuadrado " + super.toString() + 
                    " Lado: " + this.getLado();
       return aux;
    }

 
}

