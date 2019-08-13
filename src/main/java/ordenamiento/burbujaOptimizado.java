package ordenamiento;

public class burbujaOptimizado implements AlgoritmoOrdenamiento{
    
  private double[] arreglo;
  public burbujaOptimizado(){}
    
  @Override
  public void definirDatos(double[] arreglo){
    this.arreglo= arreglo;
  }
  @Override
  public double ordenar() {
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
    double current = tf-ti;
    return current;
  }
}
