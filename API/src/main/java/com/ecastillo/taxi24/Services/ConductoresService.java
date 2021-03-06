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
import java.util.*;

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

            // Se obtienen las coordenadas que simulan la ubicaci??n del solicitante.
            Geolocalizacion geolocalizacion = new Geolocalizacion();
            ArrayList<Integer> coor_solicitud = new ArrayList();
            coor_solicitud =  geolocalizacion.getCoordenadas();

            System.out.println("\n");
            System.out.println("Coordenadas Usuario");
            System.out.println(coor_solicitud);


            // Se simulan ubicaciones para cada conductor registrado,
            // de tal manera que sea din??mica la ubicaci??n de cada conductor.
            for (int i=0;i<conductores.size();i++) {

                ArrayList<Integer> coor_conductor = new ArrayList();
                coor_conductor =  geolocalizacion.getCoordenadas();

                System.out.println("Coordenadas Conductor id: "+conductores.get(i).getId());
                System.out.println(coor_conductor);

                // Si el conductor esta a m??s de 3KM se marca momentaneamente como NO DISPONIBLE
                if(!geolocalizacion.checkDistancia(coor_conductor.get(0),coor_conductor.get(1),coor_solicitud.get(0),coor_solicitud.get(1))){
                    System.out.println("Muy lejos");
                    conductores.get(i).setDisponible(false);
                }

                else{
                    System.out.println("Conductor cercano");
                }

            }

            // funci??n lambda que remueve conductores no disponibles, de esta manera
            // solo se pasan los conductores cercanos >3KM
            conductores.removeIf(n -> (n.getDisponible() == false));

            return new ResponseEntity<>(conductores, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Regresa un Conductor por ID
    public ResponseEntity<ConductoresModel> get_ConductorById(String id) {
        Optional<ConductoresModel> conductorData = conductoresRepository.findById(id);

        if (conductorData.isPresent()) {
            return new ResponseEntity<>(conductorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
