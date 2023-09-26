/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ClasesTablas.Cliente;
import ClasesTablas.Producto;
import ClasesTablas.RegistroAcciones;
import ClasesTablas.RegistroLogin;
import UserInterface.JFramePrincipal;
import UserInterface.Login;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;
import ClasesTablas.Usuario;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author victo
 */
public class Buscar extends JPanel implements ActionListener {

    private JLabel j1;
    private JTextField jtf1;

    private JButton b1, button;
    private JPanel panelCentro;
    private JPanel panelContenedor;
    private JFramePrincipal frame;
    private String entrada;
    private Usuario userlogged;
    private ConexionBD conec;
    private RegistroLogin regis;

    public Buscar(JFramePrincipal frame, String entrada, Usuario userlogged, RegistroLogin regis, ConexionBD conec) {
        super();
        this.conec = conec;

        this.regis = regis;
        this.frame = frame;
        this.entrada = entrada;
        this.userlogged = userlogged;
        add(panelCentro(), "Center");
        conec.ConectarBasedeDatos();
    }

    public JPanel panelCentro() {
        panelContenedor = new JPanel();
        panelCentro = new JPanel();
        JPanel formulario = new JPanel();
        JPanel top = new JPanel();
        panelContenedor.add(top);
        panelContenedor.add(formulario);
        panelCentro.add(panelContenedor);
        panelCentro.setOpaque(false);
        panelContenedor.setOpaque(false);
        formulario.setOpaque(false);
        top.setOpaque(false);

        top.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        formulario.setLayout(new GridLayout(2, 1, 10, 10));
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        setBackground(Color.DARK_GRAY);

        Dimension espacio = new Dimension(100, 30);
        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/chinatown.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(iconoEscalado);
        imageLabel.setBounds(30, 20, 80, 80);
        imageLabel.setVisible(true);
        top.add(imageLabel);

        j1 = new JLabel();
        j1.setText("Buscar " + entrada);
        j1.setPreferredSize(espacio);
        top.add(j1);
        j1.setForeground(Color.white);

        LineBorder border = new LineBorder(Color.black);
        Border margin = new EmptyBorder(0, 10, 0, 0);

        jtf1 = new JTextField("Introduce id a Buscar");
        jtf1.setPreferredSize(new Dimension(200, 30));
        jtf1.setBackground(Color.getHSBColor(200, 200, 200));
        jtf1.setForeground(Color.white);
        formulario.add(jtf1);
        jtf1.setBorder(new CompoundBorder(border, margin));

        b1 = new JButton("Buscar objeto");

        formulario.add(b1);
        b1.setBackground(Color.getHSBColor(200, 200, 100));
        b1.setPreferredSize(new Dimension(200, 40));
        b1.setForeground(Color.white);
        Buscar.BordeRedondo border2 = new Buscar.BordeRedondo(30);
        b1.setBorder(border2);
        b1.setOpaque(false);
        b1.addActionListener(this);
        b1.setAlignmentX(CENTER_ALIGNMENT);

        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button = new JButton(iconoEscalado2);

        button.setBackground(Color.DARK_GRAY);
        button.setBorderPainted(false);
        top.add(button);
        button.addActionListener(this);

        //setBackground(Color.DARK_GRAY);
        setVisible(true);
        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        
        if (e.getSource().equals(button)) {

            frame.remove(this);
            frame.add(new MenuPrincipal(frame, userlogged, regis, conec));
            frame.setVisible(true);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.repaint();
        }
        if (e.getSource().equals(b1)) {
            if (entrada.equals("Cliente")) {

                Funciones f = new Funciones(conec);

                Cliente busc = f.consultaClienteId(new Cliente(Integer.valueOf(jtf1.getText())));

                if (busc == null) {
                    JOptionPane.showMessageDialog(null, "No existe un ciente con el ID introducido, introduce otro y prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Busqueda del cliente con id"+busc.getId()) );
                    frame.remove(this);
                    frame.add(new ResultadoBusquedaCliente(frame, entrada, userlogged, regis, busc, conec));

                    frame.setVisible(true);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.repaint();

                }

            }
            if (entrada.equals("Producto")) {

                Funciones f = new Funciones(conec);

                Producto busc = f.consultaProductoId(new Producto(Integer.valueOf(jtf1.getText())));
                if (busc == null) {
                    JOptionPane.showMessageDialog(null, "No existe un ciente con el ID introducido, introduce otro y prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Busqueda del producto con id"+busc.getId()) );
                    frame.remove(this);

                    frame.add(new ResultadoBusquedaProducto(frame, entrada, userlogged, regis, busc, conec));
                    frame.setVisible(true);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.repaint();
                }

            }

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

}
