package com.ecastillo.taxi24.Services;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Repositories.ConductoresRepository;
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



}
