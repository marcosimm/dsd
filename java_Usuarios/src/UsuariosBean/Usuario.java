package usuariosbean;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author PE-ITHLOPEZ
 */
public class Usuario {

    /**
     * @param args the command line arguments
     *
     * public static void main(String[] args) { // TODO code application logic
     * here }
     */
    public String nombres;
    public String apellidos;
    public String usuario;
    public String contrasena;
    public String telefono;
    public String empresa;
    public String estado;

    public Usuario(String nombres, String apellidos, String usuario, String contrasena, String telefono, String empresa, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.empresa = empresa;
        this.estado = estado;
    }

    public Usuario() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
