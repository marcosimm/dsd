/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioDAO;

import UsuarioJDBC.JDBCUsuario;
import UsuariosBean.usuarios;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PE-ITHLOPEZ
 */
public class AgregarUsuarioDAO {

    public void AgregarUser(usuarios usuario) throws SQLException {

        JDBCUsuario jdbc = new JDBCUsuario();
        Connection conexion = jdbc.ConectarJDBC();
        Statement orden;
        orden = conexion.createStatement();
        //usuarios usuario = new usuarios();
        String SQL = "insert into usuarios"
                + "(nombres"
                + ",apellidos"
                + ",usuario"
                + ",contrasena"
                + ",telefono"
                + ",empresa"
                + ",estado)"
                + " values ('"
                + "','" + usuario.nombres
                + "','" + usuario.apellidos
                + "','" + usuario.usuario
                + "','" + usuario.contrasena
                + "','" + usuario.telefono
                + "','" + usuario.empresa
                + "','" + usuario.estado
                + "');";
    }

    public void AgregarUser2(String nombres, String apellidos,
            String usuario, String contrasena, String telefono,
            String empresa, String estado) throws SQLException {

        JDBCUsuario jdbc = new JDBCUsuario();
        Connection conexion = jdbc.ConectarJDBC();
        Statement orden;
        orden = conexion.createStatement();
        //usuarios usuario = new usuarios();
        String SQL = "insert into usuarios"
                + "(nombres"
                + ",apellidos"
                + ",usuario"
                + ",contrasena"
                + ",telefono"
                + ",empresa"
                + ",estado)"
                + " values ('"
                + "','" + nombres
                + "','" + apellidos
                + "','" + usuario
                + "','" + contrasena
                + "','" + telefono
                + "','" + empresa
                + "','" + estado
                + "');";
    }
}
