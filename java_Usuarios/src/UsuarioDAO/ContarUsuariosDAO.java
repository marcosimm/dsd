/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioDAO;

import UsuarioJDBC.JDBCUsuario;
import UsuariosBean.usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author PE-ITHLOPEZ
 */
public class ContarUsuariosDAO {

    public List<usuarios> ContarUsuarios() throws SQLException {
        List<usuarios> lista = null;
        JDBCUsuario jdbc = new JDBCUsuario();
        Connection conexion = jdbc.ConectarJDBC();
        Statement orden;
        orden = conexion.createStatement();
        String SQL = "select * from usuarios;";
        orden.execute(SQL);
        orden.close();
        jdbc.DesconectarJDBC(conexion);
        return lista;
    }
}