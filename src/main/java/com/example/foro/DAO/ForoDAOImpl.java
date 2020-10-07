package com.example.foro.DAO;

import com.example.foro.entities.Foro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class ForoDAOImpl implements ForoDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //POST - Crear foro
    @Override
    public int nuevoForo(Foro foro) {

        int cant = 0;

        cant = jdbcTemplate.update("insert into foro (id_categoria, id_temas, user_creador, fecha_foro, contenido, titulo, descripcion) values (?,?,?,?,?,?,?)",
        foro.getIdCategoria(),
        foro.getIdTemas(),
        foro.getUserCreador(),
        foro.getFechaForo(),
        foro.getContenido(),
        foro.getTitulo(),
        foro.getDescripcion()
        );
        return cant;
    }

    //GET - Traet lista de foros creados
    @Override
    public List<Foro> obtenerForo(int idCategoria) {
        String sql = "SELECT * FROM FORO WHERE id_categoria = ?";
        List<Foro> foro = jdbcTemplate.query(sql,
                new Object[] { idCategoria },
                BeanPropertyRowMapper.newInstance(Foro.class));
        return foro;
    }

    //DELETE - Borrar foro
    @Override
    public int borrarForo(int id) {

        int del =0;
        String sql = "DELETE FROM FORO WHERE id_foro=?";
        del = jdbcTemplate.update(sql,id);
        return del;
    }

    //ACTUALIZAR o editar FORO
    @Override
    public int updateForo(Foro foro, int id) {
        int retorno = 0;
        String sql = "UPDATE FORO SET contenido = ?, titulo = ?, descripcion = ? where id_foro=?";
        retorno = jdbcTemplate.update(sql, foro.getContenido(), foro.getTitulo(), foro.getDescripcion(), id);
        return retorno;
    }

    @Override
    public Foro getForoByID(int idForo) {
        String sql = "SELECT * FROM FORO WHERE id_foro = ?";
        return (Foro) jdbcTemplate.queryForObject(sql, new Object[]{idForo},(rs, rowNum) ->
                new Foro(
                        rs.getInt ("id_foro"),
                        rs.getInt ("id_categoria"),
                        rs.getInt ("id_temas"),
                        rs.getString ("user_creador"),
                        rs.getDate ("fecha_foro"),
                        rs.getString ("contenido"),
                        rs.getString ("titulo"),
                        rs.getString ("descripcion")
                )
        );
    }
}
