/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio2;
/**
 *
 * @author branroodriguez
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        //Realizar un programa que instancie un jugador y un entrenador. Informe la representación String de cada uno.
        
        Jugador j = new Jugador ("Pedro", 23000 , 6, 4, 3);
        Entrenador e = new Entrenador ("Luis", 1230, 10, 2);
        
        System.out.println ("Representacion del jugador: " + j.toString() + "\n");
        System.out.println ("Representacion del entrenador: " + e.toString() + "\n");
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author branroodriguez
 */
public abstract class Empleados {
    private String nombre;
    private double sueldobasico;
    private int antiguedad;
    
    public Empleados (String unNombre, double sueldoBasico, int antiguedadd){
        setNombre (unNombre);
        setSueldobasico (sueldoBasico);
        setAntiguedad (antiguedadd);
    }
    
    //metodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public double getSueldobasico() {
        return sueldobasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldobasico(double sueldobasico) {
        this.sueldobasico = sueldobasico;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    //metodo que me calcula el sueldo a cobrar.
    public double calcularSueldoBase (){
        return (this.getSueldobasico() + ((this.getSueldobasico() * 10 / 100) * this.getAntiguedad()));
    } 
//El sueldo a cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad.
    
    @Override
    public String toString (){
        String aux = "| Nombre: " + getNombre()  + 
                     " | Sueldo a cobrar: " + this.calcularSueldoACobrar() + "$" +
                     " | Efectividad: " + this.calcularEfectividad() + " | " + "\n";
        return aux;
    }
    /*
    B-Cualquier empleado debe responder al mensaje calcularEfectividad. 
    La efectividad del entrenador es el promedio de campeonatos ganados por año de antigüedad, 
    mientras que la del jugador es el promedio de goles por partido.
    */
    public abstract double calcularEfectividad(); //puede ser privado?
    /*
    C- Cualquier empleado debe responder al mensaje calcularSueldoACobrar. 
    El sueldo a cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad y además:
    ▪ Para los jugadores: si el promedio de goles por partido es superior a 0,5 
    se adiciona un plus de otro sueldo básico.
    ▪ Para los entrenadores: se adiciona un plus por campeonatos ganados 
    (5000$ si ha ganado entre 1 y 4 campeonatos; $30.000 si ha ganado entre 5 y 10 campeonatos; 
    50.000$ si ha ganado más de 10 campeonatos).
    */
    public abstract double calcularSueldoACobrar(); //preguntar
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author branroodriguez
 */
public class Entrenador extends Empleados{
    private int campeonatosGanados;
    
    //constructor del entrenador
    public Entrenador (String nombre, double sueldo, int antiguedad, int campeonatos){
        super(nombre, sueldo, antiguedad);
        setCampeonatosGanados(campeonatos);
    }
    
    //metodos getter y setter

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    //metodos
    //La efectividad del entrenador es el promedio de campeonatos ganados por año de antigüedad
    @Override
    public double calcularEfectividad (){
        return (double) getCampeonatosGanados () / this.getAntiguedad(); //esta bien el this?
    }
    
    //▪ Para los entrenadores: se adiciona un plus por campeonatos ganados (5000$ si ha ganado entre 1 y 4 campeonatos; 
    //$30.000 si ha ganado entre 5 y 10 campeonatos; 50.000$ si ha ganado más de 10 campeonatos).
    
    @Override
    public double calcularSueldoACobrar(){
        double sueldoFinal = super.calcularSueldoBase();
        if (this.getCampeonatosGanados() >= 1 && this.getCampeonatosGanados() <= 4) 
            sueldoFinal = sueldoFinal + 5000;
        else {
            if (this.getCampeonatosGanados() >= 5 && this.getCampeonatosGanados() <= 10) 
                sueldoFinal = sueldoFinal + 30000;
            else
                if (this.getCampeonatosGanados() > 10) 
                    sueldoFinal = sueldoFinal + 50000;
        }             
        return sueldoFinal;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author branroodriguez
 */
public class Jugador extends Empleados {
    private int partidosJugados;
    private int golesAnotados;
    
    //constructor del jugador
    public Jugador (String nommbre, double sueldito, int antiguedad, int partJug, int golAnot){
        super(nommbre, sueldito, antiguedad);
        setPartidosJugados(partJug);
        setGolesAnotados(golAnot);
    }
    
    //metodos getter y setter

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    
    //metodos
    // mientras que la del jugador es el promedio de goles por partido.
    @Override
    public double calcularEfectividad(){
        return (double) getGolesAnotados() / getPartidosJugados();
    }
    
    //▪ Para los jugadores: si el promedio de goles por partido es superior a 0,5 
    //se adiciona un plus de otro sueldo básico. en la variable sueldo final me guardo el sueldo base de cualquier
    //empleado y luego chequeo si le sumo o no el plus.
    
    @Override
    public double calcularSueldoACobrar(){
      double sueldofinal = this.calcularSueldoBase(); //PREGUNTAR POR THIS O SUPER
      if (this.calcularEfectividad() > 0.5)
          sueldofinal = sueldofinal + this.getSueldobasico();
      return sueldofinal;
    }
}
