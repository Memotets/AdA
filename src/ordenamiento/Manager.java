/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class Manager {
    private ArrayList<AlgoritmoOrdenamiento> metodos;
    
    public Manager(){
        this.metodos= new ArrayList<>();
    }
    public Manager(ArrayList cosa){
        this.metodos=cosa;
    }
    
    
    public void ejecutarPrueba (int pruebas, int rango, int rangoAlt, boolean grafica){
       ArrayList<Double []> tiemposTotales = new ArrayList<>();
       
       for (int j=0; j<this.metodos.size(); j++){
           tiemposTotales.add(new Double[pruebas]);
       }
       
       for(int p=0; p<pruebas;p++){
           double datos[] = Herramientas.generarArrayAleatorio((p)*rango, rangoAlt);
           for(int a=0; a<this.metodos.size() ; a++){
               AlgoritmoOrdenamiento aux = this.metodos.get(a);
               aux.definirDatos(datos.clone());
               aux.ordenar();
               tiemposTotales.get(a)[p]= aux.getTt();
           }
           System.out.println(p);
       }
       if(grafica){
            Grafica g = new Grafica("id Algoritmo", "Tiempo", "Prueba basica de ordenamiento");
            for (int x=0; x<tiemposTotales.size(); x++){
                g.agregarSerie(tiemposTotales.get(x), ""+x);
            }
                g.creaYmuestraGrafica();
       }
    }
    
    
    public void ejecutarPrueba (double [] datos, boolean grafica){
        double tiempos[]= new double[metodos.size()];
        int p = 0;
        //recorrer la list de algoritmo
        for (AlgoritmoOrdenamiento a: this.metodos){
            a.definirDatos(datos.clone());
            a.ordenar();
            tiempos[p]= a.getTt();
           System.out.println("tiempo: "+tiempos[p]);
            p++;
        }
        if(grafica){
            Grafica g = new Grafica("id Algoritmo", "Tiempo", "Prueba basica de ordenamiento");
            g.agregarSerie(tiempos, "0");
            g.creaYmuestraGrafica();
        }
        
    }
    
    
}