package com.example.foro.entities;

public class Temas {
    private int idTemas;
    private int idForo;
    private String nombreTema;
    private boolean estado;

    public Temas (){

    }

    public Temas(int idTemas, int idForo, String nombreTema, boolean estado) {
        this.idTemas = idTemas;
        this.idForo = idForo;
        this.nombreTema = nombreTema;
        this.estado = estado;
    }

    public int getIdTemas() { return  idTemas; }

    public int getIdForo() {
        return idForo;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public boolean getEstado() {
        return estado;
    }
}
