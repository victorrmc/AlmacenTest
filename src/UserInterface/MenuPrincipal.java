/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package UserInterface;

import ClasesTablas.Cliente;
import ClasesTablas.RegistroLogin;
import ClasesTablas.Usuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;

/**
 *
 * @author 2damaa
 */
public class MenuPrincipal extends JPanel implements ActionListener {

    private JTabbedPane panelPestanas;
    private JPanel pest1;
    private JPanel pest2;
    private JPanel pest3;
    private JPanel jptop;
    private JPanel jpmedio;
    private JPanel jptop2;
    private JPanel jpmedio2;
    private JPanel jptop3;
    private JPanel jpmedio3;
    private JPanel panelCentro;
    private JPanel panelContenedor;
    private JFramePrincipal frame;
    private JButton[] bc, bp, bf;
    private String entrada;
    private ConexionBD conec;
    private final UserInterface.BordeRedondo border2 = new UserInterface.BordeRedondo(10);
    private final LineBorder border = new LineBorder(Color.black);
    private Usuario userlogged;
    private RegistroLogin regis;
    private JTable TablaClientes;

    private String[] botonesc = {"Buscar Cliente", "Crear Cliente", "Modificar Cliente", "Eliminar Cliente", "Grafico Cliente"},
            botonesp = {"Buscar Producto", "Crear Producto", "Modificar Producto", "Eliminar Producto"},
            botonesf = {"Exportar Factura"};

    private ArrayList<Cliente> listaClientes;

    private String[] nombresColumnasClientes;
    private String[][] datosFilaClientes;

    private String[] nombresColumnasProductos;
    private String[][] datosFilaProductos;

    private String[] nombresColumnasFacturas;
    private String[][] datosFilaFacturas;

    /**
     * @param args the command line arguments
     */
    public MenuPrincipal(JFramePrincipal frame, Usuario userlogged, RegistroLogin regis, ConexionBD conec) {
        super();

        this.frame = frame;
        this.userlogged = userlogged;
        this.conec = conec;
        this.regis = regis;
        conec.ConectarBasedeDatos();

        if (userlogged.getNivelPermisos().equals("nivelAdmin")) {
            add(panelCentroAdmin(), "Center");
        } else if (userlogged.getNivelPermisos().equals("nivelUsuario")) {
            add(panelCentro(), "Center");
        }

    }

    class escuchamenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    public JPanel panelCentro() {

        botonesp = new String[]{"Buscar Producto"};
        botonesf = new String[]{"Exportar Factura"};

        panelContenedor = new JPanel();
        panelCentro = new JPanel();
        panelCentro.setOpaque(false);
        jptop = new JPanel();
        jptop2 = new JPanel();
        jptop3 = new JPanel();
        bc = new JButton[botonesc.length];
        bp = new JButton[botonesp.length];
        bf = new JButton[botonesf.length];

        Crearb(jptop2, botonesp, bp);
        Crearb(jptop3, botonesf, bf);

        setBounds(300, 300, 400, 200);

        panelPestanas = new JTabbedPane(JTabbedPane.TOP);
        panelContenedor.add(panelPestanas);

        jpmedio = new JPanel();

        jptop.setLayout(new GridLayout(1, 5));
        jpmedio.setBackground(Color.DARK_GRAY);
        jptop.setBackground(Color.DARK_GRAY);

        pest2 = new JPanel();
        pest2.setLayout(new BoxLayout(pest2, 1));
        jpmedio2 = new JPanel();
        jpmedio2.setLayout(new CardLayout());
        jpmedio2.setBackground(Color.DARK_GRAY);
        jptop2.setBackground(Color.DARK_GRAY);
        jptop2.setBackground(Color.DARK_GRAY);

        jptop2.setLayout(new GridLayout(1, 5));

        Funciones f = new Funciones(conec);

        nombresColumnasProductos = new String[]{"Id", "Nombre", "Precio Unitario", "Stock"};
        String[][] productosMostrar = f.mostrarProductos(f.consultaCompletaProducto());
        datosFilaProductos = productosMostrar;

