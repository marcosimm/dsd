/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PE-ITHLOPEZ
 */
public class JDBCUsuario {

    public Connection ConectarJDBC() {
        Connection conexion = null;
        try {
            // Paso 1:
            // Cargar el Driver para la conexion a la bd
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Paso 2:
            // Hacer la conexion a la bd
            System.out.println("Connecting to database...");
            //conexion = DriverManager.getConnection("jdbc:mysql://177.91.250.86:3306/Usuarios", "usuario", "admin");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Usuarios", "usuario", "admin");
            // Paso 3:
            // Crear la orden (statement)
            System.out.println("Creating statement...");
            //Statement orden = conexion.createStatement();
            /*                          
            // Paso 4:
             // Crear el SQL
             String SQL = "insert into profesores(apellidos,nombres,direccion,correo,telefono,genero) values ('" + profesor.apellidos + "','" + profesor.nombres + "','" + profesor.direccion + "','" + profesor.correo + "','" + profesor.telefono + "','" + profesor.genero + "');";
             // Paso 5:
             // Ejecutamos la orden
             orden.executeUpdate(SQL);

             // Paso 6:
             // Cerrar la orden y la conexion a la bd
             orden.close();
             conexion.close();
             */

        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra el driver");
        } catch (SQLException e1) {
            System.err.println("Error SQL" + e1.getMessage());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());

        }
        return conexion;
    }

    public void DesconectarJDBC(Connection conexion) {
        try {
            /*          // Paso 1:
             // Cargar el Driver para la conexion a la bd
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             // Paso 2:
             // Hacer la conexion a la bd
             Connection conexion = DriverManager.getConnection(
             "jdbc:mysql://177.91.250.86:3306/Usuarios", "usuario", "admin");
             // Paso 3:
             // Crear la orden (statement)
             Statement orden = conexion.createStatement();
             /* // Paso 4:
             // Crear el SQL
             String SQL = "insert into profesores(apellidos,nombres,direccion,correo,telefono,genero) values ('" + profesor.apellidos + "','" + profesor.nombres + "','" + profesor.direccion + "','" + profesor.correo + "','" + profesor.telefono + "','" + profesor.genero + "');";
             // Paso 5:
             // Ejecutamos la orden
             orden.executeUpdate(SQL);
             */
            // Paso 6:
            // Cerrar la orden y la conexion a la bd
            conexion.close();

        } catch (SQLException e1) {
            System.err.println("Error SQL" + e1.getMessage());
        }
    }
}
