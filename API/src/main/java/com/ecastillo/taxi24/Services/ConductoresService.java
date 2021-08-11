package com.ecastillo.taxi24.Services;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Repositories.ConductoresRepository;
import com.ecastillo.taxi24.Utils.Geolocalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConductoresService {

    @Autowired
    ConductoresRepository conductoresRepository;

    // Obtener toda la lista de conductores registrados
    public ResponseEntity<List<ConductoresModel>> get_AllConductores() {
        try {
            List<ConductoresModel> conductores = new ArrayList<ConductoresModel>();
            conductoresRepository.findAll().forEach(conductores::add);
            if (conductores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(conductores, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtiene la lista de conductores Disponibles
    public ResponseEntity<List<ConductoresModel>> get_ConductoresDisponibles() {
        try {
            List<ConductoresModel> conductores = conductoresRepository.findByDisponibleIsTrue();

            if (conductores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(conductores, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtiene la lista de todos los conductores Disponibles en un radio Menor a 3KM
    public ResponseEntity<List<ConductoresModel>> getRadio3KM() {
        try {
            List<ConductoresModel> conductores = conductoresRepository.findByDisponibleIsTrue();

            // Si no hay conductores se regresa vacio
            if (conductores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Geolocalizacion geolocalizacion = new Geolocalizacion();
            ArrayList<Integer> coor_solicitud = new ArrayList();
            coor_solicitud =  geolocalizacion.getCoordenadas();

            System.out.println("\n");
            System.out.println("Coordenadas Usuario");
            System.out.println(coor_solicitud);
            System.out.println(" ");


            for (int i=0;i<conductores.size();i++) {

                ArrayList<Integer> coor_conductor = new ArrayList();
                coor_conductor =  geolocalizacion.getCoordenadas();

                System.out.println("Coordenadas Conductor: "+i);
                System.out.println(coor_conductor);

                if(!geolocalizacion.checkDistancia(coor_conductor.get(0),coor_conductor.get(1),coor_solicitud.get(0),coor_solicitud.get(1))){
                    System.out.println("Muy lejos");
                    conductores.get(i).setDisponible(false);
                }

                else{
                    System.out.println("Conductor Cercano");
                }

            }

            return new ResponseEntity<>(conductores, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
