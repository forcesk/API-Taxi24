package com.ecastillo.taxi24.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="conductores")
public class ConductoresModel {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String mail;
    private Boolean disponible;

    public ConductoresModel(){}

    public ConductoresModel(String nombre, String apellido, String mail, Boolean disponible) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.disponible = disponible;
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

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ConductoresModel{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", mail='" + mail + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
