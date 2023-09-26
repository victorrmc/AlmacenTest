/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalmacentest;

import ClasesTablas.Cliente;
import ClasesTablas.Factura;
import ClasesTablas.Producto;
import ClasesTablas.Usuario;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class InsertsIniciales {

    ArrayList<Cliente> listadoClientes = new ArrayList();
    ArrayList<Producto> listadoProductos = new ArrayList();
    ArrayList<Factura> listadoFacturas = new ArrayList();

    public InsertsIniciales() {
        listadoClientes.add(new Cliente("Javier", "Marrero", (int) (Math.random() * 999999999 + 000000001),"javiermarreroperez@gmail.com","Hombre"));
        listadoClientes.add(new Cliente("Victor", "Marrero", (int) (Math.random() * 999999999 + 000000001),"VictorMarrero@gmail.com","Hombre"));
        listadoClientes.add(new Cliente("Daniel", "Lugo", (int) (Math.random() * 999999999 + 000000001),"DanielLugo@gmail.com","Hombre"));
        listadoClientes.add(new Cliente("Ana", "Perez", (int) (Math.random() * 999999999 + 000000001),"AnaPerez@gmail.com","Mujer"));
        listadoClientes.add(new Cliente("Francisco", "Santos", (int) (Math.random() * 999999999 + 000000001),"FranciscoSantos@gmail.com","Hombre"));
        listadoClientes.add(new Cliente("Andrea", "Diaz", (int) (Math.random() * 999999999 + 000000001),"AndreaDiaz@gmail.com","Mujer"));
        listadoClientes.add(new Cliente("Manuel", "Dominguez", (int) (Math.random() * 999999999 + 000000001),"ManuelDominguez@gmail.com","Hombre"));
        listadoClientes.add(new Cliente("Leticia", "Gonzalez", (int) (Math.random() * 999999999 + 000000001),"LeticiaGonzalez@gmail.com","Mujer"));
        listadoClientes.add(new Cliente("Armando", "Garcia", (int) (Math.random() * 999999999 + 000000001),"ArmandoGarcia@gmail.com","Hombre"));
        listadoClientes.add(new Cliente("Luisa", "Suarez", (int) (Math.random() * 999999999 + 000000001),"LuisaSuarez@gmail.com","Mujer"));
        
        listadoProductos.add(new Producto("Mechero", new BigDecimal ((Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("Cartera", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("Monedero", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("FiguraBuda", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("CajaMadera", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("BombillaLed", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("Reloj", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("Fregona", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("Esponja",new BigDecimal (  (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        listadoProductos.add(new Producto("Toalla", new BigDecimal ( (Math.random() * 999 + 001)),(int) (Math.random() * 999 + 001)));
        
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));
        listadoFacturas.add(new Factura((int) (Math.random() * 10 + 1),Date.valueOf(LocalDate.now())));

    }

    public ArrayList<Producto> getListadoProductos() {
        return listadoProductos;
    }

    public ArrayList<Factura> getListadoFacturas() {
        return listadoFacturas;
    }

    
    
    public ArrayList<Cliente> getListadoClientes() {
        return listadoClientes;
    }

}
