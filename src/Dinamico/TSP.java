/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamico;


/**
 *
 * @author memotets89
 */
class TSP { 
    //
    //Funcion del camino menos pesado
    // Ciclo Hamiltoniano 
    static int tsp(int[][] Grafo, boolean[] BanderaRecorrida, int PosicionActual, int n, int Contador, int Peso, int ans){ 
        //Si el ultimo nodo alcazado tiene conexion
        //con el nodo inicial, es decir el origen
        //Entonces el valor minimo se mantendra 
        //afuera de la solucion del recorrido y "ans"
        //FInalmente retornamos para que cheque más valores
        if (Contador == n && Grafo[PosicionActual][0] > 0){ 
            ans = Math.min(ans, Peso + Grafo[PosicionActual][0]); 
            return ans; 
        } 
  
        // BACKTRACKING STEP .
        //Loop del recorrido de los nodos adyacentes
        //de la posicion actual y aumentar el Contador en 1
        // y el costo en se agrega el peso recorrido
        for (int i = 0; i < n; i++){ 
            if (BanderaRecorrida[i] == false && Grafo[PosicionActual][i] > 0){
                // Marcado como visitado
                BanderaRecorrida[i] = true; 
                ans = tsp(Grafo, BanderaRecorrida, i, n, Contador + 1, Peso + Grafo[PosicionActual][i], ans); 
                // marcar el i nodo como no visitado 
                BanderaRecorrida[i] = false; 
            } 
        } 
        return ans; 
    } 
  
    // Driver code 
    public static void main(String[] args){ 
        // n is the number of nodes i.e. V .
        int n = 10; 
        int[][] graph =  {
            { 0,13, 33, 28, 37,   7, 32, 40, 80, 26},
            { 13,  0, 39, 83, 50, 68, 16, 98, 81, 55},
            { 33,  39,   0, 80, 88, 49, 53, 75, 63, 55},
            { 28,  83,   80,   0, 94,   4, 20,   6, 59, 76},
            { 37,  50,   88,   94,   0, 81, 87, 85,   4, 19},
            { 7,  68,     49,   4,   81,   0, 96, 53, 40, 37},
            { 32,  16,   53,   20,   87,   96,   0, 80, 57, 68},
            { 40,  98,   75,   6,   85,   53,   80,   0, 65, 41},
            { 80,  81,   63,   59,   4,   40,   57,   65,   0, 97},
            { 26,  55,   55,   76,   19,   37,   68,   41,   97,   0}
        };
  
        // Boolean array to check if a node 
        // has been visited or not 
        boolean[] flags = new boolean[n]; 
        // Mark 0th node as visited
        int CurrentPos= 0;
        
        flags[CurrentPos] = true; 
        
        int ans = Integer.MAX_VALUE; 
        // Find the minimum weight Hamiltonian Cycle 
        ans = tsp(graph, flags, CurrentPos, n, 1, 0, ans); 
  
        // ans is the minimum weight Hamiltonian Cycle 
        System.out.println(ans); 
    } 
} 
  
// This code is contributed by Rajput-Ji 
