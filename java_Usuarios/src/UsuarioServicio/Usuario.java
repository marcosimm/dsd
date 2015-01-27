/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioServicio;

import UsuarioDAO.AgregarUsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author PE-ITHLOPEZ
 */
@WebService
public class Usuario {

    public void agregaruser(String nombre, String apellido, String usuario, String contrasena, String telefono, String empresa, String estado) {
        AgregarUsuarioDAO usuDAO = new AgregarUsuarioDAO();
        try {
            usuDAO.AgregarUser2(nombre, apellido, usuario, contrasena, telefono, empresa, estado);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
     @WebService
     public class ListaLibros {

     public List<Libro> listarLibros() {
     LibroDAO dao = new LibroDAO();
     return dao.listarLibros();
     }
     

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/libros"("Henry","Lopez","hlopez","Passw0rd","4294006","MiEmpresa","Act"));
        System.out.println("Servicio ya ha inciado satisfactoriamente...");
    }*/
}


