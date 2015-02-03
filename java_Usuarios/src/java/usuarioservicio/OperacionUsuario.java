/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarioservicio;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import usuariodao.*;
import usuariosbean.Usuario;

/**
 *
 * @author PE-ITHLOPEZ
 */
@WebService
public class OperacionUsuario {

    public void actualizar(
            String nombres,
            String apellidos,
            String usuario,
            String contrasena,
            String telefono,
            String empresa,
            String estado) {

        Usuario user = new Usuario();

        user.nombres = nombres;
        user.apellidos = apellidos;
        user.usuario = usuario;
        user.contrasena = contrasena;
        user.telefono = telefono;
        user.empresa = empresa;
        user.estado = estado;

        actualizarUsuario actualizarUser = new actualizarUsuario();
        actualizarUser.actualizarUsuario(user);
    }

    public void agregar(
            String nombres,
            String apellidos,
            String usuario,
            String contrasena,
            String telefono,
            String empresa,
            String estado) {

        Usuario user = new Usuario();

        user.nombres = nombres;
        user.apellidos = apellidos;
        user.usuario = usuario;
        user.contrasena = contrasena;
        user.telefono = telefono;
        user.empresa = empresa;
        user.estado = estado;

        agregarUsuario agregarUser = new agregarUsuario();
        agregarUser.agregarUsuario(user);
    }

    public void buscar(String usuario) {
        Usuario user = new Usuario();
        user.usuario = usuario;

        buscarUsuario buscarUser = new buscarUsuario();
        buscarUser.buscarUsuario(user);
    }

    public void eliminar(String usuario, String contrasena) {

        Usuario user = new Usuario();
        user.contrasena = contrasena;
        user.usuario = usuario;

        eliminarUsuario eliminarUser = new eliminarUsuario();
        eliminarUser.eliminarUsuario(user);
    }

    public void listar(String usuario, String contrasena) {

        Usuario user = new Usuario();
        user.contrasena = contrasena;
        user.usuario = usuario;

        listarUsuario listarUser = new listarUsuario();
        listarUser.listarUsuarios(user);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://177.91.250.86:8080/user", new OperacionUsuario());
        System.out.println("Servicio ya ha inciado satisfactoriamente...");
    }
}
