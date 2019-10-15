/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;
//import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author memotets89
 */
public class Herramientas {
    
   public static ArrayList<Item> instancias;
   
   public static void leerDatos(String ruta){
         instancias = new ArrayList<>();
         String texto, aux;
         LinkedList<String> lista = new LinkedList();
         
         try {
          
            //abrimos el archivo ruta
            File abre =new File(ruta);
            //Desktop.getDesktop().open(abre);

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }
                    
                    int[] vector = new int [2];

                    for (int x = 0; x < 2; x++) {
                        vector[x] = Integer.parseInt(lista2.get(x));
                    }
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Item(vector[0],vector[1]));
                    // patrones.add();
                    lista2.clear();
                }
            } else {
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);            
        }
         
    }
   
   public static void EscribirArticulos(int randomPeso,int randomBeneficio,int n){
       
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("/home/memotets89/lista.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < n; i++){
                 Random valor = new Random();
                 pw.println(valor.nextInt(randomPeso)+"," + valor.nextInt(randomBeneficio));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
   }
}
