/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package r2.carrerahipica;

/**
 *
 * @author PatriciaGomezSelles
 */

public class Carrerahipica {
    
    public static void cantidadParticipantes(){
        
    }
    
    public static void elegirCaballo(char[][] m){

    }
    
    public static void iniciarHipodromo(char[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                m[i][j] = '.';
            }
        }
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
    
    public static void avanzarCaballo(){
        
    }

    public static void main(String[] args) { int turno = 0;
        char[][] hipodromo;
//        int participantes = cantidadParticipantes();
//        int apuesta = elegirCaballo (participantes);
//        hipodromo= new char[participantes][50];
//        iniciarHipodromo (hipodromo);
//        while (avanzar Caballo (hipodromo, turno) < 50)
//            {
//                if (turno participantes 1)
//                turno++;
//                else
//                turno = 0;
//            }
//        if (apuesta == turno)
//            System.out.println("ganaste caballo ganador + turno);
//        else
//            System.out.println("perdiste, [" + apuesta + "] gana el caballo" + turno);
    }
}
