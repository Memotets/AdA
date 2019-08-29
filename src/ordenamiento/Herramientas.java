package ordenamiento;
import java.util.Random;

public class Herramientas{
  public static double[] generarArrayAleatorio(int dim,int rang){
    double[] Array = new double[dim];
    Random r = new Random();
    for (int x=0; x<dim; x++){
      Array[x] = r.nextInt(rang);
    }
    return Array;
  }
    public static double[] generarArrayPeor(int dim){
    double[] Array = new double[dim];
    for (int x=0; x<dim; x++){
      Array[x] = dim-x;
    }
    return Array;
  }
    public static double[] generarArrayMejor(int dim){
    double[] Array = new double[dim];
    for (int x=0; x<dim; x++){
      Array[x] = x;
    }
    return Array;
  }
    
}
