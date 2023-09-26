/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import static java.lang.String.valueOf;
import java.math.BigDecimal;

/**
 *
 * @author X5
 */
public class Producto {

    private int id;
    private String nombre;
    private BigDecimal precioUnitario;
    private int stock;

    public Producto(int id) {
        this.id = id;
    }

    
    
    public Producto(String nombre, BigDecimal precioUnitario, int stock) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    
    
    public Producto(int id, String nombre, BigDecimal precioUnitario, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public String [] pasarString() {
        String[] list1={valueOf(this.id), this.nombre,  valueOf(this.precioUnitario), valueOf(this.stock)};
        
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

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
