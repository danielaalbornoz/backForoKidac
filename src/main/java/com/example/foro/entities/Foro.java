package com.example.foro.entities;


import java.util.Date;

public class Foro {
    private int idForo;
    private int idCategoria;
    private int idTemas;
    private String userCreador;
    private Date fechaForo;
    private String contenido;
    private String titulo;
    private String descripcion;

    public Foro (){

    }

    public Foro(int idForo, int idCategoria, int idTemas, String userCreador, Date fechaForo, String contenido, String titulo, String descripcion) {
        this.idForo = idForo;
        this.idCategoria = idCategoria;
        this.idTemas = idTemas;
        this.userCreador = userCreador;
        this.fechaForo = fechaForo;
        this.contenido = contenido;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdTemas() {
        return idTemas;
    }

    public void setIdTemas(int idTemas) {
        this.idTemas = idTemas;
    }

    public String getUserCreador() {
        return userCreador;
    }

    public void setUserCreador(String userCreador) {
        this.userCreador = userCreador;
    }

    public Date getFechaForo() {
        return fechaForo;
    }

    public void setFechaForo(Date fechaForo) {
        this.fechaForo = fechaForo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
