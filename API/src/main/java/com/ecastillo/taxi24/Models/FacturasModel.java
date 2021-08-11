package com.ecastillo.taxi24.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="facturas")
public class FacturasModel {

    @Id
    private String id;
    private String viajeId;
    private String conductorId;
    private String pasajeroId;
    private String fecha;
    private Float tarifa;

    public FacturasModel(){}

    public FacturasModel(String viajeId, String conductorId, String pasajeroId, String fecha, Float tarifa) {
        this.viajeId = viajeId;
        this.conductorId = conductorId;
        this.pasajeroId = pasajeroId;
        this.fecha = fecha;
        this.tarifa = tarifa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViajeId() {
        return viajeId;
    }

    public void setViajeId(String viajeId) {
        this.viajeId = viajeId;
    }

    public String getConductorId() {
        return conductorId;
    }

    public void setConductorId(String conductorId) {
        this.conductorId = conductorId;
    }

    public String getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(String pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getTarifa() {
        return tarifa;
    }

    public void setTarifa(Float tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "FacturasModel{" +
                "id='" + id + '\'' +
                ", viajeId='" + viajeId + '\'' +
                ", conductorId='" + conductorId + '\'' +
                ", pasajeroId='" + pasajeroId + '\'' +
                ", fecha='" + fecha + '\'' +
                ", tarifa=" + tarifa +
                '}';
    }
}
