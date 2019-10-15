/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamico;

import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class TSP {
    int contador=0;
    int posicion =0;
    int corto = 0;
    int[] camino = new int [10];

        
    public void buscar_camino (int n){
        this.posicion=n;
       int[][] mat= {
            { 0,13, 33, 28, 37,   7, 32, 40, 80, 26},
            { 0,  0, 39, 83, 50, 68, 16, 98, 81, 55},
            { 0,  0,   0, 80, 88, 49, 53, 75, 63, 55},
            { 0,  0,   0,   0, 94,   4, 20,   6, 59, 76},
            { 0,  0,   0,   0,   0, 81, 87, 85,   4, 19},
            { 0,  0,   0,   0,   0,   0, 96, 53, 40, 37},
            { 0,  0,   0,   0,   0,   0,   0, 80, 57, 68},
            { 0,  0,   0,   0,   0,   0,   0,   0, 65, 41},
            { 0,  0,   0,   0,   0,   0,   0,   0,   0, 97},
            { 0,  0,   0,   0,   0,   0,   0,   0,   0,   0}
        };
    int[][] matriz = {
            { 0,13, 33, 28, 37,   7, 32, 40, 80, 26},
            { 0,  0, 39, 83, 50, 68, 16, 98, 81, 55},
            { 0,  0,   0, 80, 88, 49, 53, 75, 63, 55},
            { 0,  0,   0,   0, 94,   4, 20,   6, 59, 76},
            { 0,  0,   0,   0,   0, 81, 87, 85,   4, 19},
            { 0,  0,   0,   0,   0,   0, 96, 53, 40, 37},
            { 0,  0,   0,   0,   0,   0,   0, 80, 57, 68},
            { 0,  0,   0,   0,   0,   0,   0,   0, 65, 41},
            { 0,  0,   0,   0,   0,   0,   0,   0,   0, 97},
            { 0,  0,   0,   0,   0,   0,   0,   0,   0,   0}
        };
    
        this.camino [this.contador] = this.posicion;        
        while (contador<9){
            int valor=2147483647;
            int posaux=this.posicion;
            
            for (int j =this.posicion; j>-1;j--){                
               if (valor >= matriz[j][this.posicion]  && matriz[j][this.posicion]>0){
                    valor = matriz[j][this.posicion];
                    posaux=j; 
                    System.out.print("");
                }
            }
            
            for (int j =this.posicion; j<10;j++){                
                 if (valor >= matriz[this.posicion][j] && matriz[this.posicion][j]>0){
                    valor = matriz[this.posicion][j];
                    posaux=j;
                    System.out.print("");
                }
            }
            
       
          for (int x =0; x < camino.length;x++){
               matriz[this.posicion][x]=0;
               matriz[x][this.posicion]=0;
          }
            this.posicion=posaux;
                this.corto+=valor;
                valor=2147483647;
                contador++;
                this.camino[this.contador]=this.posicion;
        }
        this.corto+= mat[this.posicion][n]; 
        this.corto+= mat[n][this.posicion]; 
        
        System.out.print("Camino: "); 
        for (int i =0; i < camino.length; i++){
            System.out.print((char)(65+camino[i]) +" -> ");
        }
        char wop = (char) (this.corto+65);
        System.out.println((char)(65+camino[0])+" Tardo: "+this.corto);
        this.contador=0;
        this.corto=0;
        this.posicion=0;
        
       
    }
    
//    public static long fiboIterativoDinamico(long pos){
//        long fibos[] = new long[(int)pos+1];
//        fibos[0] = 0;
//        fibos[1] = 1;
//        for (int x=2; x<=pos;x++){
//         fibos[x] =  fibos[x-1] + fibos[x-2];
//        }
//     return fibos[(int)pos];
//}
}
