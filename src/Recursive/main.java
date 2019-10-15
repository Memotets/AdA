/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursive;

import ordenamiento.Grafica;

/**
 *
 * @author memotets89
 */
public class main {
            public static int n=5000 ;
            public static double [] timeFib= new double[n];
            public static double [] timeIterativo = new double[n];
            public static double [] timeIterativoDin = new double[n];
            public static double [] timeFibDin= new double[n];
            
             public static void main(String[] args) {
                 for (int i =2; i<n;i++){
//                double ti1=System.currentTimeMillis();
//                Recursive.fibo(i);
//                double to1= System.currentTimeMillis();
//                timeFib[i] = to1-ti1;

                double ti2= System.currentTimeMillis();
               Recursive.fiboRecursivoDinamico(i);
                double to2= System.currentTimeMillis();
                timeFibDin[i] = to2-ti2;
                
                double ti3= System.currentTimeMillis();
               Recursive.fiboNoRec(i);
                double to3= System.currentTimeMillis();
                timeIterativo[i] = to3-ti3;
                
                double ti4= System.currentTimeMillis();
               Recursive.fiboIterativoDinamico(i);
                double to4= System.currentTimeMillis();
                timeIterativoDin[i] = to4-ti4;
           }
            Grafica g = new Grafica("numFib", "Tiempo", "Pruebas Fibonacci");
            
//                g.agregarSerie(timeFib, "Recursivo");
                g.agregarSerie(timeFibDin, "Recursivo Dinamico Dinamico");
                g.agregarSerie(timeIterativo, "Iterativo");
                g.agregarSerie(timeIterativoDin, "Iterativo Dinamico");
            
                g.creaYmuestraGrafica();
       }
}
    

