/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author branroodriguez
 */
public class ej05 {
    /*
    Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el campeonato. 
    La información de cada partido se lee desde teclado hasta ingresar uno con nombre de visitante 
    “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
    - Para cada partido, armar e informar una representación String del estilo: 
    {EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
    - Calcular e informar la cantidad de partidos que ganó River.
    - Calcular e informar el total de goles que realizó Boca jugando de local.
    */
    
    public static void main (String[] args) {
        
        Partido [] vector = new Partido [20];
        
        //variables
        int i = 0, golesLocal, golesVisitante;
        String equipoLocal, equipoVisitante;
        
        System.out.print ("Equipo local: ");
        equipoLocal = Lector.leerString();
        
        System.out.print ("Equipo visitante: ");
        equipoVisitante = Lector.leerString();
        
        while (!equipoVisitante.equals("ZZZ") && i < 20) {
            System.out.print ("Goles local: ");
            golesLocal = Lector.leerInt();
            
            System.out.print ("Goles visitante: ");
            golesVisitante = Lector.leerInt();
            
            vector [i] = new Partido (equipoLocal, equipoVisitante, golesLocal, golesVisitante);
            
            System.out.print ("Equipo local: ");
            equipoLocal = Lector.leerString();

            System.out.print ("Equipo visitante: ");
            equipoVisitante = Lector.leerString();
            
           i++;  
        }
        
        int dl = i;
        int cantR = 0;
        int boke = 0;
        
        System.out.println (" ------- VECTOR DE PARTIDOS -------- ");
        
        for (i = 0; i < dl; i++) {
            if (vector[i].getGanador().equals("River"))
                cantR = cantR + 1;
            if (vector[i].getLocal().equals("Boca"))
                boke = boke + vector[i].getGolesLocal();
            System.out.println (" | Partido " + i + " | " + vector [i].toString() + " | ");
        }
        
        //informar
        System.out.println ("----------------------------------------------------");
        System.out.println ("La cantidad de partidos que gano River es: " + cantR);
        System.out.println ("----------------------------------------------------");
        System.out.println ("La cantidad de goles de Boca en condicion de local fueron: " + boke);
    }
}
