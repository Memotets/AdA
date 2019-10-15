/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursive;

/**
 *
 * @author memotets89
 */
class GFG  
{ 
  
    // Function to find the minimum weight  
    // Hamiltonian Cycle 
    static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans){ 
  
        // If last node is reached and it has a link 
        // to the starting node i.e the source then 
        // keep the minimum value out of the total cost 
        // of traversal and "ans" 
        // Finally return to check for more possible values 
        if (count == n && graph[currPos][0] > 0){ 
            ans = Math.min(ans, cost + graph[currPos][0]); 
            return ans; 
        } 
  
        // BACKTRACKING STEP 
        // Loop to traverse the adjacency list 
        // of currPos node and increasing the count 
        // by 1 and cost by graph[currPos,i] value 
        for (int i = 0; i < n; i++){ 
            if (v[i] == false && graph[currPos][i] > 0){
                // Mark as visited 
                v[i] = true; 
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans); 
                // Mark ith node as unvisited 
                v[i] = false; 
            } 
        } 
        return ans; 
    } 
  
    // Driver code 
    public static void main(String[] args){ 
        // n is the number of nodes i.e. V 
        int n = 4; 
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
        flags[0] = true; 
        
        int ans = Integer.MAX_VALUE; 
        // Find the minimum weight Hamiltonian Cycle 
        ans = tsp(graph, flags, 0, n, 1, 0, ans); 
  
        // ans is the minimum weight Hamiltonian Cycle 
        System.out.println(ans); 
    } 
} 
  
// This code is contributed by Rajput-Ji 
