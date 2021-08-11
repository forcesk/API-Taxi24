package com.ecastillo.taxi24.Controllers;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.ViajesModel;
import com.ecastillo.taxi24.Repositories.ViajesRepository;
import com.ecastillo.taxi24.Services.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viajes")
public class ViajesController {

    @Autowired
    ViajesService viajesService;

    // Viajes Activos - En Curso GET
    @GetMapping()
    public ResponseEntity<List<ViajesModel>> getAllViajes() {
        return this.viajesService.get_AllViajes();
    }

}
