package com.example.foro.DAO;

import com.example.foro.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //CREAR USUARIO
    @Override
    public int insertarUsuario(Usuario usuario) {

        int cant = 0;

        cant = jdbcTemplate.update("insert into usuario(nombre,apellidoP,apellidoM,genero,fecha,correo,username,psswrd,id_region,id_comuna,admin,estado) values(?,?,?,?,?,?,?,?,?,?,?,?)",
        usuario.getNombre(),
        usuario.getApellidoP(),
        usuario.getApellidoM(),
        usuario.getGenero(),
        usuario.getFecha(),
        usuario.getCorreo(),
        usuario.getUsername(),
        usuario.getPassword(),
        usuario.getRegion(),
        usuario.getComuna(),
        usuario.getAdmin(),
        1
        );
        return cant;
    }

    //login
    @Override
    public Usuario loginUser(String username, String password) {
        Usuario user;

        String sql = "select * from USUARIO where username = ? and psswrd = ? ";
        try{
            user = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, (rs, rowNum) ->
                    new Usuario(
                            rs.getInt ("id"),
                            rs.getString ("nombre"),
                            rs.getString ("apellidoP"),
                            rs.getString ("apellidoM"),
                            rs.getString ("genero"),
                            rs.getDate ("fecha"),
                            rs.getString ("correo"),
                            rs.getString ("username"),
                            rs.getString ("psswrd"),
                            rs.getInt ("id_region"),
                            rs.getInt ("id_comuna"),
                            rs.getBoolean ("admin"),
                            rs.getBoolean ("estado")
                    )
            );
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }

    //admin-getLISTA
    @Override
    public List<Usuario> listaUsuarios() {
        String sql = "SELECT*FROM USUARIO";
        List<Usuario> user = jdbcTemplate.query(sql, (rs,rowNum) ->
          new Usuario(
            rs.getInt ("id"),
            rs.getString ("nombre"),
            rs.getString ("apellidoP"),
            rs.getString ("apellidoM"),
            rs.getString ("genero"),
            rs.getDate ("fecha"),
            rs.getString ("correo"),
            rs.getString ("username"),
            rs.getString ("psswrd"),
            rs.getInt ("id_region"),
            rs.getInt ("id_comuna"),
            rs.getBoolean ("admin"),
            rs.getBoolean ("estado")
               ));
        return user;
    }

    //admin-ELIMINAR
    @Override
    public int borrarUsuario (int id){
        int rest=0;
        String sql = "DELETE FROM USUARIO WHERE id=?";
        rest = jdbcTemplate.update(sql,id);
        return rest;
    }

    //admin-BANNEAR
    @Override
    public int bannearUser(String correo) {
        int rest=0;
        String sql = "UPDATE USUARIO SET estado = 0 where correo=?";
        rest = jdbcTemplate.update(sql, correo);
        return rest;
    }

    //ACTUALIZAR DATOS USUARIO
    @Override
    public int editarUser(Usuario user, int id) {
        int retorno = 0;
        String sql = "UPDATE USUARIO SET nombre=?, apellidoP=?, apellidoM=?, genero=?, fecha=?, username=?, correo=?, psswrd=?, id_region=?, id_comuna=? where id=?";
        retorno = jdbcTemplate.update(sql,
                user.getNombre(),
                user.getApellidoP(),
                user.getApellidoM(),
                user.getGenero(),
                user.getFecha(),
                user.getUsername(),
                user.getCorreo(),
                user.getPassword(),
                user.getRegion(),
                user.getComuna(),
                id);
        return 0;
    }

    @Override
    public boolean ifExists(String correo) {
        String sql = "SELECT * FROM USUARIO WHERE correo = ?";
        int existe = jdbcTemplate.queryForObject(sql, new Object[] {correo}, Integer.class);
        return existe > 0;
    }

    @Override
    public Usuario getUsuariosID(int id) {
        String sql = "SELECT * FROM USUARIO WHERE id = ?";
        return (Usuario) jdbcTemplate.queryForObject(sql, new Object[]{id},(rs,rowNum) ->
                new Usuario(
                        rs.getInt ("id"),
                        rs.getString ("nombre"),
                        rs.getString ("apellidoP"),
                        rs.getString ("apellidoM"),
                        rs.getString ("genero"),
                        rs.getDate ("fecha"),
                        rs.getString ("correo"),
                        rs.getString ("username"),
                        rs.getString ("psswrd"),
                        rs.getInt ("id_region"),
                        rs.getInt ("id_comuna"),
                        rs.getBoolean ("admin"),
                        rs.getBoolean ("estado")
                )
        );
    }
}
