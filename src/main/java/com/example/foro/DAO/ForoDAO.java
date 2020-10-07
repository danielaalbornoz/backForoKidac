package com.example.foro.DAO;

import com.example.foro.entities.Foro;

import java.util.List;

public interface ForoDAO {

    public int nuevoForo (Foro foro);
    public List<Foro> obtenerForo(int idCategoria);
    public int borrarForo (int id);
    public int updateForo (Foro foro, int id);
    public Foro getForoByID(int idForo);
}
