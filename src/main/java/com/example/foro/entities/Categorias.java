package com.example.foro.entities;

public class Categorias {
  private int idCategoria;
  private String categoria;

  public Categorias(int idCategoria, String categoria) {

  }

  public Categorias(String categoria, int idCategoria) {
    this.categoria = categoria;
    this.idCategoria = idCategoria;
  }

  public String getCategoria() {
    return categoria;
  }
  public int getIdCategoria(){ return idCategoria; }

}
