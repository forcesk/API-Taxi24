package com.ecastillo.taxi24.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="pasajeros")
public class PasajerosModel {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String mail;
    private Boolean enViaje;

    public PasajerosModel(){}

    public PasajerosModel(String nombre, String apellido, String mail, Boolean enViaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.enViaje = enViaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getEnViaje() {
        return enViaje;
    }

    public void setEnViaje(Boolean enViaje) {
        this.enViaje = enViaje;
    }

    @Override
    public String toString() {
        return "PasajerosModel{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", enViaje=" + enViaje +
                '}';
    }
}
