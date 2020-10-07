package com.example.foro.DAO;

import com.example.foro.entities.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentariosDAOImpl implements ComentariosDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //CREAR COMENTARIOS
    @Override
    public int crearComment(Comentarios comentarios) {
        int cant = 0;

        cant = jdbcTemplate.update("insert into COMENTARIOS (id_foro, comentario, user_creador) values (?,?,?)",
                comentarios.getIdForo(),
                comentarios.getComentario(),
                comentarios.getUserCreador()
        );
        return cant;
    }

    //METODO PARA LISTAR LOS COMENTARIOS (GET)
    @Override
    public List<Comentarios> getComentarios(int idForo) {

        String sql = "SELECT * FROM COMENTARIOS where id_foro=?";
        List<Comentarios> comentariosList = jdbcTemplate.query(sql, new Object[]{idForo}, (rs, rowNum) ->
            new Comentarios(
                rs.getInt("id_comment"),
                rs.getInt("id_foro"),
                rs.getString("comentario"),
                rs.getString("user_creador")
                )
            );
        return comentariosList;
    }

    //BORRAR COMENTARIOS
    @Override
    public int borrarComentarios(int id) {
        int ret = 0;
        String sql = "DELETE FROM COMENTARIOS WHERE id_comment=?";
        ret = jdbcTemplate.update(sql, id);
        return ret;
    }


}
