/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalmacentest;

import ClasesTablas.Usuario;

/**
 *
 * @author Javier
 */
public class UsuarioLogeado {
    private String nombreLogin;
    private String contraLogin;
    private String email;
    
    private String nivelPermisos;

    

    public UsuarioLogeado(Usuario u1) {
        this.nombreLogin = u1.getNombreLogin();
        this.contraLogin = u1.getContraLogin();
        this.email = u1.getEmail();
        this.nivelPermisos = u1.getNivelPermisos();
    }
    
    public String getNombreLogin() {
        return nombreLogin;
    }

    public void setNombreLogin(String nombreLogin) {
        this.nombreLogin = nombreLogin;
    }

    public String getContraLogin() {
        return contraLogin;
    }

    public void setContraLogin(String contraLogin) {
        this.contraLogin = contraLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivelPermisos() {
        return nivelPermisos;
    }

    public void setNivelPermisos(String nivelPermisos) {
        this.nivelPermisos = nivelPermisos;
    }
    
    
}
