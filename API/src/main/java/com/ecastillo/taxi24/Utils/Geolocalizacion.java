package com.ecastillo.taxi24.Utils;

import java.util.ArrayList;

public class Geolocalizacion {

    // Este método proporciona un par ordenado (x,y) pseudo-aleatorio que funcionan como
    // coordenadas en 2D, de esta forma podemos simular coordenadas geográficas para este ejercicio.
    // El plano geográfico va desde (0,0) - (90,90) para acotar el ejemplo.
    public ArrayList<Integer> getCoordenadas(){
        ArrayList<Integer> array = new ArrayList();
        Integer x  =  (int)(Math.random() * 90) + 0;
        Integer y  =  (int)(Math.random() * 90) + 0;
        array.add(x);
        array.add(y);
        return array;
    }


    // Está función calcula la distancia entre 2 pares ordenados.
    // Cualquier distancia menor a 30 se toma como menor a 3KM
    public Boolean checkDistancia(Integer inx,Integer iny,Integer tox,Integer toy){
        Integer diffX = tox-inx;
        Integer diffY = toy-iny;

        Double dist = Math.pow(diffX,2) +  Math.pow(diffY,2);

        if(Math.sqrt(dist) < 30)
            return true;

        return false;

    }

    // Está función calcula  y regresa la distancia entre 2 pares ordenados.
    public Integer getDistance(Integer inx,Integer iny,Integer tox,Integer toy){
        Integer diffX = tox-inx;
        Integer diffY = toy-iny;

        Double dist = Math.pow(diffX,2) +  Math.pow(diffY,2);

        return (int)Math.sqrt(dist);

    }

    public double getTarifa(Integer distance){
        return distance*1.5;
    }

}
