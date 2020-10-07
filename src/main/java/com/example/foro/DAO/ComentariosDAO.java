package com.example.foro.DAO;

import com.example.foro.entities.Comentarios;

import java.util.List;

public interface ComentariosDAO {
    public int crearComment(Comentarios comentarios);
    public int borrarComentarios (int id);
    public List<Comentarios> getComentarios (int idForo);
}
