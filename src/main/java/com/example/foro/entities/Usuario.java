package com.example.foro.entities;

import java.util.Date;

public class Usuario {

    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String genero;
    private Date fecha;
    private String correo;
    private String username;
    private String password;
    private int region;
    private int comuna;
    private boolean admin;
    private boolean estado;

    public Usuario(){
    }
    public Usuario(int id){
        this.id = id;
    }
    public Usuario(int id, String username, boolean admin){
      this.id= id;
      this.username = username;
      this.admin = admin;
    }
    public Usuario(int id, String nombre, String apellidoP, String apellidoM, String genero, Date fecha, String correo, String username, String password, int region, int comuna, boolean admin, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.genero = genero;
        this.fecha = fecha;
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.region = region;
        this.comuna = comuna;
        this.admin = admin;
        this.estado = estado;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    public boolean getAdmin() { return admin; }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
