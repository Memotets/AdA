package ordenamiento;

public class IncertSort implements AlgoritmoOrdenamiento{
  private double[] arreglo;
  private boolean ExisteHilo;
  private double tt;
  
  public IncertSort(){
      this.ExisteHilo=false;
      this.arreglo=null;
  }
  
  public IncertSort(boolean i){
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
     int pos;
    double aux=0;
    double ti = System.currentTimeMillis();
    //metodo
    for(int i =0; i< this.arreglo.length;i++){
        pos = i;
        aux = arreglo[i];
        while((pos>0)&&(arreglo[pos-1]>aux)){
            arreglo[pos] = arreglo[pos-1];
            pos--;
        }
        arreglo[pos]=aux;
        
    }

    //------
    double tf = System.currentTimeMillis();
    this.tt = tf-ti;
    }
}
