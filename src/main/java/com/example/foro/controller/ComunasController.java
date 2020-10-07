package com.example.foro.controller;

import com.example.foro.DAO.ComunasDAO;
import com.example.foro.entities.Comunas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class ComunasController {

    @Autowired
    private ComunasDAO comunasDAO;

    @GetMapping (path = "/comuna/{id}", produces = "application/json")
    public List<Comunas> getComuna(@PathVariable ("id") int idRegion){
        List<Comunas> comunas = comunasDAO.comunas(idRegion);
        return comunas;
    }
}
