package com.example.foro.DAO;

import com.example.foro.entities.Temas;

import java.util.List;

public interface TemasDAO {

    public int nuevoTema (Temas temas);
    public List<Temas> listaTemasAdmin();
    public List<Temas> listaTemas();
    public int bannearTema(int id);
    public int eliminarTema(int id);
}
