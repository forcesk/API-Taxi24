package com.ecastillo.taxi24.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="viajes")
public class ViajesModel {

    @Id
    private String id;
    private String pasajeroId;
    private String conductorId;
    private String fecha;
    private String partida;
    private String destino;
    private Boolean enCurso;


    public ViajesModel(){}

    public ViajesModel(String pasajeroId, String conductorId, String fecha, String partida, String destino, Boolean enCurso) {
        this.pasajeroId = pasajeroId;
        this.conductorId = conductorId;
        this.fecha = fecha;
        this.partida = partida;
        this.destino = destino;
        this.enCurso = enCurso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(String pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public String getConductorId() {
        return conductorId;
    }

    public void setConductorId(String conductorId) {
        this.conductorId = conductorId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Boolean getEnCurso() {
        return enCurso;
    }

    public void setEnCurso(Boolean enCurso) {
        this.enCurso = enCurso;
    }

    @Override
    public String toString() {
        return "ViajesModel{" +
                "id='" + id + '\'' +
                ", pasajeroId='" + pasajeroId + '\'' +
                ", conductorId='" + conductorId + '\'' +
                ", fecha='" + fecha + '\'' +
                ", partida='" + partida + '\'' +
                ", destino='" + destino + '\'' +
                ", enCurso=" + enCurso +
                '}';
    }
}
