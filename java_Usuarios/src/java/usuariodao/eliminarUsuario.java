/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuariodao;

import usuariojdbc.JDBCUsuario;
import usuariosbean.Usuario;

/**
 *
 * @author PE-ITHLOPEZ
 */
public class eliminarUsuario {

    public void eliminarUsuario(Usuario user) {
                JDBCUsuario jdbc = new JDBCUsuario();
        jdbc.eliminar(user.usuario, user.contrasena);
    }
    
}
