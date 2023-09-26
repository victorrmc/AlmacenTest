/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.sql.Date;

/**
 *
 * @author X5
 */
public class RegistroLogin {
     private int id;
    private int idUsuario;

    private Date fechaLogin;

    public RegistroLogin(int idUsuario, Date fechaLogin) {
    
        this.idUsuario = idUsuario;
        this.fechaLogin = fechaLogin;
    }
    
    public RegistroLogin(int id, int idUsuario, Date fechaLogin) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fechaLogin = fechaLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaLogin() {
        return fechaLogin;
    }

    public void setFechaLogin(Date fechaLogin) {
        this.fechaLogin = fechaLogin;
    }
    
}
