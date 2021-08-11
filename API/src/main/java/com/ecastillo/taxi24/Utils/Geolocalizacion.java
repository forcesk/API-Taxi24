package com.ecastillo.taxi24.Utils;

import java.util.ArrayList;

public class Geolocalizacion {

    // Este método proporciona un para ordenado (x,y) que funcionan como coordenadas en 2D
    // de esta forma podemos simular coordenadas geográficas para este ejercicio.
    // El plano geográfico va desde (0,0) - (90,90) para acotar el ejemplo.
    public ArrayList<Integer> getCoordenadas(){
        ArrayList<Integer> array = new ArrayList();
        Integer x  =  (int)(Math.random() * 90) + 0;
        Integer y  =  (int)(Math.random() * 90) + 0;
        array.add(x);
        array.add(y);
        return array;
    }

}
