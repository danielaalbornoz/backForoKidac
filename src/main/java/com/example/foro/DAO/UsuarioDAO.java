package com.example.foro.DAO;

import com.example.foro.entities.Usuario;

import java.util.List;

public interface UsuarioDAO {

    public int insertarUsuario (Usuario usuario);
    public Usuario loginUser (String username,String password);
    public List<Usuario> listaUsuarios();
    public int borrarUsuario (int correo);
    public int bannearUser (String correo);
    public int editarUser (Usuario user, int id);
    public boolean ifExists (String username);
    public Usuario getUsuariosID (int id);
}
