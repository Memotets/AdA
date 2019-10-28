/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caballo;

/**
 *
 * @author memotets89
 */
public class caballoAvido {
    
    private final int numFilas;
    private final int numColumnas;
    private final int[][] tablero;
    private int     contador;
 
    public caballoAvido(int n) {
        contador =0;
        numFilas = n;
        numColumnas = n;
        tablero     = new int[n][n];
    }

    @Override
    public String toString() {
        for (int[] fila : tablero) {
            for (int j = 0; j < fila.length; j++) {
                System.out.printf("  %2d  |", fila[j]);
            }
            System.out.println();
            for (int j = 0; j < fila.length; j++) {
                System.out.print("------:");
            }
            System.out.println();
        }
        return "Cantidad de veces que entra al ciclo: "+this.contador ;
    }
 
 
 public boolean resolverProblema(int f, int c) {
        contador++;
        tablero[f][c] =contador;
        //caso base
        if(contador==numFilas*numColumnas) return true;
        //caso especifico
        int[][] posibles = PosiblesCasillas(f, c); //busco los movimientos posibles de mi posicion
        if (posibles.length != 0 ){
            PosiblesMovimientos(posibles);        // Ordeno los datos por el menor num de movimiento de la siguiente posicion
            if (resolverProblema(posibles[0][0], posibles[0][1])) { // si la siguiente casilla tiene solucion, ese camino es una solucion
                return true;
            }
        }
      
        return false;
 }

 
// nuevo método: ordena el arreglo de casillas a saltar segun la heuristica 
void PosiblesMovimientos(int[][] movimientos) {
    //Ordenamiento burbuja para cambiar el orden en el que se encuentran los saltos
    for(int i=0; i<movimientos.length; i++) {
        for(int j=i+1; j<movimientos.length; j++) {
            //Vease como se calcularan los movimientos de cada casilla
            int cuantosPosiblesI = PosiblesCasillas(movimientos[i][0], movimientos[i][1]).length;
            int cuantosPosiblesJ = PosiblesCasillas(movimientos[j][0], movimientos[j][1]).length;
            if(cuantosPosiblesJ<cuantosPosiblesI) { //Orden por los menores movimientos posibles de la sig posición. (Aqui esta la heuristica dada)
                int tmp0 = movimientos[i][0];
                movimientos[i][0] = movimientos[j][0];
                movimientos[j][0] = tmp0;
                int tmp1 = movimientos[i][1];
                movimientos[i][1] = movimientos[j][1];
                movimientos[j][1] = tmp1;
            }
        }
    }
}

    int[][] PosiblesCasillas(int x, int y) {
        int[][] resp = new int[8][2];//cantidad maxima de casillas que pueden ser un movimieto 
        int     aux  = 0; // inicialización de casillas disponibles
        //Chequeo de posiciones validas
        if(esValido(x-2,y-1)){ resp[aux][0]=x-2; resp[aux++][1]=y-1; }
        if(esValido(x-2,y+1)){ resp[aux][0]=x-2; resp[aux++][1]=y+1; }
        if(esValido(x-1,y-2)){ resp[aux][0]=x-1; resp[aux++][1]=y-2; }
        if(esValido(x-1,y+2)){ resp[aux][0]=x-1; resp[aux++][1]=y+2; }
        if(esValido(x+2,y-1)){ resp[aux][0]=x+2; resp[aux++][1]=y-1; }
        if(esValido(x+2,y+1)){ resp[aux][0]=x+2; resp[aux++][1]=y+1; }
        if(esValido(x+1,y-2)){ resp[aux][0]=x+1; resp[aux++][1]=y-2; }
        if(esValido(x+1,y+2)){ resp[aux][0]=x+1; resp[aux++][1]=y+2; }
        int[][] tmp = new int[aux][2];
        for(int i=0; i<aux; i++) { tmp[i][0] = resp[i][0]; tmp[i][1]=resp[i][1]; }
        return tmp; //devuelve una matriz de tamaño [numero de casillas disponibles][2] siendo el num de casillas en coordenadas 
    }
 
    boolean esValido(int f, int c) {
               return !(f<0 || f>numFilas-1 || c<0 || c>numColumnas-1||tablero[f][c]!=0);
    }
}