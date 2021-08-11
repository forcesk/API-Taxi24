package com.ecastillo.taxi24.Controllers;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Services.ConductoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class ConductoresController {

    @Autowired
    ConductoresService conductoresService;

    // Conductores Registrados GET
    @GetMapping()
    public ResponseEntity<List<ConductoresModel>> getAllConductores() {
        return this.conductoresService.get_AllConductores();
    }

    // Conductores Disponibles GET
    @GetMapping("/disponibles")
    public ResponseEntity<List<ConductoresModel>> getConductoresDisponibles() {
        return this.conductoresService.get_ConductoresDisponibles();
    }

}
