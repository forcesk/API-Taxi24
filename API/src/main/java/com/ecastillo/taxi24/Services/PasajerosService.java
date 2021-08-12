package com.ecastillo.taxi24.Services;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.PasajerosModel;
import com.ecastillo.taxi24.Repositories.ConductoresRepository;
import com.ecastillo.taxi24.Repositories.PasajerosRepository;
import com.ecastillo.taxi24.Utils.Geolocalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PasajerosService {

    @Autowired
    PasajerosRepository pasajerosRepository;

    @Autowired
    ConductoresRepository conductoresRepository;

    // Obtener toda la lista de Pasajeros registrados
    public ResponseEntity<List<PasajerosModel>> get_AllPasajeros() {
        try {
            List<PasajerosModel> pasajeros = new ArrayList<PasajerosModel>();
            pasajerosRepository.findAll().forEach(pasajeros::add);
            if (pasajeros.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pasajeros, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Regresa un Pasajero por ID
    public ResponseEntity<PasajerosModel> get_PasajeroById(String id) {
        Optional<PasajerosModel> pasajeroData = pasajerosRepository.findById(id);

        if (pasajeroData.isPresent()) {
            return new ResponseEntity<>(pasajeroData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Obtiene una lista con los 3 conductores más cercanos
    public  ResponseEntity<List<ConductoresModel>> get_3Conductores(String usuarioId,Integer total) {
        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> Sort_list = new ArrayList();
        ArrayList<Integer> resp = new ArrayList();

        try {
            List<ConductoresModel> conductores = conductoresRepository.findByDisponibleIsTrue();

            // Si no hay conductores se regresa vacio
            if (conductores.isEmpty()) {
                list.add(-1);
                return null;
            }

            // Se obtienen las coordenadas que simulan la ubicación del solicitante.
            Geolocalizacion geolocalizacion = new Geolocalizacion();
            ArrayList<Integer> coor_solicitud = geolocalizacion.getCoordenadas();

            // Se simulan ubicaciones para cada conductor registrado,
            // de tal manera que sea dinámica la ubicación de cada conductor.
            for (int i=0;i<conductores.size();i++) {

                ArrayList<Integer> coor_conductor = new ArrayList();
                coor_conductor =  geolocalizacion.getCoordenadas();

                // Se obtiene la distancia entre el solicitante y el conductor
                list.add(geolocalizacion.getDistance(coor_conductor.get(0),coor_conductor.get(1),coor_solicitud.get(0),coor_solicitud.get(1)));
                Sort_list.add(list.get(i));
            }

            // Se ordenan las distancias de menor a mayor.
            Sort_list.sort(Comparator.naturalOrder());

            for(int i=0;i<Sort_list.size();i++)
                System.out.println(Sort_list.get(i));

            // Se obtiene el indice del conductor a partir de la distancia entre solicitante-conductor
            for(int i=0;i<total;i++){
                for(int j=0;j<Sort_list.size();j++) {
                    if (Sort_list.get(i)==list.get(j))
                        resp.add(j);
                }
            }

            // se marca los conductores cercanos poniendo disponible en falso momentaneamente
            for(int i=0;i<total;i++){
                conductores.get(resp.get(i)).setDisponible(false);
            }

            // Se remueven de la lista los conductores no disponibles
            conductores.removeIf(n -> (n.getDisponible() == false));

            // Se regresan los conductores cercanos
            return new ResponseEntity<>(conductores, HttpStatus.OK);

        } catch (Exception e) {
            return null;
        }
    }

}
