package com.example.foro.DAO;

import com.example.foro.entities.Comunas;

import java.util.List;

public interface ComunasDAO {

    public List<Comunas> comunas(int idRegion);
}
