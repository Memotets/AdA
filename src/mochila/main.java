/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochila;

import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class main {
    public static void main(String[] args) {
    Herramientas.EscribirArticulos(100, 100, 100);
    Herramientas.leerDatos("/home/memotets89/lista.txt");
    ArrayList<Item> wop=Herramientas.instancias;
    System.out.println(wop.toString());
    mochila back=new mochila(wop,10);
    back.buscarSolucion();
    System.out.print("");
    }
    
}
