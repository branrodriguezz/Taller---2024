/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author branroodriguez
 */
public class Ej03 {
    
    public static void main (String[] args) {
    Personas p = new Personas ("Josefina", 34123456, 18);
    Trabajadores t = new Trabajadores ("Jose", 12345678, 29, "Albañil");
    
    System.out.println ("Persona: " + p.toString() + "\n");
    System.out.println ("Trabajador: " + t.toString());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author branroodriguez
 */
public abstract class BarrioPrivado {
    /*
    3-A- Implemente las clases para el siguiente problema. Una garita de seguridad quiere identificar 
    los distintos tipos de personas que entran a un barrio cerrado. 
    Al barrio pueden entrar: personas, que se caracterizan por nombre, DNI y edad; y trabajadores, 
    estos son personas que se caracterizan además por la tarea realizada en el predio.
    Implemente constructores, getters y setters para las clases. Además tanto las personas como los 
    trabajadores deben responder al mensaje toString siguiendo el formato:
    ▪ BarrioPrivado “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años”
    ▪ Trabajadores“Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años. Soy
    jardinero.”
    B- Realice un programa que instancie una persona y un trabajador y muestre la
    representación de cada uno en consola.
    NOTA: Reutilice la clase Persona (carpeta tema2).
    */
    private String nombre;
    private int DNI;
    private int edad;
    
    //constructor 
    public BarrioPrivado (String unNombre, int unDNI, int edad){ //representan las personas del barrio
        setNombre (unNombre);
        setDNI (unDNI);
        setEdad (edad);
    }
    
    @Override
    public String toString (){
        String aux = " | Mi nombre es: " + getNombre() +
                     " | mi DNI: " + getDNI () + //PREG POR EL THIS
                     " | tengo : " + getEdad () + " años | ";
        return aux;
    }
    
    //metodos getters y setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author branroodriguez
 */
public class Personas extends BarrioPrivado{
    public Personas (String unNombre, int unDNI, int unaEdad) {
        super(unNombre, unDNI, unaEdad);
    }
}
//preguntar
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author branroodriguez
 */
public class Trabajadores extends BarrioPrivado {
    private String tarea;
    
    public Trabajadores (String unNombre, int unDNI, int unaEdad, String unatarea) {
        super(unNombre,unDNI,unaEdad);
        setTarea (unatarea);
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    @Override
    public String toString (){
        String aux = super.toString() + 
                     "Soy: " + getTarea() + " | " + "\n";
        return aux;
    }
}
