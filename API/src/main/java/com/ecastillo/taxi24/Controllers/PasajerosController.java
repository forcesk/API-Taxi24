package com.ecastillo.taxi24.Controllers;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.PasajerosModel;
import com.ecastillo.taxi24.Services.PasajerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajerosController {

    @Autowired
    PasajerosService pasajerosService;

    // Pasajeros Registrados GET
    @GetMapping()
    public ResponseEntity<List<PasajerosModel>> getAllPasajeros() {
        return this.pasajerosService.get_AllPasajeros();
    }

    // Regresa un pasajero por su Id.
    @GetMapping("/{id}")
    public ResponseEntity<PasajerosModel> getPasajeroPorId(@PathVariable("id") String id) {
        return  this.pasajerosService.get_PasajeroById(id);
    }

    // Regresa los 3 conductores más cercanos
    @GetMapping("/near/{usuarioId}")
    public ResponseEntity<List<ConductoresModel>> get_3Conductores(@PathVariable("usuarioId") String usuarioId) {
       return this.pasajerosService.get_3Conductores(usuarioId,3);
    }


}
