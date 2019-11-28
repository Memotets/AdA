/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import java.util.ArrayList;

/**
 *
 * @author memotets89
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Configuracion> conf = new ArrayList();
        //Configuracion c1 = new Configuracion(int numGeneraciones, int tamPoblacion, double probMuta, double pMuestra, Seleccion.TipoSeleccion[] tipoSeleccion, int tamGenotipo );
        Configuracion c1 = new Configuracion(20000, 35, 0.25, 0.015, new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM, Seleccion.TipoSeleccion.TORNEO}, 90);
        conf.add(c1);

        Manager m = new Manager("Confi : ", c1.getTamGenotipo());
        m.generarGeneticos(conf);
        m.ejecutarGeneticos();

    }

}
