/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalmacentest;

import ClasesTablas.Cliente;
import ClasesTablas.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class CrearBD {

    private Connection conexion;
    private final String nombreBD = "ChineseAlmacen";
    private Statement sentencia;
    private String userBD;
    private String passBD;

    public CrearBD(String userBD, String passBD) {
        this.userBD = userBD;
        this.passBD = passBD;
        crearBase();
    }

    public void crearBase() {

        try {
            final String Controlador = "com.mysql.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:mysql://localhost:3306/";

            conexion = DriverManager.getConnection(url_bd, userBD, passBD);
            sentencia = conexion.createStatement();
            sentencia.execute("CREATE DATABASE " + nombreBD);
            sentencia.close();
            conexion.close();
            crearTablas();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void agregarCons(Statement sentencia, String tabla1, String cons, String idOri, String tabla2, String idDest) {

        try {
            String fk = "alter table " + tabla1 + " add constraint " + cons + " foreign key (" + idOri + ") references " + tabla2 + " (" + idDest + ") ON UPDATE CASCADE ON DELETE CASCADE;";
            sentencia.executeUpdate(fk);
        } catch (SQLException ex) {
            Logger.getLogger(CrearBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void agregarCons2(Statement sentencia, String tabla1, String cons, String idOri, String tabla2, String idDest) {

        try {
            String fk = "alter table " + tabla1 + " add constraint " + cons + " foreign key (" + idOri + ") references " + tabla2 + " (" + idDest + ");";
            sentencia.executeUpdate(fk);
        } catch (SQLException ex) {
            Logger.getLogger(CrearBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    public void crearTablas() {

        try {

            ConexionBD conec = new ConexionBD(userBD, passBD);
            Funciones f = new Funciones(conec);
            sentencia = conec.getConnection().createStatement();
            String t1 = "CREATE TABLE cliente ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "nombre VARCHAR(20),"
                    + "apellidos VARCHAR(50),"
                    + "tlf int,"
                    + "email VARCHAR(50),"
                    + "sexo VARCHAR(6),"
                    + "PRIMARY KEY(id)"
                    + ")";
            sentencia.execute(t1);

            String t2 = "CREATE TABLE producto ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "nombre VARCHAR(20),"
                    + "precioUnitario DECIMAL,"
                    + "stock int,"
                    + "PRIMARY KEY(id)"
                    + ")";
            sentencia.execute(t2);

            String t3 = "CREATE TABLE factura ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "idCliente int NOT NULL,"
                    + "fechaCompra DATE,"
                    + "PRIMARY KEY(id)"
                    + ")";
            sentencia.execute(t3);

            String t4 = "CREATE TABLE registroCompra ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "idFactura int NOT NULL,"
                    + "idProducto int NOT NULL,"
                    + "cantidad int,"
                    + "PRIMARY KEY(id)"
                    + ")";
            sentencia.execute(t4);

            String t5 = "CREATE TABLE usuario ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "nombreLogin VARCHAR(25),"
                    + "contraLogin VARCHAR(25),"
                    + "email VARCHAR(35),"
                    + "nivelPermisos VARCHAR(25),"
                    + "PRIMARY KEY(id)"
                    + ")";
            sentencia.execute(t5);

            String t6 = "CREATE TABLE registroLogin ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "idUsuario int,"
                    + "fechaLogin DATE,"
                    + "PRIMARY KEY(id)"
                    + ")";
            sentencia.execute(t6);

            String t7 = "CREATE TABLE registroAcciones ("
                    + "id int NOT NULL AUTO_INCREMENT,"
                    + "idRegistroLogin int,"
                    + "accionRealizada VARCHAR(50),"
                    + "PRIMARY KEY(id)"
                    + ")";
            sentencia.execute(t7);

            agregarCons(sentencia, "factura", "FK_client_fact", "idCliente", "cliente", "id");
            agregarCons(sentencia, "registroCompra", "FK_fact_registroCompra", "idFactura", "factura", "id");
            agregarCons(sentencia, "registroCompra", "FK_product_registroCompra", "idProducto", "producto", "id");
            agregarCons(sentencia, "registroLogin", "FK_usuaio_regisLogin", "idUsuario", "usuario", "id");
            agregarCons(sentencia, "registroAcciones", "FK_registroAcciones_regisLogin", "idRegistroLogin", "registroLogin", "id");

            f.insertUsuario(new Usuario("Javi", "12345", "javiermarreroperez@gail.com", "nivelAdmin"));
            f.insertUsuario(new Usuario("Victor", "12345", "lmao", "nivelAdmin"));
            f.insertUsuario(new Usuario("123", "123", "lmao", "nivelAdmin"));

            conec.DesconectarBasedeDatos();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
