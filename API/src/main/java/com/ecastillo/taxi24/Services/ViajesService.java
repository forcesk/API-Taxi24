package com.ecastillo.taxi24.Services;

import com.ecastillo.taxi24.Models.ViajesModel;
import com.ecastillo.taxi24.Repositories.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ViajesService {
    @Autowired
    ViajesRepository viajesRepository;

    // Agregar Nuevo Solicitud de viaje
    public ResponseEntity<ViajesModel> create_viaje(ViajesModel viaje) {
        try {
            ViajesModel _viaje = viajesRepository.save(new ViajesModel(viaje.getPasajeroId(),viaje.getConductorId(), viaje.getFecha(),viaje.getPartida(),viaje.getDestino(),true));
            return new ResponseEntity<>(_viaje, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
