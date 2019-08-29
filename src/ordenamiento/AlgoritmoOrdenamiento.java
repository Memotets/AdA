/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author memotets89
 */
public interface AlgoritmoOrdenamiento extends Runnable{
  void definirDatos(double[] arreglo);
  void ordenar();
  double getTt();
 

}