        JTable TablaProductos = new JTable(datosFilaProductos, nombresColumnasProductos);
        jpmedio2.add(new JScrollPane(TablaProductos), BorderLayout.CENTER);
        pest2.add(jptop2);

        pest2.add(jpmedio2);

        pest3 = new JPanel();
        pest3.setLayout(new BoxLayout(pest3, 1));

        jpmedio3 = new JPanel();
        jpmedio3.setLayout(new CardLayout());
        jpmedio3.setBackground(Color.DARK_GRAY);
        jptop3.setBackground(Color.DARK_GRAY);
        jptop3.setBackground(Color.DARK_GRAY);

        jptop3.setLayout(new GridLayout(1, 5));

        nombresColumnasFacturas = new String[]{"Id", "IdCliente", "Fecha Compra"};
        String[][] facturasMostrar = f.mostrarFacturas(f.consultaCompletaFactura());
        datosFilaFacturas = facturasMostrar;

        JTable tablaFacturas = new JTable(datosFilaFacturas, nombresColumnasFacturas);

        jpmedio3.add(new JScrollPane(tablaFacturas), BorderLayout.CENTER);

        pest3.add(jptop3);
        pest3.add(jpmedio3);

        panelPestanas.addTab("Productos", null, pest2, null);
        panelPestanas.addTab("Facturas", null, pest3, null);
        JFrame.setDefaultLookAndFeelDecorated(true);

        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/chinatown.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel2 = new JLabel(iconoEscalado2);
        imageLabel2.setBounds(380, -100, 80, 80);
        imageLabel2.setVisible(true);

        panelCentro.setOpaque(false);
        panelContenedor.setOpaque(false);
        setBackground(Color.DARK_GRAY);
        panelCentro.add(panelContenedor);

        setVisible(true);
        return panelCentro;
    }

