package com.example.foro.DAO;

import com.example.foro.entities.Regiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionesDAOImpl implements RegionesDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Regiones> region() {

        String sql = "SELECT * FROM REGION";
        List<Regiones> regiones = jdbcTemplate.query(sql, (rs,rowNum) ->
                new Regiones(
                rs.getInt("id_region"),
                rs.getString("nombre")
                ));
        return regiones;
    }
}
