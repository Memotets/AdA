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

public class burbuja extends Thread implements AlgoritmoOrdenamiento {
  private double[] arreglo;
  private double tt;
  private boolean ExisteHilo;
  
  public burbuja(){
      this.ExisteHilo=false;
      this.arreglo=null;
  }
  public burbuja(boolean i){
        this.ExisteHilo=i;
        this.arreglo=null;
  }
  @Override
  public void definirDatos(double[] arreglo){
    this.arreglo = arreglo;
  }
  @Override
  public void ordenar() {
    //metodo----------------------------------------------------------------------------------------
       if(ExisteHilo){
           Thread hilo = new Thread(this);
           hilo.start();
       }else{
           run();
       }
   
    //---------------------------------------------------------------------------------------
  }

    @Override
    public void run() {
            double ti = System.currentTimeMillis();
            
             for (int x = 0; x<arreglo.length; x++){
                    for(int j= 0; j<arreglo.length; j++){
                        if(arreglo[x] < arreglo[j]){
                               double aux = arreglo[x];
                               arreglo [x] = arreglo[j];
                               arreglo [j] = aux;
                        }
                    }
            }
           double tf = System.currentTimeMillis();
           this.tt = tf-ti;
    }

    @Override
    public double getTt() {
       return tt; 
    }
  
  

}