    public JPanel panelCentroAdmin() {

        panelContenedor = new JPanel();
        panelCentro = new JPanel();
        panelCentro.setOpaque(false);
        jptop = new JPanel();
        jptop2 = new JPanel();
        jptop3 = new JPanel();
        bc = new JButton[botonesc.length];
        bp = new JButton[botonesp.length];
        bf = new JButton[botonesf.length];
        Crearb(jptop, botonesc, bc);
        Crearb(jptop2, botonesp, bp);
        Crearb(jptop3, botonesf, bf);

        setBounds(300, 300, 400, 200);

        panelPestanas = new JTabbedPane(JTabbedPane.TOP);
        panelContenedor.add(panelPestanas);

        pest1 = new JPanel();
        pest1.setLayout(new BoxLayout(pest1, 1));

        jpmedio = new JPanel();
        jpmedio.setLayout(new CardLayout());
        jptop.setLayout(new GridLayout(1, 5));
        jpmedio.setBackground(Color.DARK_GRAY);
        pest1.setBackground(Color.DARK_GRAY);
        jptop.setBackground(Color.DARK_GRAY);

        Funciones f = new Funciones(conec);

        nombresColumnasClientes = new String[]{"Id", "Nombre", "Apellido", "Tlf", "Email", "Sexo"};
        String[][] mostradoClientes = f.mostrarClientes(f.consultaCompletaCliente());
        datosFilaClientes = mostradoClientes;

        TablaClientes = new JTable(datosFilaClientes, nombresColumnasClientes);
        jpmedio.add(new JScrollPane(TablaClientes), BorderLayout.CENTER);
        pest1.add(jptop);
        pest1.add(jpmedio);
        pest2 = new JPanel();
        pest2.setLayout(new BoxLayout(pest2, 1));

        jpmedio2 = new JPanel();
        jpmedio2.setLayout(new CardLayout());
        jpmedio2.setBackground(Color.DARK_GRAY);
        jptop2.setBackground(Color.DARK_GRAY);
        jptop2.setBackground(Color.DARK_GRAY);

        jptop2.setLayout(new GridLayout(1, 5));

        nombresColumnasProductos = new String[]{"Id", "Nombre", "Precio Unitario", "Stock"};
        String[][] productosMostrar = f.mostrarProductos(f.consultaCompletaProducto());
        datosFilaProductos = productosMostrar;

        JTable TablaProductos = new JTable(datosFilaProductos, nombresColumnasProductos);

        jpmedio2.add(new JScrollPane(TablaProductos), BorderLayout.CENTER);
        pest2.add(jptop2);
        pest2.add(jpmedio2);

        pest3 = new JPanel();
        pest3.setLayout(new BoxLayout(pest3, 1));

        jpmedio3 = new JPanel();
        jpmedio3.setLayout(new CardLayout());
        jpmedio3.setBackground(Color.DARK_GRAY);
        jptop3.setBackground(Color.DARK_GRAY);
        jptop3.setBackground(Color.DARK_GRAY);

        jptop3.setLayout(new GridLayout(1, 5));

        nombresColumnasFacturas = new String[]{"Id", "IdCliente", "Fecha Compra"};
        String[][] facturasMostrar = f.mostrarFacturas(f.consultaCompletaFactura());
        datosFilaFacturas = facturasMostrar;

        JTable tablaFacturas = new JTable(datosFilaFacturas, nombresColumnasFacturas);

        jpmedio3.add(new JScrollPane(tablaFacturas), BorderLayout.CENTER);

        pest3.add(jptop3);
        pest3.add(jpmedio3);
        panelPestanas.addTab("Clientes", null, pest1, null);
        panelPestanas.addTab("Productos", null, pest2, null);
        panelPestanas.addTab("Facturas", null, pest3, null);
        JFrame.setDefaultLookAndFeelDecorated(true);

        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/chinatown.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel2 = new JLabel(iconoEscalado2);
        imageLabel2.setBounds(380, -100, 80, 80);
        imageLabel2.setVisible(true);

        panelCentro.setOpaque(false);
        panelContenedor.setOpaque(false);
        setBackground(Color.DARK_GRAY);
        panelCentro.add(panelContenedor);

        setVisible(true);
        return panelCentro;
    }

    public void Crearb(JPanel panel, String[] array, JButton[] b) {
        for (int i = 0; i < array.length; i++) {
            JButton nombre = new JButton("");
            nombre.setText(array[i]);
            nombre.addActionListener(this);
            b[i] = nombre;
            panel.add(b[i]);

            nombre.setOpaque(true);
            nombre.setBackground(Color.DARK_GRAY);
            nombre.setForeground(Color.white);
            nombre.setBorder(border2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Buscar Cliente":
                entrada = "Cliente";
                frame.remove(this);
                frame.add(new Buscar(frame, entrada, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();

                break;
            case "Crear Cliente":
                frame.remove(this);
                frame.add(new ClienteCrear(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;
            case "Modificar Cliente":
                frame.remove(this);
                frame.add(new ClienteEditar(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;
            case "Eliminar Cliente":
                frame.remove(this);
                frame.add(new Eliminar(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;

            case "Grafico Cliente":
                frame.remove(this);
                frame.add(new Grafico(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;

            case "Buscar Producto":
                entrada = "Producto";
                frame.remove(this);
                frame.add(new Buscar(frame, entrada, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;
            case "Crear Producto":
                frame.remove(this);
                frame.add(new ProductoCrear(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;
            case "Modificar Producto":
                frame.remove(this);
                frame.add(new ProductoEditar(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;
            case "Eliminar Producto":
                frame.remove(this);
                frame.add(new Eliminar(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;
            case "Exportar Factura":
                frame.remove(this);
                frame.add(new FacturaExportar(frame, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
                break;

        }
    }

    class BordeRedondo implements Border {

        private int radio;

        BordeRedondo(int radius) {
            this.radio = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radio + 1, this.radio + 1, this.radio + 2, this.radio);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
        }

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/favicon.png"));
        return retValue;
    }
}
