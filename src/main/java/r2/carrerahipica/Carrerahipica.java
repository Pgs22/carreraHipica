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
            if(validarParticipantes < 2 || validarParticipantes > 8){
                System.out.println("Error: Fuera de rango. El numero de participantes debe ser entre 2 y 8");
                System.out.println("Vuelve a intentarlo");
                scan.nextLine();
            } else if (validarParticipantes >= 2 || validarParticipantes <= 8){
                System.out.println("OK");
                participantes = validarParticipantes;
                validar = true;
                return participantes;
            }
        }while(!validar);
        return participantes;
    }
    
    public static int elegirCaballo(int participantes, Scanner scan){
        //partipantes tiene el numero de caballos que habran en la carrera
        boolean validar = false;
        int caballo = participantes;
        do{
            System.out.println("Apuesta que caballo ganara (caballos disponibles desde 0 a " 
                    + (participantes) + "): "); //Le resto el numero del participante 0        
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
            } else if (caballo >= 0 || caballo <= participantes){
                System.out.println("OK");
                validar = true;
            }
        }while(!validar);
        return caballo;
    }
    
    public static void iniciarHipodromo(char[][] m){
        System.out.println("****Preparamos la pista para la carrera!****");
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                m[i][j] = '.';
            }
        }
        System.out.println("EMPIEZA LA CARRERA!!");
    }
    
    public static void mostrarHipodromo(char [][] hipodromo){
        for(int i = 0; i < hipodromo.length; i++){
            System.out.print("[" + i + "]");
            for(int j = 0; j < hipodromo[i].length; j++){
                System.out.print(hipodromo[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static int avanzarCaballo(char[][] hipodromo, int turno) {
        
        Random random = new Random();
        
        System.out.println("Turno para el caballo: " + turno);
        int longitudPista = hipodromo[turno].length;
        int posicionInicial = -1;
        
        //Buscamos la posición del caballo, se detendrá cuando no encuentre #
        //en cada vuelta nos actualiza la posicion, nos quedaremos con la ultima
        //si no encuentra caballo, salimos del bucle
        for(int i = 0; i < longitudPista; i++){
            if(hipodromo[turno][i] == '#'){
                posicionInicial = i;
            }else{
                break;
            }
        }
        
        //POSICION A DEVOLVER esperada en el main si hay ganador (50)
        int devolverPosicion;
        
        //Avanzamos segun el dado rellenando posiciones avanzadas
        int dado = random.nextInt(1,7); //el maximo sera excluido. Obtenemos (de 1 a 6)
        int posicionFinal = posicionInicial + dado;
        
        //Nos aseguramos que no se salga de la pista, restamos 1 por el indice desde 0
        if(posicionFinal >= longitudPista){
            posicionFinal = longitudPista -1;
            devolverPosicion = longitudPista;
        } else{
            devolverPosicion = posicionFinal;
        }
        
        /* Validar primera posición a rellenar
        - Si la posicionInicial es -1 es que acaba de empezar la carrera
          lo situamos en la posicion 0
        - Sino, es que estamos en la ultima posicion del caballo
          por lo que tenemos que avanzar a la primera posicion a rellenar
        */
        if(posicionInicial == -1){
            posicionInicial = 0;
        } else {
            posicionInicial += 1;
        }
        
        for(int j = posicionInicial; j <= posicionFinal; j++){
            hipodromo[turno][j] = '#';
        }
        //Mostramos resultado el turno ejecutado
        mostrarHipodromo(hipodromo);
        //Devolvemos la posicion actual del caballo al cabar el turno
        return devolverPosicion;
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
