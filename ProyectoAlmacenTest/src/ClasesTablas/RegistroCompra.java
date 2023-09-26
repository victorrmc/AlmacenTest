/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author X5
 */
public class RegistroCompra {
   private int id;
   private int idFactura;
   private int idProducto;
   private int cantidad;
   private BigDecimal precioTotalP;

    public RegistroCompra(int id, int idFactura, int idProducto, int cantidad, BigDecimal precioTotalP) {
        this.id = id;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioTotalP = precioTotalP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioTotalP() {
        return precioTotalP;
    }

    public void setPrecioTotalP(BigDecimal precioTotalP) {
        this.precioTotalP = precioTotalP;
    }

   
   
    
}
