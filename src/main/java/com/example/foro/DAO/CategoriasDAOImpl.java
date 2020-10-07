package com.example.foro.DAO;

import com.example.foro.entities.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CategoriasDAOImpl implements CategoriasDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //get
    @Override
    public List<Categorias> getCategorias() {

        String sql = "SELECT * FROM CATEGORIAS";
        List<Categorias> categoriasList = jdbcTemplate.query(sql, (rs,rowNum) ->
                new Categorias(
                        rs.getString("categoria"),
                        rs.getInt("id_categoria")
                ));
        return categoriasList;
    }
}
