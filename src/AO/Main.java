/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO;

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
       burbuja bur1 = new burbuja();
       burbujaOptimizado bur2 = new burbujaOptimizado();
       IncertSort prueba3 = new IncertSort();

             
       ArrayList<AlgoritmoOrdenamiento>  lista= new ArrayList<>();
       lista.add(bur1);
       lista.add(bur2);
       lista.add(prueba3);
       
       Manager machoman = new Manager(lista);
       machoman.ejecutarPrueba(1000, 7, 50, true);
        
  }
}
