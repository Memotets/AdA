package Tsp;

/**
 *
 * @author memotets89
 */
public class main {
    public static void main(String[] args){ 
        
            //Definicion del grafo a comprobar en clase
        int[][] Grafo =  {
            {  0,13,33,28,37, 7,32,40,80,26},
            {13, 0,39,83,50,68,16,98,81,55},
            {33,39, 0,80,88,49,53,75,63,55},
            {28,83,80, 0,94,  4,20,  6,59,76},
            {37,50,88,94, 0,81,87,85,  4,19},
            {  7,68,49,  4,81, 0,96,53,40,37},
            {32,16,53,20,87,96, 0,80,57,68},
            {40,98,75,  6,85,53,80, 0,65,41},
            {80,81,63,59,  4,40,57,65, 0,97},
            {26,55,55,76,19,37,68,41,97, 0}
        };
        
         //n es el numero de nodos del grafo, numero de ciudades
        int n = Grafo[0].length; 
        
        //Iniciamos el tcp
        TSP MapaCiudades = new TSP(n); 
        //Definimos nuestra ciudad inicial pensado para que la primera ciudad sea la ciudad 0
        MapaCiudades.CiudadInicial(Grafo, n,4);
        
        System.out.println(MapaCiudades.toString());
    } 
}
    

