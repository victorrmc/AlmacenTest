/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalmacentest;

import ClasesTablas.Cliente;
import ClasesTablas.Factura;
import ClasesTablas.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author X5
 */
public class ConexionBD {

    private Connection conexion;
    protected ResultSet resultado;
    private Statement sentencia;
    private final String nombreBD = "ChineseAlmacen";
    private String userBD;
    private String passBD;

    public ConexionBD(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("user");
        this.userBD = sc.nextLine();
        System.out.println("pass");
        this.passBD = sc.nextLine();

    }

    public ConexionBD(String userBD,String passBD) {
       
        this.userBD = userBD;

        this.passBD = passBD;
        ConectarBasedeDatos();
    }

    public void ConectarBasedeDatos() {
        try {
         
            final String Controlador = "com.mysql.jdbc.Driver";
            Class.forName(Controlador);

            final String url_bd = "jdbc:mysql://localhost:3306/" + this.nombreBD;

            conexion = DriverManager.getConnection(url_bd, userBD, passBD);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void DesconectarBasedeDatos() {
        try {
            if (conexion != null) {
                System.out.println("Cerrando conexion");
                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public boolean dbExists() {
        boolean exist = false;
        try {

            final String url_bd = "jdbc:mysql://localhost:3306/";

            conexion = DriverManager.getConnection(url_bd, userBD, passBD);

            sentencia = conexion.createStatement();
            String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + this.nombreBD + "'";
            ResultSet rs = sentencia.executeQuery(sql);
            if (rs.next()) {

                exist = true;
            }
        } catch (SQLException ex) {

            exist = false;
        }
        return exist;
    }

    public void insertsEjemplo() {

        try {

            conexion = DriverManager.getConnection(new String("jdbc:mysql://localhost:3306/" + this.nombreBD), userBD, passBD);
            sentencia = conexion.createStatement();
            try {

                InsertsIniciales ins = new InsertsIniciales();
                ArrayList<Cliente> clients = ins.getListadoClientes();
                ArrayList<Producto> products = ins.getListadoProductos();
                ArrayList<Factura> invoices = ins.getListadoFacturas();

                for (Cliente client : clients) {
                    PreparedStatement ps = conexion.prepareStatement("INSERT INTO cliente (nombre,apellidos,tlf,email,sexo) VALUES (?,?,?,?,?)");

                    ps.setString(1, client.getNombre());
                    ps.setString(2, client.getApellidos());
                    ps.setInt(3, client.getTlf());
                    ps.setString(4, client.getEmail());
                    ps.setString(5, client.getSexo());

                    ps.executeUpdate();
                }

                for (Producto product : products) {
                    PreparedStatement ps2 = conexion.prepareStatement("INSERT INTO producto(nombre,precioUnitario,stock) VALUES (?,?,?)");

                    ps2.setString(1, product.getNombre());
                    ps2.setBigDecimal(2, product.getPrecioUnitario());
                    ps2.setInt(3, product.getStock());

                    ps2.executeUpdate();
                }

                for (Factura invoice : invoices) {
                    PreparedStatement ps3 = conexion.prepareStatement("INSERT INTO factura (idCliente,fechaCompra) VALUES (?,?)");

                    ps3.setInt(1, invoice.getIdCliente());
                    ps3.setDate(2, (Date) invoice.getFechaCompra());

                    ps3.executeUpdate();
                }

                conexion.commit();

            } catch (SQLException e) {
                sentencia.close();
                conexion.close();
                if (conexion != null) {
                    try {
                        conexion.rollback();
                        sentencia.close();
                        conexion.close();
                    } catch (SQLException ex) {

                        sentencia.close();
                        conexion.close();
                    }
                }
            }
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public Connection getConnection() {
        
        return conexion;
    }

    public Connection getConexion() {
        return conexion;
    }
}
