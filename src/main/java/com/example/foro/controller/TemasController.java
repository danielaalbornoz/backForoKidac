package com.example.foro.controller;

import com.example.foro.DAO.TemasDAO;
import com.example.foro.entities.Temas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class TemasController {

    @Autowired
    private TemasDAO temasDAO;

    @PostMapping (path = "/tema", consumes = "application/json", produces = "application/json")
    public boolean crearTema(@RequestBody Temas temas){
        int cantidad = 0;

        cantidad = temasDAO.nuevoTema(temas);

        if (cantidad > 0){
            return true;
        }else{
            return false;
        }
    }

    //OBTENER TEMAS en donde se banea en el ADMINISTRADOR
    @GetMapping (path = "/tema/admin", produces = "application/json")
    public List<Temas> listaTemasAdmin(){
        List<Temas> tema = temasDAO.listaTemasAdmin();
        return tema;
    }

    //OBTENER TEMAS NO banneados
    @GetMapping (path = "/tema/list", produces = "application/json")
    public List<Temas> listarTemas(){
        List<Temas> tema = temasDAO.listaTemas();
        return tema;
    }

    //BANNEAR TEMAS
    @PutMapping (path = "/tema/ban/{id}", produces = "application/json")
    public int banTema(@PathVariable ("id") int id){
        int ban = 0;
        ban = temasDAO.bannearTema(id);
        return ban;
    }

    //eliminar temas (admin)
    @DeleteMapping (path = "/tema/del/{id}", produces = "application/json")
    public int eliminarUser (@PathVariable ("id") int id){
        int ret = temasDAO.eliminarTema(id);
        return ret;
    }
}
