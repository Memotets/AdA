/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO;

import Recursive.Factorial;
import java.util.ArrayList;
import ordenamiento.AlgoritmoOrdenamiento;
import ordenamiento.burbuja;
import ordenamiento.burbujaOptimizado;
import ordenamiento.IncertSort;

import ordenamiento.Manager;




/**
 *
 * @author memotets89
 */
public class Main {
    public static void main(String[] args) {
//       burbuja bur1 = new burbuja(true);
//       burbujaOptimizado bur2 = new burbujaOptimizado(true);
//       IncertSort prueba3 = new IncertSort(true);
//             
//       ArrayList<AlgoritmoOrdenamiento>  lista= new ArrayList<>();
//       lista.add(bur1);
//       lista.add(bur2);
//       lista.add(prueba3);
//       
//       Manager machoman = new Manager(lista);
//       machoman.ejecutarPrueba(1000, 20,1000, true);
       System.out.println("No recursivo: "+Factorial.factorialNoRecursive(4));
       System.out.println("Recursivo: "+Factorial.factorialRecursive(4));
       System.out.println(Factorial.fiboNoRec(46));
      
  }
}
