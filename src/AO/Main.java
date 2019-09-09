/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO;

import Recursive.Recursive;
import java.util.ArrayList;
import ordenamiento.AlgoritmoOrdenamiento;
import ordenamiento.burbuja;
import ordenamiento.burbujaOptimizado;
import ordenamiento.IncertSort;

import ordenamiento.Manager;
import ordenamiento.MergeSort;




/**
 *
 * @author memotets89
 */
public class Main {
    public static void main(String[] args) {
       burbuja bur1 = new burbuja();
       burbujaOptimizado bur2 = new burbujaOptimizado();
       IncertSort prueba3 = new IncertSort();
       MergeSort ob = new MergeSort(); 
             
       ArrayList<AlgoritmoOrdenamiento>  lista= new ArrayList<>();
      // lista.add(bur1);
       //lista.add(bur2);
       lista.add(prueba3);
       lista.add(ob);
       
       Manager machoman = new Manager(lista);
       machoman.ejecutarPruebaPeor(5000,3, true);
//       System.out.println("Recursivo: "+Recursive.Sumatoria(-10, -12));
      
  }
}
