package com.ecastillo.taxi24.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class GeolocalizacionTest {
    Geolocalizacion geolocalizacion = new Geolocalizacion();

    @Test
    void coordenadasParTest(){
       assertTrue(geolocalizacion.getCoordenadas().size()==2);
    }

    @Test
    void GetDistanciaTest(){
        assertEquals(1,geolocalizacion.getDistance(10,10,11,11));
    }

    @Test
    void check3KMTest(){
        assertEquals(true,geolocalizacion.checkDistancia(0,0,14,14));
    }

    @Test
    void tarifaTest(){
        assertEquals(180.0,geolocalizacion.getTarifa(120));
    }

}