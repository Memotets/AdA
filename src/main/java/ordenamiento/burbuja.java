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

public class burbuja implements AlgoritmoOrdenamiento {
  private double[] arreglo;
  public burbuja(){}
  @Override
  public void definirDatos(double[] arreglo){
    this.arreglo= arreglo;
  }
  @Override
  public double ordenar() {
    double aux=0;
    double ti = System.currentTimeMillis();
    //metodo----------------------------------------------------------------------------------------

    for (int i =1; i<arreglo.length; i++){
      for(int j= 0; j<arreglo.length-1; j++){
        if(arreglo[j]> arreglo[j+1]){
          aux = arreglo[j];
          arreglo [j] = arreglo[j+1];
          arreglo [j+1] = aux;
        }
      }
    }
    //---------------------------------------------------------------------------------------
    double tf = System.currentTimeMillis();
    double current = tf-ti;
    return current;
  }

}
