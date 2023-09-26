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
public class RegistroAcciones {
    private int id;
    private int idRegistroLogin;
    private String accionRealizada;

    public RegistroAcciones( int idRegistroLogin, String accionRealizada) {
  
        this.idRegistroLogin = idRegistroLogin;
        this.accionRealizada = accionRealizada;
    }
    
    public RegistroAcciones(int id, int idRegistroLogin, String accionRealizada) {
        this.id = id;
        this.idRegistroLogin = idRegistroLogin;
        this.accionRealizada = accionRealizada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRegistroLogin() {
        return idRegistroLogin;
    }

    public void setIdRegistroLogin(int idRegistroLogin) {
        this.idRegistroLogin = idRegistroLogin;
    }

    public String getAccionRealizada() {
        return accionRealizada;
    }

    public void setAccionRealizada(String accionRealizada) {
        this.accionRealizada = accionRealizada;
    }

  
    
}
