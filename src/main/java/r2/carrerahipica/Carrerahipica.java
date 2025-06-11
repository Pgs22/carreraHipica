/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package r2.carrerahipica;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PatriciaGomezSelles
 */

public class Carrerahipica {
    
    public static int cantidadParticipantes(Scanner scan){
        boolean validar = false;
        int participantes = 0;
        do{
            System.out.println("Escribe el numero de participantes: ");        
            while(!scan.hasNextInt()){
                System.out.println("Error: introduce un numero entero");
                scan.next();
                System.out.println("Escribe el numero de participantes: ");
            }
            int validarParticipantes = scan.nextInt();
            if(participantes < 2 || participantes > 8){
                System.out.println("Error: Fuera de rango. El numero de participantes debe ser entre 2 y 8");
                System.out.println("Vuelve a intentarlo");
                scan.nextLine();
                break;
            } else if (participantes > 2 || participantes < 8){
                System.out.println("OK");
                participantes = validarParticipantes;
                validar = true;
            }
        }while(!validar);
        return participantes;
    }
    
    public static int elegirCaballo(int participantes, Scanner scan){
        //partipantes tiene el numero de caballos que habran en la carrera
        boolean validar = false;
        int caballo = -1;
        do{
            System.out.println("Apuesta que caballo ganara (caballos disponibles desde 0 a " 
                    + (participantes-1) + "): "); //Le resto el numero del participante 0        
            while(!scan.hasNextInt()){
                System.out.println("Error: introduce un numero entero");
                scan.next();
                System.out.println("Escribe el numero de participantes: ");
            }
            caballo = scan.nextInt();
            if(caballo < 0 || caballo > participantes){
                System.out.println("Error: Fuera de rango. El caballo no participa en la carrera.");
                System.out.println("Vuelve a intentarlo");
                scan.nextLine();
                break;
            } else if (caballo > 0 || caballo < participantes){
                System.out.println("OK");
                validar = true;
            }
        }while(!validar);
        return caballo;
    }
    
    public static void iniciarHipodromo(char[][] m){
        System.out.println("****Preparamos la pista para la carrera!****");
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                m[i][j] = '.';
            }
        }
        mostrarHipodromo(m);
    }
    
    public static void mostrarHipodromo(char [][] hipodromo){
        for(int i = 0; i < hipodromo.length; i++){
            System.out.println("[" + i + "]");
            for(int j = 0; j < hipodromo[i].length; j++){
                System.out.println(hipodromo[i][j] + " ");
            }
        }
        System.out.println();
    }
    
    public static int avanzarCaballo(char[][] hipodromo, int turno){
        System.out.println("EMPIEZA LA CARRERA!!");
        Random random = new Random();
        // actualizar el hipodromo según avanza cada caballo
        // int turno iniciado en main =>0 (Representa la fila del hipodromo)
        // y irá incrementando en el main
        System.out.println("Turno para el caballo: " + turno);
        do{
            //Simulacion de un dado para avanzar
            int avanza = random.nextInt(1, 6);   

            System.out.println("El caballo avanzará " + avanza + " posiciones "
                + "desde la posición ...");

            //Buscamos posición del caballo para cada turno
            for (int i = turno; i < turno; i++) {
                for (int j = 0; j < hipodromo[i].length -1 ; j++) { 
                    if (hipodromo[i][j] == '.') {
                        int posicion = j -1;
                        System.out.println("Posicion [" + i + "," + posicion + "]");
                        int mover = posicion + avanza;
                        for (int k = posicion; k < mover; k++) {
                                hipodromo[i][k] = '#';
                                k++;
                        }
                        mostrarHipodromo(hipodromo);
                    }
                }       
            }
        }while(true);
    }

    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        int turno = 0;
        char[][] hipodromo;
        int participantes = cantidadParticipantes(scan);
        int apuesta = elegirCaballo(participantes, scan);
        hipodromo = new char[participantes][50];
        iniciarHipodromo(hipodromo);
        while (avanzarCaballo(hipodromo, turno) < 50)
            {
                if (turno < participantes - 1)
                turno++;
                else
                turno = 0;
            }
        if (apuesta == turno){
            System.out.println("ganaste caballo ganador + turno");
        }else {
            System.out.println("perdiste, [" + apuesta + "] gana el caballo" + turno);
        }
    }
}
