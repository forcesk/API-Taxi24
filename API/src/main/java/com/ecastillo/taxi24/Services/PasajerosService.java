package com.ecastillo.taxi24.Services;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.PasajerosModel;
import com.ecastillo.taxi24.Repositories.PasajerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PasajerosService {

    @Autowired
    PasajerosRepository pasajerosRepository;

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

}
