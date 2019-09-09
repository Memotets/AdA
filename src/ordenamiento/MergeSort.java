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
public class MergeSort implements AlgoritmoOrdenamiento {
    private double[] arreglo;
    private double tt;
    private boolean ExisteHilo;
    
    public MergeSort(){
      this.ExisteHilo=false;
      this.arreglo=null;
    }
    
    public MergeSort(boolean i){
      this.ExisteHilo=i;
      this.arreglo=null;
    }
  
    @Override
    public void definirDatos(double[] arreglo) {
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
    //metodo----------------------------------------------------------------------------------
    
        Merge(this.arreglo, 0, this.arreglo.length-1); 
    
     //--------------------------------------------------------------------------------------------
    double tf = System.currentTimeMillis();
    tt = tf-ti;
    }
    
    public void Sort(double[] Array, int inicio,int medio,int ultimo){
        // Find sizes of two subarrays to be merged 
        int n1 = medio - inicio + 1; 
        int n2 = ultimo - medio;
        
        /* Create temp arrays */
        double L[] = new double [n1]; 
        double R[] = new double [n2];
        
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) L[i] = Array[inicio + i]; 
        for (int j=0; j<n2; ++j) R[j] = Array[medio + 1+ j]; 
        
        /* Merge the temp arrays */
        
        // Initial indexes of first and second subarrays 
        int x = 0, y = 0; 
        
        // Initial index of merged subarry array 
        int k = inicio; 
        while (x < n1 && y < n2) 
        { 
            if (L[x] <= R[y]) 
            { 
                Array[k] = L[x]; 
                x++; 
            } 
            else
            { 
                Array[k] = R[y]; 
                y++; 
            } 
            k++; 
        } 
        
        /* Copy remaining elements of L[] if any */
        while (x < n1) 
        { 
            Array[k] = L[x]; 
            x++; 
            k++; 
        } 
        
        /* Copy remaining elements of R[] if any */
        while (y < n2) 
        { 
            Array[k] = R[y]; 
            y++; 
            k++; 
        } 
    }
    
    public void Merge(double Array[], int i, int f){
        if (i < f) 
        { 
            // Find the middle point 
            int m = (i+f)/2; 
            // Merge first and second halves 
            Merge(Array, i, m); 
            Merge(Array , m+1, f); 
            // Merge the sorted halves 
            Sort(Array, i, m, f); 
        } 
    }
}
