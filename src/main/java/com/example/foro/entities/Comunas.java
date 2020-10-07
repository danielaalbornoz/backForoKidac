package com.example.foro.entities;

public class Comunas {
    private int idComuna;
    private int idRegion;
    private String nombreComuna;

    public Comunas(){
    }

    public Comunas(int idComuna, int idRegion, String nombreComuna) {
        this.idComuna = idComuna;
        this.idRegion = idRegion;
        this.nombreComuna = nombreComuna;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getNombreComuna() {
        return nombreComuna;
    }
}

