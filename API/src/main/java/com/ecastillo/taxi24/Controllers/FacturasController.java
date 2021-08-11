package com.ecastillo.taxi24.Controllers;
import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.FacturasModel;
import com.ecastillo.taxi24.Services.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturasController {

    @Autowired
    FacturasService facturasService;

    // Facturas Registrados GET
    @GetMapping()
    public ResponseEntity<List<FacturasModel>> getAllFacturas() {
        return this.facturasService.get_AllFacturas();
    }
}
