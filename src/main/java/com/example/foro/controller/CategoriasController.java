package com.example.foro.controller;

import com.example.foro.DAO.CategoriasDAO;
import com.example.foro.entities.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class CategoriasController {

    @Autowired
    private CategoriasDAO catDAO;

    //LISTAR CATEGORIAS
    @GetMapping (path = "/categ", produces = "application/json")
    public List<Categorias> categoriasLista(){
        List<Categorias> cates = catDAO.getCategorias();
        return cates;
    }
}
