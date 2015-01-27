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
public class ModificarUsuarioDAO {

    public void ModificarUser() throws SQLException  {

        JDBCUsuario jdbc = new JDBCUsuario();
        Connection conexion = jdbc.ConectarJDBC();
        Statement orden;
        orden = conexion.createStatement();
        usuarios usuarios = new usuarios();
        String SQL = "update usuarios set "
                + "nombres='" + usuarios.nombres
                + "', apellidos='" + usuarios.apellidos
                + "', direccion='" + usuarios.usuario
                + "', correo='" + usuarios.contrasena
                + "', telefono='" + usuarios.telefono
                + "', dni='" + usuarios.empresa
                + "', telefono='" + usuarios.estado
                + "' where usuario=" + usuarios.usuario;
        orden.execute(SQL);
        orden.close();
        jdbc.DesconectarJDBC(conexion);
    }
}
