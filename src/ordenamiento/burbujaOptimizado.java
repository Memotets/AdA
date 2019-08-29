package ordenamiento;

public class burbujaOptimizado implements AlgoritmoOrdenamiento{
    
  private double[] arreglo;
  private double tt;
  private boolean ExisteHilo;
  
  public burbujaOptimizado(){
      this.ExisteHilo=false;
      this.arreglo=null;
  }
  public burbujaOptimizado(boolean i){
      this.ExisteHilo=i;
      this.arreglo=null;
  }
    
  @Override
  public void definirDatos(double[] arreglo){
    this.arreglo= arreglo;
  }
  @Override
  public void ordenar() {
       if(ExisteHilo){
           Thread hilo = new Thread(this);
           hilo.start();
       }else{
           run();
       }
  }

    @Override
    public double getTt() {
        return tt;
    }

    @Override
    public void run() {
        double aux=0;
    double ti = System.currentTimeMillis();
    //metodo

    for (int i =0; i<arreglo.length; i++){
      for(int j= 0; j<i; j++){
        if(arreglo[i]< arreglo[j]){
          aux = arreglo[i];
          arreglo [j] = arreglo[i];
          arreglo [i] = aux;
        }
      }
    }
    double tf = System.currentTimeMillis();
    tt = tf-ti;
    }
}
