package ordenamiento;

public class merge implements AlgoritmoOrdenamiento{
  private double[] arreglo;
  public merge(){}

  @Override
  public void definirDatos(double[] arreglo){
    this.arreglo= arreglo;
  }
  @Override
  public double ordenar() {
    double aux=0;
    double ti = System.currentTimeMillis();
    //metodo

    //------
    double tf = System.currentTimeMillis();
    double current = tf-ti;
    return current;
  }
}
