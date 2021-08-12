package com.ecastillo.taxi24.Services;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.ViajesModel;
import com.ecastillo.taxi24.Repositories.ConductoresRepository;
import com.ecastillo.taxi24.Repositories.ViajesRepository;
import com.ecastillo.taxi24.Utils.Geolocalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViajesService {
    @Autowired
    ViajesRepository viajesRepository;

    @Autowired
    ConductoresRepository conductoresRepository;

    @Autowired
    FacturasService facturasService;


    // Obtener toda la lista de Viajes enCurso (Activos)
    public ResponseEntity<List<ViajesModel>> get_AllViajes() {
        try {
            List<ViajesModel> viajes = new ArrayList<ViajesModel>();
            viajesRepository.findByEnCursoTrue().forEach(viajes::add);
            if (viajes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(viajes, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Agregar Nuevo Solicitud de viaje
    public ResponseEntity<ViajesModel> create_viaje(String idPasajero) {
        try {
            // Se obtienen la geolocalización del usuario que solicita el viaje
            Geolocalizacion geolocalizacion = new Geolocalizacion();
            ArrayList<Integer> partida = geolocalizacion.getCoordenadas();
            String part = ""+partida.get(0)+","+partida.get(1);
            ArrayList<Integer> destino = geolocalizacion.getCoordenadas();
            String dest = ""+destino.get(0)+","+destino.get(1);
            LocalDate date = LocalDate.now();

            // Se obtiene el id de un conductor libre para asignar a el nuevo viaje
            List<ConductoresModel> conductores = conductoresRepository.findByDisponibleIsTrue();
            String conductorId =conductores.get((int)(Math.random() * conductores.size()-1) + 0).getId();

            // Se guarda en la DB el nuevo viaje
            ViajesModel _viaje = viajesRepository.save(new ViajesModel(idPasajero,conductorId, date.toString(),part,dest,true));
            return new ResponseEntity<>(_viaje, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Finaliza un Viaje por ID
    public ResponseEntity<ViajesModel> end_Viaje(String idViaje) {
        Optional<ViajesModel> viajeData = viajesRepository.findById(idViaje);

        if (viajeData.isPresent()) {
            viajeData.get().setEnCurso(false); // Se finaliza el viaje
            viajesRepository.save(viajeData.get());

            Geolocalizacion geolocalizacion = new Geolocalizacion();
            String init = viajeData.get().getPartida();
            String dest = viajeData.get().getDestino();

            String[] init2 = init.split(",");
            String[] dest2 = dest.split(",");

            Integer distance = geolocalizacion.getDistance(Integer.parseInt(init2[0]), Integer.parseInt(init2[1]), Integer.parseInt(dest2[0]), Integer.parseInt(dest2[1]));

            // Se crea una factura y se agrega al DB
            facturasService.create_Factura(viajeData.get().getId(),viajeData.get().getPasajeroId(),viajeData.get().getConductorId(),viajeData.get().getFecha(),distance);

            return new ResponseEntity<>(viajeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
