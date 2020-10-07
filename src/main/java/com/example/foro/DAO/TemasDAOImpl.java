package com.example.foro.DAO;

import com.example.foro.entities.Temas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemasDAOImpl implements TemasDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int nuevoTema(Temas temas) {
        int cant =0;

        cant = jdbcTemplate.update("INSERT INTO TEMAS (id_foro, nombre_tema, estado) VALUES (?,?,?)",
                temas.getIdForo(),
                temas.getNombreTema(),
                1
        );
        return cant;
    }

    //get temas en donde se banea en el ADMINISTRADOR
    @Override
    public List<Temas> listaTemasAdmin() {

        String sql = "SELECT * FROM TEMAS"; //where estado = 1
        List<Temas> listaTemas = jdbcTemplate.query(sql, (rs,rowNum) ->
                new Temas(
                        rs.getInt("id_temas"),
                        rs.getInt("id_foro"),
                        rs.getString("nombre_tema"),
                        rs.getBoolean("estado")
                ));
        return listaTemas;
    }

    //get temas NO banneados
    @Override
    public List<Temas> listaTemas() {

        String sql = "SELECT * FROM TEMAS where estado = 1";
        List<Temas> listaTemas = jdbcTemplate.query(sql, (rs,rowNum) ->
                new Temas(
                        rs.getInt("id_temas"),
                        rs.getInt("id_foro"),
                        rs.getString("nombre_tema"),
                        rs.getBoolean("estado")
                ));
        return listaTemas;
    }

    //admin- BANNEAR TEMA
    @Override
    public int bannearTema(int id) {
        int retorno = 0;
        String sql = "UPDATE TEMAS SET estado = 0 where id_temas=?";
        retorno = jdbcTemplate.update(sql, id);
        return retorno;
    }

    //ELIMINAR TEMAS
    @Override
    public int eliminarTema(int id) {
        int rest=0;
        String sql = "DELETE FROM TEMAS WHERE id_temas=?";
        rest = jdbcTemplate.update(sql,id);
        return rest;
    }
}
