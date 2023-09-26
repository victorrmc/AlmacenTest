/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalmacentest;

import ClasesTablas.Cliente;
import ClasesTablas.Factura;
import ClasesTablas.Producto;
import ClasesTablas.RegistroAcciones;
import ClasesTablas.RegistroCompra;
import ClasesTablas.RegistroLogin;
import ClasesTablas.Usuario;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author X5
 */
public class Funciones {

    private ConexionBD c;

    public Funciones() {
    }

    public Funciones(ConexionBD c) {
        this.c = c;
    }

    private void insertInicial() {
        /*
        try {
            int id = 5;
            String nombre = "Javier";
            String apellidos = "Marrero Pérez";
            int tlf = 689845084;
            
            PreparedStatement ins = this.c.getConnection().prepareStatement("INSERT INTO cliente VALUES (?,?,?,?)");
            
            ins.setInt(1, id);
            ins.setString(2, nombre);
            ins.setString(3, apellidos);
            ins.setInt(4, tlf);
            
            ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }

    public void insertCliente(Cliente c1) {

        try {
            PreparedStatement ins = c.getConnection().prepareStatement("INSERT INTO cliente (nombre,apellidos,tlf,email,sexo) VALUES (?,?,?,?,?)");

            ins.setString(1, c1.getNombre());
            ins.setString(2, c1.getApellidos());
            ins.setInt(3, c1.getTlf());
            ins.setString(4, c1.getEmail());
            ins.setString(5, c1.getSexo());

            ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarCliente(Cliente c1) {

        try {

            PreparedStatement ins = c.getConnection().prepareStatement("UPDATE cliente SET nombre=?, apellidos=?, tlf=?, email=?, sexo=? "
                    + "WHERE id=" + c1.getId());

            ins.setString(1, c1.getNombre());
            ins.setString(2, c1.getApellidos());
            ins.setInt(3, c1.getTlf());
            ins.setString(4, c1.getEmail());
            ins.setString(5, c1.getSexo());

            ins.executeUpdate();

            if (ins.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                ins.close();
            } else {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos",
                        "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);
                ins.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private void insertFactura(Factura f1) throws SQLException {

        PreparedStatement ins = c.getConnection().prepareStatement("INSERT INTO factura (idCliente,fechaCompra) VALUES (?,?)");

        ins.setInt(1, f1.getIdCliente());
        ins.setDate(2, (Date) f1.getFechaCompra());

        ins.executeUpdate();

    }

    public void insertProducto(Producto p1) {

        try {
            PreparedStatement ins = c.getConnection().prepareStatement("INSERT INTO producto(nombre,precioUnitario,stock) VALUES (?,?,?)");

            ins.setString(1, p1.getNombre());
            ins.setBigDecimal(2, p1.getPrecioUnitario());
            ins.setInt(3, p1.getStock());

            ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarProducto(Producto p1) {

        try {

            PreparedStatement ins = c.getConnection().prepareStatement("UPDATE producto SET nombre=?, precioUnitario=?, stock=? "
                    + "WHERE id=" + p1.getId());

            ins.setString(1, p1.getNombre());

            ins.setBigDecimal(2, p1.getPrecioUnitario());
            ins.setInt(3, p1.getStock());

            ins.executeUpdate();

            if (ins.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                ins.close();
            } else {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos",
                        "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);
                ins.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void insertUsuario(Usuario u1) {
        try {

            PreparedStatement ins = c.getConnection().prepareStatement("INSERT INTO usuario (nombreLogin,contraLogin,email,nivelPermisos) VALUES (?,?,?,?)");

            ins.setString(1, u1.getNombreLogin());
            ins.setString(2, u1.getContraLogin());
            ins.setString(3, u1.getEmail());
            ins.setString(4, u1.getNivelPermisos());

            ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarUsuario(Usuario u1) {

        try {

            PreparedStatement ins = c.getConnection().prepareStatement("UPDATE producto SET nombreLogin=?, contraLogin=?, email=?"
                    + "WHERE id=" + u1.getId());

            ins.setString(1, u1.getNombreLogin());

            ins.setString(2, u1.getContraLogin());
            ins.setString(3, u1.getEmail());

            ins.executeUpdate();

            if (ins.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                ins.close();
            } else {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos",
                        "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);
                ins.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void insertRegistroLogin(RegistroLogin rl1) {

        try {
            PreparedStatement ins = c.getConnection().prepareStatement("INSERT INTO registroLogin(idUsuario,fechaLogin) VALUES (?,?)");
            ins.setInt(1, rl1.getIdUsuario());
            ins.setDate(2, rl1.getFechaLogin());

            ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertRegistroAcciones(RegistroAcciones ra1) {

        try {
            PreparedStatement ins = c.getConnection().prepareStatement("INSERT INTO registroAcciones(idRegistroLogin,accionRealizada) VALUES (?,?)");

            ins.setInt(1, ra1.getIdRegistroLogin());
            ins.setString(2, ra1.getAccionRealizada());

            ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertRegistroCompra(RegistroCompra rc1) throws SQLException {

        PreparedStatement ins = c.getConnection().prepareStatement("INSERT INTO usuario VALUES (?,?,?,?,?)");

        ins.setInt(1, rc1.getId());
        ins.setInt(2, rc1.getIdFactura());
        ins.setInt(3, rc1.getIdProducto());
        ins.setInt(4, rc1.getCantidad());
        ins.setBigDecimal(5, rc1.getPrecioTotalP());

        ins.executeUpdate();

    }

    public ArrayList<Cliente> consultaCompletaCliente() {

        ArrayList<Cliente> listadoClientes = new ArrayList();
        try {
            String consult = "SELECT * FROM cliente";
            Statement s = c.getConnection().createStatement();
            ResultSet rs = s.executeQuery(consult);
            while (rs.next()) {
                listadoClientes.add(new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("tlf"), rs.getString("email"), rs.getString("sexo")));
            }
            rs.close();
            return listadoClientes;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoClientes;
    }

    public String[][] mostrarClientes(ArrayList<Cliente> listado) {
        String[] enc = {"Id", "Nombre", "Apellido", "Tlf", "Email", "Sexo"};
        String[][] matriz = new String[listado.size()][enc.length];

        for (int i = 0; i < listado.size(); i++) {
            for (int j = 0; j < enc.length; j++) {
                matriz[i] = listado.get(i).pasarString();
            }
        }
        return matriz;
    }

    public String[][] mostrarProductos(ArrayList<Producto> listado) {
        String[] enc = {"Id", "Nombre", "Precio Unitario", "Stock"};
        String[][] matriz = new String[listado.size()][enc.length];

        for (int i = 0; i < listado.size(); i++) {
            for (int j = 0; j < enc.length; j++) {
                matriz[i] = listado.get(i).pasarString();
            }
        }
        return matriz;
    }

    public String[][] mostrarFacturas(ArrayList<Factura> listado) {
        String[] enc = {"Id", "IdCliente", "Fecha Compra"};
        String[][] matriz = new String[listado.size()][enc.length];

        for (int i = 0; i < listado.size(); i++) {
            for (int j = 0; j < enc.length; j++) {
                matriz[i] = listado.get(i).pasarString();
            }
        }
        return matriz;
    }

    public ArrayList<Producto> consultaCompletaProducto() {
        try {
            ArrayList<Producto> listadoProductos = new ArrayList();
            String consult = "SELECT * FROM producto";
            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);

            while (rs.next()) {

                listadoProductos.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getBigDecimal("precioUnitario"), rs.getInt("stock")));
            }

            rs.close();
            return listadoProductos;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Factura> consultaCompletaFactura() {
        try {
            ArrayList<Factura> listadoFacturas = new ArrayList();
            String consult = "SELECT * FROM factura";
            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);

            while (rs.next()) {

                listadoFacturas.add(new Factura(rs.getInt("id"), rs.getInt("idCliente"), rs.getDate("fechaCompra")));

            }

            rs.close();
            return listadoFacturas;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Cliente consultaClienteId(Cliente c1) {

        try {
            String consult = "SELECT * FROM cliente WHERE id= '" + c1.getId() + "'";

            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);

            while (rs.next()) {
                return new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("tlf"), rs.getString("email"), rs.getString("sexo"));
            }
            rs.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Producto consultaProductoId(Producto p1) {

        try {
            String consult = "SELECT * FROM producto WHERE id= '" + p1.getId() + "'";

            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);
            while (rs.next()) {

                return new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getBigDecimal("precioUnitario"), rs.getInt("stock"));
            }
            rs.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Factura consultaFacturaId(Factura f1) throws SQLException {

        String consult = "SELECT * FROM factura WHERE id= '" + f1.getId() + "'";

        Statement s = c.getConnection().createStatement();

        ResultSet rs = s.executeQuery(consult);
        while (rs.next()) {
            return new Factura(rs.getInt("id"), rs.getInt("idCliente"), rs.getDate("fechaCompra"));
        }
        rs.close();
        return null;
    }
    
    public ArrayList<String> consultaIdFacturas() {
        try {
            ArrayList<String> listadoFacturas = new ArrayList();
            String consult = "SELECT * FROM factura";
            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);

            while (rs.next()) {

                listadoFacturas.add(String.valueOf(rs.getInt("id")));

            }

            rs.close();
            return listadoFacturas;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Cliente consultaClienteNombre(Cliente c1) throws SQLException {

        String consult = "SELECT * FROM cliente WHERE nombre= '" + c1.getNombre() + "'";
        Statement s = c.getConnection().createStatement();

        ResultSet rs = s.executeQuery(consult);
        while (rs.next()) {
            return new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("tlf"), rs.getString("email"), rs.getString("sexo"));
        }
        rs.close();
        return null;
    }

    public void eliminarPorId(String tabla, int id) {

        try {

            String sql = "DELETE FROM " + tabla + " WHERE id = " + id;

            Statement st = c.getConnection().createStatement();
            int valor = st.executeUpdate(sql);

            if (valor > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido eliminados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                st.close();
            } else {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la eliminados de los datos",
                        "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);
                st.close();
            }

            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
        }

    }

    public Usuario consultaUsuarioNombre(Usuario u1)  {

  
        try {
            String consult = "SELECT * FROM usuario WHERE nombreLogin= '" + u1.getNombreLogin() + "'";
            
            Statement s = c.getConnection().createStatement();
            
            ResultSet rs = s.executeQuery(consult);
             while (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nombreLogin"), rs.getString("contraLogin"), rs.getString("email"), rs.getString("nivelPermisos"));
            }
               
            
         
            rs.close();
              
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean consultaLogin(Usuario u1) throws SQLException {

        boolean log = false;
        String consult = "SELECT * FROM usuario WHERE nombreLogin= '" + u1.getNombreLogin() + "'";

        Statement s = c.getConnection().createStatement();

        ResultSet rs = s.executeQuery(consult);
        while (rs.next()) {
            int id2 = rs.getInt("id");
            String contraLogin = rs.getString("contraLogin");
            if (contraLogin.equals(u1.getContraLogin())) {

                log = true;
            } else {

                log = false;
            }
        }

        rs.close();

        return log;
    }

    public Usuario getLog(Usuario u1) {
        try {

            String consult = "SELECT * FROM usuario WHERE nombreLogin= '" + u1.getNombreLogin() + "'";

            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);
            while (rs.next()) {

                Usuario u2 = new Usuario(rs.getString("nombreLogin"), rs.getString("contraLogin"), rs.getString("email"), rs.getString("nivelPermisos"));
                return u2;
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public int consultaLastIdMAsUno(String tabla, String BD) throws SQLException {

        String consult = "SELECT  id\n"
                + "FROM usuario\n"
                + "\n"
                + " ORDER BY id DESC\n"
                + " LIMIT 1";

        Statement s = c.getConnection().createStatement();

        ResultSet rs = s.executeQuery(consult);
        int id;

        if (rs.next()) {
            id = rs.getInt("id");

            rs.close();
            c.DesconectarBasedeDatos();
        } else {
            id = 0;
            rs.close();
            c.DesconectarBasedeDatos();
        }
        return id + 1;

    }

    public boolean checkDigitos(String text, int n) {
        boolean result = false;

        if (text.length() <= n) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean checkPermisos(Usuario u1, String nivelNecesario) {
        boolean result = false;
        switch (u1.getNivelPermisos()) {
            case "NivelUsuario":
                JOptionPane.showMessageDialog(null, "No cuentas con los permisos sufientes.", "Error", JOptionPane.ERROR_MESSAGE);
                result = false;
                break;
            case "NivelAdmin":
                result = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "No cuentas con los permisos sufientes.", "Error", JOptionPane.ERROR_MESSAGE);
                result = false;
        }
        return result;
    }
public int consultaHombres() {
        int nH = 0;
        try {
            String consult = "SELECT * FROM cliente ";

            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);
            while (rs.next()) {
                if (rs.getString("sexo").equals("Hombre")) {
                    nH++;
                }

            }

            rs.close();
            return nH;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nH;

    }

    public int consultaMujeres() {
        int nH = 0;
        try {
            String consult = "SELECT * FROM cliente ";

            Statement s = c.getConnection().createStatement();

            ResultSet rs = s.executeQuery(consult);
            while (rs.next()) {
                if (rs.getString("sexo").equals("Mujer")) {
                    nH++;
                }

            }

            rs.close();
            return nH;
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nH;

    }
    public void ventanaError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);

    }

    /**
     * @param args the command line arguments
     */

}
