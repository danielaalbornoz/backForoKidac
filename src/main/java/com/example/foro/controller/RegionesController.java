package com.example.foro.controller;

import com.example.foro.DAO.RegionesDAO;
import com.example.foro.entities.Regiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class RegionesController {

    @Autowired
    private RegionesDAO regionDAO;

    @GetMapping (path = "/region", produces = "application/json")
    public List<Regiones> getRegion(){
//FORMA CON DEFINICION DE VARIABLE PARA OBTENER EL DATO
        List<Regiones> retReg = regionDAO.region();
        return retReg;
    }

}
