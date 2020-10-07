package com.example.foro.controller;

import com.example.foro.DAO.UsuarioDAO;
import com.example.foro.entities.Usuario;
import com.example.foro.services.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping (path="/api")
public class UsuarioController {

    @Autowired
    private CorreoService mailServ;

    @Autowired
    private UsuarioDAO userDAO;

    //registrar
    @PostMapping (path = "/user", consumes = "application/json", produces = "application/json")
    public String registroUsuario(@RequestBody Usuario usuario){

        int cantidad = 0;
        String resp = "";

        cantidad = userDAO.insertarUsuario(usuario);

        if (cantidad != 0){
            mailServ.sendCorreo(usuario);
            resp = "Registro exitoso";
        }else{
            resp = "Ha ocurrido un error";
        }

        return resp;
    }

    //inicio sesion
    @GetMapping (path="/login", produces = "application/json")
    public Usuario loginUsuario (@RequestParam String username, @RequestParam String password) {
        Usuario user;
        user = userDAO.loginUser(username, password);

        if(user == null){
            user = new Usuario(0);
        }
        return user;
    }

    //mostrar usuarios (admin)
    @GetMapping (path = "/user", produces = "application/json")
    public List<Usuario> obtenerListaUsuarios (){ //FORMA DIRECTA DE OBTENER EL DATO
        return userDAO.listaUsuarios();
    }

    //eliminar usuario (admin)
    @DeleteMapping (path = "/user/{id}", produces = "application/json")
    public int eliminarUser (@PathVariable int id){
        int ret = userDAO.borrarUsuario(id);
        return ret;
    }

    //BANNEAR USUARIOS
    @PutMapping (path = "/user/ban/{correo}",produces = "application/json")
    public int banUser (@PathVariable ("correo") String correo){
        int ret = userDAO.bannearUser(correo);
        return ret;
    }

    //ACTUALIZAR DATOS DE USUARIO
    @PutMapping (path = "/user/{id}",consumes = "application/json",produces = "application/json")
    public int editarUsuario (@PathVariable("id") int id,@RequestBody Usuario user){
        int edit = 0;
        edit = userDAO.editarUser(user,id);
        return edit;
    }

    //COMPROBACIÓN DE CORREO
    @GetMapping (path = "/mail/{correo}", produces = "application/json")
    public boolean comprobacionCorreo (@PathVariable String correo){
        boolean existe;
        existe = userDAO.ifExists(correo);
        return existe;
    }

    //GET USUARIOS (perfil)
    @GetMapping (path = "/user/{id}", produces = "application/json")
    public Usuario obtenerUsuario (@PathVariable int id){ //FORMA DIRECTA DE OBTENER EL DATO
        return userDAO.getUsuariosID(id);
    }
}
