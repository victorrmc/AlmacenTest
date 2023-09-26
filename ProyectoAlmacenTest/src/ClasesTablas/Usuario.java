/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

/**
 *
 * @author X5
 */
public class Usuario {

    private int id;
    private String nombreLogin;
    private String contraLogin;
    private String email;
    private String nivelPermisos;

    public Usuario(String nombreLogin, String contraLogin) {
        this.nombreLogin = nombreLogin;
        this.contraLogin = contraLogin;
    }

    
    
    public Usuario(String nombreLogin, String contraLogin,String email) {
        this.nombreLogin = nombreLogin;
        this.contraLogin = contraLogin;
        this.email = email;
        this.nivelPermisos = "nivelUsuario";
    }

    public Usuario(String nombreLogin, String contraLogin, String email, String nivelPermisos) {
        this.nombreLogin = nombreLogin;
        this.contraLogin = contraLogin;
        this.email = email;
        this.nivelPermisos = nivelPermisos;
    }

    public Usuario(int id, String nombreLogin, String contraLogin, String email, String nivelPermisos) {
        this.id = id;
        this.nombreLogin = nombreLogin;
        this.contraLogin = contraLogin;
        this.email = email;
        this.nivelPermisos = nivelPermisos;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
