/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioJDBC;

import usuariosbean.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PE-ITHLOPEZ
 */
public class JDBCUsuario {


    public List<Usuario> consulta(String filtroApellido) {
        List<Usuario> lista = null;
        try {
            // Paso 1:
            // Cargar el Driver para la conexion a la bd
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Paso 2:
            // Hacer la conexion a la bd
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/usuario", "root", "admin");
            // Paso 3:
            // Crear la orden (statement)
            Statement orden = conexion.createStatement();
            // Paso 4:
            // Crear el SQL
            String SQL = "select * from usuarios where apellidos like '" + filtroApellido + "%' ;";
            // Paso 5:
            // Ejecutamos la orden
            ResultSet resultado = orden.executeQuery(SQL);
            // Paso 6:
            // Recorrer los resultados de la consulta (ResultSet)           
            lista = new ArrayList<Usuario>();

            // Recorrer
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.nombres = resultado.getString("nombres");
                usuario.apellidos = resultado.getString("apellidos");
                usuario.usuario = resultado.getString("usuario");
                usuario.contrasena = resultado.getString("contrasena");
                usuario.telefono = resultado.getString("telefono");
                usuario.empresa = resultado.getString("empresa");
                usuario.estado = resultado.getString("estado");

                lista.add(usuario);
            }

            // Paso 7:
            // Cerrar la orden y la conexion a la bd
            orden.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra el driver");
        } catch (SQLException e1) {
            System.err.println("Error SQL" + e1.getMessage());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        return lista;
    }

    public void insertar(Usuario usuario) {
        try {
            // Paso 1:
            // Cargar el Driver para la conexion a la bd
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/usuarios", "root", "admin")) {
                Statement orden = conexion.createStatement();
                // Paso 4:
                // Crear el SQL
                String SQL = "insert into usuarios(apellidos,nombres,usuario,contrasena,telefono,empresa,estado) values ('" + usuario.apellidos + "','" + usuario.nombres + "','" + usuario.usuario + "','" + usuario.contrasena + "','" + usuario.telefono + "','" + usuario.empresa + "','" + usuario.estado + "');";
                // Paso 5:
                // Ejecutamos la orden
                orden.executeUpdate(SQL);
                
                // Paso 6:
                // Cerrar la orden y la conexion a la bd
                orden.close();
            }

        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra el driver");
        } catch (SQLException e1) {
            System.err.println("Error SQL" + e1.getMessage());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public void eliminar(String usuario, String contrasena) {
        try {
            // Paso 1:
            // Cargar el Driver para la conexion a la bd
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Paso 2:
            // Hacer la conexion a la bd
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/usuarios", "root", "admin");
            // Paso 3:
            // Crear la orden (statement)
            Statement orden = conexion.createStatement();
            // Paso 4:
            // Crear el SQL
            String SQL = "delete from usuarios where usuario=" + usuario + " and " + "contrasena =" + contrasena;
            // Paso 5:
            // Ejecutamos la orden
            orden.executeUpdate(SQL);

            // Paso 6:
            // Cerrar la orden y la conexion a la bd
            orden.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra el driver");
        } catch (SQLException e1) {
            System.err.println("Error SQL" + e1.getMessage());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public Usuario buscar(String usuario) {
        Usuario user = null;
        try {
            // Paso 1:
            // Cargar el Driver para la conexion a la bd
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Paso 2:
            // Hacer la conexion a la bd
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/usuarios", "root", "admin");
            // Paso 3:
            // Crear la orden (statement)
            Statement orden = conexion.createStatement();
            // Paso 4:
            // Crear el SQL
            String SQL = "select * from usuarios where usuario=" + usuario;
            // Paso 5:
            // Ejecutamos la orden
            ResultSet resultado = orden.executeQuery(SQL);
            // Paso 6:
            // Recorrer los resultados de la consulta (ResultSet)           

            // Recorrer
            if (resultado.next()) {
                user = new Usuario();
                user.nombres = resultado.getString("nombres");
                user.apellidos = resultado.getString("apellidos");                
                user.usuario = resultado.getString("usuario");
                user.contrasena = resultado.getString("contrasena");
                user.telefono = resultado.getString("telefono");
                user.empresa = resultado.getString("empresa");
                user.estado = resultado.getString("estado");
            }

            // Paso 7:
            // Cerrar la orden y la conexion a la bd
            orden.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra el driver");
        } catch (SQLException e1) {
            System.err.println("Error SQL" + e1.getMessage());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        return user;
    }

    public void actualizar(Usuario user) {
        try {
            // Paso 1:
            // Cargar el Driver para la conexion a la bd
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Paso 2:
            // Hacer la conexion a la bd
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/usuarios", "root", "admin");
            // Paso 3:
            // Crear la orden (statement)
            Statement orden = conexion.createStatement();
            // Paso 4:
            // Crear el SQL
            String SQL = "update usuarios set nombres='" + user.nombres + "', apellidos='" + user.apellidos + "', usuario='" + user.usuario + "', contrasena='" + user.contrasena + "', telefono='" + user.telefono + "', empresa='" + user.empresa + "' where id=" + user.usuario;
            // Paso 5:
            // Ejecutamos la orden
            orden.executeUpdate(SQL);

            // Paso 6:
            // Cerrar la orden y la conexion a la bd
            orden.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            System.err.println("No se encuentra el driver");
        } catch (SQLException e1) {
            System.err.println("Error SQL" + e1.getMessage());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

}

