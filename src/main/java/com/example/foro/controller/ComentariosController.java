package com.example.foro.controller;

import com.example.foro.DAO.ComentariosDAOImpl;
import com.example.foro.entities.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping (path = "/api")
public class ComentariosController {

    @Autowired
    private ComentariosDAOImpl comtDAO;

    //Crear comentario
    @PostMapping (path = "/comt", consumes = "application/json", produces = "application/json")
    public boolean crearComentario(@RequestBody Comentarios comentarios){
        int cant = 0;

        cant = comtDAO.crearComment(comentarios);

        if (cant > 0){
            return true;
        }else{
            return false;
        }
    }

    //OBTENER COMENTARIO
    @GetMapping (path = "/comt/{id}", produces = "application/json")
    public List<Comentarios>listarComentarios(@PathVariable ("id") int idForo){
        List<Comentarios> comtList = comtDAO.getComentarios(idForo);
        return comtList;
    }

    //eliminar comentario
    @DeleteMapping (path = "/comt/{id}", produces = "application/json")
    public int deleteComentarios (@PathVariable int id){
        int retorno = comtDAO.borrarComentarios(id);
        return retorno;
    }
}
