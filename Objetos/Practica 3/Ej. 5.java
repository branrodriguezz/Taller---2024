/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author branroodriguez
 */
public class Circulo {
    /*
    Definir una clase para representar círculos. Los círculos se caracterizan por su radio (double), 
    el color de relleno (String) y el color de línea (String).
    Provea un constructor que reciba todos los datos necesarios para iniciar el objeto. Provea métodos para:
    - Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
    - Calcular el perímetro y devolverlo (método calcularPerimetro)
    - Calcular el área y devolverla (método calcularArea)
    */
    
    private Double radio;
    private String relleno;
    private String linea;
    
    //Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
    public Circulo (Double unRadio, String unRelleno, String unaLinea){
        radio = unRadio;
        relleno = unRelleno;
        linea = unaLinea;
    }

    public Double getRadio() {
        return radio;
    }

    public String getRelleno() {
        return relleno;
    }

    public String getLinea() {
        return linea;
    }

    public void setRadio(Double rradio) {
        radio = rradio;
    }

    public void setRelleno(String rrelleno) {
        relleno = rrelleno;
    }

    public void setLinea(String llinea) {
        linea = llinea;
    }
    
    //- Calcular el perímetro y devolverlo (método calcularPerimetro)
    public Double calcularPerimetro (){
        Double d = (radio * 2);
        Double p = (Math.PI * d);
        return p;
    }
    //- Calcular el área y devolverla (método calcularArea)
    public Double calcularArea (){
        Double a = (Math.PI * (radio * radio));
        return a;
    }
}
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
public class ej05 {
    // B- Realizar un programa que instancie un círculo, le cargue información leída de teclado e 
    //informe en consola el perímetro y el área.
    
    public static void main (String[] args) {
        Circulo c;
        Double radio;
        String relleno;
        String linea;
        
        System.out.print ("Radio: ");
        radio = Lector.leerDouble();
        System.out.print ("Relleno: ");
        relleno = Lector.leerString();
        System.out.print ("Linea: ");
        linea = Lector.leerString();
        
        c = new Circulo (radio, relleno, linea);
        
        System.out.println ("Perimetro del circulo: " + c.calcularPerimetro());
        System.out.println ("Area del circulo: " + c.calcularArea());
    }
    
}
