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
public class QuickSort implements AlgoritmoOrdenamiento{

    private double[] arreglo;
    boolean ExisteHilo;
    private double tt;
    
    public QuickSort(){
        this.ExisteHilo=false;
        this.arreglo=null;
    }
    
     public QuickSort(boolean wop){
        this.ExisteHilo=wop;
        this.arreglo=null;
    }
    
    private void ordenarQuick(double[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		double pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				double temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			ordenarQuick(arr, low, j);
 
		if (high > i)
			ordenarQuick(arr, i, high);
	
        
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
        
            double ti = System.currentTimeMillis();
    //metodo----------------------------------------------------------------------------------
            this.ordenarQuick(this.arreglo, 0, this.arreglo.length-1); 
     //--------------------------------------------------------------------------------------------
            double tf = System.currentTimeMillis();
            tt = tf-ti;
        
    }
}
