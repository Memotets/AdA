/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;

/**
 *
 * @author memotets89
 */
public class Item {
    private int peso;
    private int valor;
    
    public Item(){}

    public Item(int peso, int beneficios) {
        this.peso = peso;
        this.valor = beneficios;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
    @Override
    public String toString() {
        return  peso + "," + valor;
    }
    
    
    
}
