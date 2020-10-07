package com.example.foro.DAO;

import com.example.foro.entities.Comunas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComunasDAOImpl implements ComunasDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comunas> comunas(int idRegion) {

        String sql = "SELECT * FROM COMUNA WHERE id_region = ?";
        List<Comunas> comuna = jdbcTemplate.query(sql, new Object[]{idRegion}, (rs,rowNum) ->
                new Comunas(
                        rs.getInt("id_comuna"),
                        rs.getInt("id_region"),
                        rs.getString("nombre")
                ));
        return comuna;
    }



}
