/*
 *restricciones:
    No se puede volver a las posiciones ya visitadas
    El movimiento solo son los posibles de un caballo

 *Consideraciones: 
    Se debe iniciar donde sea
    Tablero N*N
    No salirse de la matriz
    No teletransportase (modulo), dado que no es un movimiento de caballo
    Marcar los movimientos
    Los movimientos realizados no pueden ser mayores que 64
    Al terminar los movimientos si son menores a 64, el problema no esta resuelto
 */
package Caballo;

/**
 *
 * @author memotets89
 */
public class main {
     
    public static void main(String[] args) {
        caballoAvido pc = new caballoAvido(8);
        pc.resolverProblema(0,3);
        System.out.println(pc.toString());
 
    }
}
