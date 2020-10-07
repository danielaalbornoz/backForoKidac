package com.example.foro.entities;

public class Regiones {
    private int idRegion;
    private String nombreRegion;

    public Regiones (){

    }

    public Regiones(int idRegion, String nombreRegion) {
        this.idRegion = idRegion;
        this.nombreRegion = nombreRegion;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

}
