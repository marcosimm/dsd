/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuariodao;

import UsuarioJDBC.JDBCUsuario;
import usuariosbean.Usuario;

/**
 *
 * @author PE-ITHLOPEZ
 */
public class ActualizarUsuario {

    public void actualizarUsuario(Usuario user) {
        JDBCUsuario jdbc = new JDBCUsuario();
        jdbc.actualizar(user);
    }
}
