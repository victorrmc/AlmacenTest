/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import static java.lang.String.valueOf;

/**
 *
 * @author X5
 */
public class Cliente {

    private int id;
    private String nombre;
    private String apellidos;

    private int tlf;
    private String email;
    private String sexo;

    public Cliente(int id) {
        this.id = id;
    }

    
    
    public Cliente(int id, String nombre, String apellidos, int tlf, String email, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tlf = tlf;
        this.sexo = sexo;
    }

    public Cliente(String nombre, String apellidos, int tlf, String email, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tlf = tlf;
        this.sexo = sexo;
    }

 
    public String [] pasarString() {
        String[] list1={valueOf(this.id), this.nombre,  this.apellidos, valueOf(this.tlf) , this.email ,this.sexo};
        
        return  list1;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
