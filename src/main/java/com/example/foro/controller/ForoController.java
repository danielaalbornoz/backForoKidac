package com.example.foro.controller;

import com.example.foro.DAO.ForoDAO;
import com.example.foro.entities.Foro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class ForoController {

    @Autowired
    public ForoDAO foroDAO;

    //CREAR FORO
    @PostMapping (path = "/crearForo", consumes = "application/json", produces = "application/json")
    public boolean crearForo(@RequestBody Foro foro){
        int cantidad = 0;

        cantidad = foroDAO.nuevoForo(foro);

        if (cantidad > 0){
            return true;
        }else{
            return false;
        }
    }

    //OBTENER FORO
    @GetMapping (path = "/foro/category/{idCat}", produces = "application/json")
    public List<Foro> listaForos(@PathVariable ("idCat") int idCategoria){
        List<Foro> listForo = foroDAO.obtenerForo(idCategoria);
        return listForo;
    }

    //BORRAR FORO
    @DeleteMapping (path = "/foro/{id}", produces = "application/json")
    public int borrarForo(@PathVariable int id){
        int del = 0;
        del = foroDAO.borrarForo(id);
        return del;
    }

    //ACTUALIZAR FORO
    @PutMapping (path = "/foro/{id}",consumes = "application/json",produces = "application/json") //EL ("id") sirve para identificar / hacer lla relacion entre el nombre del atributo y el path /{id}
    public int actualizarForo (@PathVariable("id") int idForo,@RequestBody Foro foro){
        int update = 0;
        update = foroDAO.updateForo(foro, idForo);
        return update;
    }

    //GET FORO (modal/ventana emergente)
    @GetMapping (path = "/foro/{id}", produces = "application/json")
    public Foro obtenerUsuario (@PathVariable ("id") int idForo){ //FORMA DIRECTA DE OBTENER EL DATO
        return foroDAO.getForoByID(idForo);
    }
}
