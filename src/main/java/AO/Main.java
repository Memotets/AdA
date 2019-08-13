/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AO;

import ordenamiento.Herramientas;
import ordenamiento.burbuja;

/**
 *
 * @author memotets89
 */
public class Main {
    public static void main(String[] args) {
        burbuja bur = new burbuja();
        
        double originalA [] = Herramientas.generarArrayAleatorio(50000, 3000);
      //  double originalB [] = Herramientas.generarArrayMejor(50000);
       // double originalW [] = Herramientas.generarArrayPeor(50000);
       for(int i =0; i<20; i++){
        bur.definirDatos(originalA.clone());
        System.out.println("Tiempo: "+bur.ordenar());
       }
        System.out.print("");
        
  }
}
