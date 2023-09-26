/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import static java.lang.String.valueOf;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author X5
 */
public class Factura {

    private int id;
    private int idCliente;
    private Date fechaCompra;


    public Factura(int idCliente, Date fechaCompra) {
        this.idCliente = idCliente;
        this.fechaCompra = fechaCompra;
   
    }

    
    
    public Factura(int id, int idCliente, Date fechaCompra) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaCompra = fechaCompra;

    }
    
    public String [] pasarString() {
        String[] list1={valueOf(this.id), valueOf(this.idCliente),  this.fechaCompra.toString()};
        
        return  list1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

 

    

    

}
