/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;


/**
 *
 * @author memotets89
 */
class TSP { 
    private int  valor [] ;
    private int tardo = Integer.MAX_VALUE;
   
    public TSP (int n){
        this.valor = new int[n];
    }
    
    //Funcion del camino menos pesado, más corto
    // Ciclo Hamiltoniano 
    private int CaminoMasCorto(int[][] Grafo, boolean[] BanderaRecorrida, int PosicionActual, int n, int Contador, int Peso, int ans, int[] Camino){ 
   
        //Si llege a recorrer todas las ciudades y no he vuelto a la primera
        if (Contador == n && Grafo[PosicionActual][0] > 0){ 
            //ans dentro del minimo es una vieja solución, y Peso actual+el ultimo tramo de ciudades es la nueva solucion
            ans = Math.min(ans, Peso + Grafo[PosicionActual][0]);
            //retorno el minimo entre esos 2 valores
            return ans; 
        } 
  
        // BACKTRACKING STEP .
        for (int i = 0; i < n; i++){
            //recorreremos todas las ciudades adyacentes no visitidas y conectadas
            if (BanderaRecorrida[i] == false && Grafo[PosicionActual][i] > 0){
                // Marcado como visitado, por ciudad
                BanderaRecorrida[i] = true;
                Camino[Contador]=i;
                //Definiremos una respuesta de camino más corto
                //Al recorrer reconstruyo mi peso, con el mismo algoritmo, i es mi posicion actual, agrego al contador de ciudades
                //al peso se le agrega el del camino recorrido, ans sigue indefinido hasta acabar 1 camino, Camino y Banderas se actualizaron arriba
                ans = CaminoMasCorto(Grafo, BanderaRecorrida, i, n, Contador + 1, Peso + Grafo[PosicionActual][i], ans, Camino);
                
                
                // si esta definición es más corta que el valor inicial
                if(ans < this.tardo){
                    //actualizamos valor
                    tardo=ans;
                    // definimos nuestro camino en este momento 
                    this.valor=Camino.clone();
                 }
                
                // marcar el i nodo como no visitado, los auxiliares quedaran como empezaron en la función
                BanderaRecorrida[i] = false;
                Camino[Contador]=0;
            } 
            
        } 
        return ans; 
    }   

    @Override
    public String toString() {
        String Aux="";
        Aux+="Camino es: ";
        for(int a =0; a<this.valor.length;a++ ) Aux+= this.valor[a]+" -> ";
        Aux += this.valor[0]+ " ";
        Aux += "Peso de : "+ this.tardo;
        return Aux;
    }

    
//Ciudades en forma    
// 0 <= i < n 
// Donde i es el numero de ciudad donde quiero empezar el recorrido
    void CiudadInicial(int Grafo[][],int n,int i) {
        //Si no tengo el camino más corto
        if (this.tardo == Integer.MAX_VALUE){
            
        //Inicializamos una matriz que nos define el camino
        // y otra de ciudades visitadas (flags), estos son completamente
        //Auxiliares para buscar el camino más corto
        int [] camino =new int[n];
        boolean[] flags = new boolean[n];
        
        // Marcamos la ciudad 0 como visitada (donde realmente inicia el algoritmo de busqueda)
        int CurrentPos= 0;
        flags[CurrentPos] = true; 
        
        // Auxiliar respuesta sera un numero muy alto porque este decrecera en la función hasta darnos el camino más corto.
        int ans = Integer.MAX_VALUE;
        
        // Encontramos el camino más corto
        this.CaminoMasCorto(Grafo, flags, CurrentPos, n, 1, 0, ans,camino);
        
        }
        
        //una vez definido, buscamos el sitio preferido
       int aux[]= this.valor.clone();
       boolean BusquedaCiudad =true;
       int recorrido=0;
        
       if (i > this.valor.length || i < 0){
           System.out.println("No existe la ciudad numero "+ i);
           BusquedaCiudad = false;
       }
       
       while(BusquedaCiudad){
           int auz=recorrido%this.valor.length; 
           if (aux[auz] == i){
               for (int x =0; x< this.valor.length; x++){
                   auz = (recorrido+x) % this.valor.length;
                   this.valor[x] = aux[auz];
               }
               BusquedaCiudad = false;
           }
           recorrido++;
       }
        
    }
    
} 
