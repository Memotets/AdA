     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;

import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class mochila {
    
    private final ArrayList<Item> Items;
    private ArrayList<Item> Solucion;
    private double[][] MatrizBeneficios;
    private final int PesoMochila;
    private int maxBenefit;

    public mochila(ArrayList<Item> items, int W) {
        
        this.Items = items;
        this.PesoMochila = W;
        construirMatrizBeneficios();

    }


    private void construirMatrizBeneficios() {
        // construimos la matriz de beneficios 
        this.MatrizBeneficios = new double[this.Items.size()+1][this.PesoMochila+1];
        // agregar en la primer columna puros ceros
        for (int x=0;x <= this.Items.size();x++)
            this.MatrizBeneficios[x][0] = 0;
        // agregar en la primer fila puros ceros
        
        for (int x=0;x <= this.PesoMochila;x++)
            this.MatrizBeneficios[0][x] = 0;
        
    }
    
    
    public void buscarSolucion(){
        
       // calculamos la matriz de beneficios
       for (int i=1;i <= this.Items.size();i++){
           for(int w=0; w<= this.PesoMochila;w++){
           // verificamos si el item puede ser parte de la solucion
               if  (this.Items.get(i-1).getPeso()<= w){
                   if ((this.Items.get(i-1).getValor() + this.MatrizBeneficios[i-1][w-this.Items.get(i-1).getPeso()]) > this.MatrizBeneficios[i-1][w]){
                       this.MatrizBeneficios[i][w] = this.Items.get(i-1).getValor() + this.MatrizBeneficios[i-1][w-this.Items.get(i-1).getPeso()]; 
                   }else{
                        this.MatrizBeneficios[i][w] = this.MatrizBeneficios[i-1][w];
                   }
               }else{
                    this.MatrizBeneficios[i][w] = this.MatrizBeneficios[i-1][w];
               }
           }
       }
       this.maxBenefit = (int)this.MatrizBeneficios[Items.size()][PesoMochila];
       this.Solucion = new ArrayList<>();
       
       // calcular los elementos de PesoMochila
       
       int i = this.Items.size();
       int j = this.PesoMochila;

       while (i > 0 && j > 0){
           double val = this.MatrizBeneficios[i][j];
          if( val != this.MatrizBeneficios[i-1][j]){
              this.Solucion.add(this.Items.get(i-1));
              // imprimir el articulo
              String aux =this.Items.get(i-1).toString();
              System.out.println(aux);
              i--;
              j = j - this.Items.get(i).getPeso();
          } else {
            i--;
          }
                   
       }       
           
       System.out.println();
        }

   
    
}
