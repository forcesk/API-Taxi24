package com.ecastillo.taxi24.Services;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.FacturasModel;
import com.ecastillo.taxi24.Models.ViajesModel;
import com.ecastillo.taxi24.Repositories.FacturasRepository;
import com.ecastillo.taxi24.Utils.Geolocalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturasService {

    @Autowired
    FacturasRepository facturasRepository;

    // Agregar una nueva Factura
    public void create_Factura(String viajeId, String conductorId, String idPasajero, String fecha) {
        try {
            Double tarifa = 25.0; // Precio del servicio.
            facturasRepository.save(new FacturasModel(viajeId,conductorId,idPasajero,fecha,tarifa));

        } catch (Exception e) {
        }
    }

    // Obtener toda la lista de Facturas registrados
    public ResponseEntity<List<FacturasModel>> get_AllFacturas() {
        try {
            List<FacturasModel> facturas = new ArrayList<FacturasModel>();
            facturasRepository.findAll().forEach(facturas::add);
            if (facturas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(facturas, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
