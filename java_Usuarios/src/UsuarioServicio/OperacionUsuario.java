/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarioservicio;

import javax.jws.WebService;
import usuariodao.ActualizarUsuario;
import usuariodao.EliminarUsuario;
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

        ActualizarUsuario actualizarUser = new ActualizarUsuario();
        actualizarUser.actualizarUsuario(user);
    }

    public void eliminar(
            String usuario,
            String contrasena
    ) {

        Usuario user = new Usuario();

        user.contrasena = contrasena;
        user.usuario = usuario;

        EliminarUsuario eliminarUser = new EliminarUsuario();
        eliminarUser.eliminarUsuario(user);
    }
}
