/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ClasesTablas.Cliente;
import ClasesTablas.RegistroAcciones;
import ClasesTablas.RegistroLogin;
import UserInterface.JFramePrincipal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Image;

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

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;
import ClasesTablas.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class ResultadoBusquedaCliente extends JPanel implements ActionListener {

    private JLabel j1;
    private JLabel j2;
    private JTextField jtf1;
    private JTextField jtf2;
    private JTextField jtf3;
    private JTextField jtf4;
    private JTextField jtf5;
    private JButton b1, b2, button;
    private ButtonGroup grupo1;
    private JRadioButton rbtn1;
    private JRadioButton rbtn2;
    private JPanel panelCentro;
    private JPanel panelContenedor;
    private JFramePrincipal frame;
    private String entrada;
    private Usuario userlogged;
    private Cliente busc;
    private ConexionBD conec;
    private RegistroLogin regis;

    public ResultadoBusquedaCliente(JFramePrincipal frame, String entrada, Usuario userlogged, RegistroLogin regis, Cliente busc, ConexionBD conec) {
        super();
        this.frame = frame;
        this.entrada = entrada;
        this.userlogged = userlogged;
        this.conec = conec;
        conec.ConectarBasedeDatos();
        this.busc = busc;
        add(panelCentro(), "Center");
    }

    public JPanel panelCentro() {
        panelContenedor = new JPanel();
        panelCentro = new JPanel();
        JPanel formulario = new JPanel();
        JPanel panelbotones = new JPanel();
        JPanel top = new JPanel();
        JPanel panelradiob = new JPanel();

        panelContenedor.add(top);
        panelContenedor.add(formulario);
        panelCentro.add(panelContenedor);
        panelradiob.setOpaque(false);

        panelradiob.setLayout(new FlowLayout());
        panelbotones.setOpaque(false);
        panelCentro.setOpaque(false);
        panelContenedor.setOpaque(false);
        formulario.setOpaque(false);
        top.setOpaque(false);

        top.setLayout(new GridLayout(1, 3));
        formulario.setLayout(new GridLayout(7, 1, 5, 15));
        panelbotones.setLayout(new FlowLayout());
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        setBackground(Color.DARK_GRAY);

        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(iconoEscalado);

        imageLabel.setVisible(true);
        top.add(imageLabel);

        j1 = new JLabel();
        j1.setText("Editar o Eliminar de " + entrada);
        top.add(j1);
        j1.setForeground(Color.white);

        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button = new JButton(iconoEscalado2);
        button.setBackground(Color.DARK_GRAY);
        button.setBorderPainted(false);
        top.add(button);
        button.addActionListener(this);

        LineBorder border = new LineBorder(Color.black);
        Border margin = new EmptyBorder(0, 10, 0, 0);
        jtf1 = new JTextField(String.valueOf(busc.getId()));
        jtf1.setBackground(Color.getHSBColor(200, 200, 200));
        jtf1.setForeground(Color.white);

        jtf1.setBorder(new CompoundBorder(border, margin));
        formulario.add(jtf1);

        j2 = new JLabel();
        j2.setText("Datos a cambiar");
        formulario.add(j2);
        j2.setForeground(Color.white);
        j2.setAlignmentX(CENTER_ALIGNMENT);

        jtf5 = new JTextField(busc.getNombre());
        jtf5.setBackground(Color.getHSBColor(200, 200, 200));
        jtf5.setForeground(Color.white);
        jtf5.setBorder(new CompoundBorder(border, margin));
        formulario.add(jtf5);

        jtf2 = new JTextField(busc.getApellidos());
        formulario.add(jtf2);
        jtf2.setBackground(Color.getHSBColor(200, 200, 200));
        jtf2.setForeground(Color.white);
        jtf2.setBorder(new CompoundBorder(border, margin));

        jtf3 = new JTextField(String.valueOf(busc.getTlf()));
        jtf3.setForeground(Color.white);
        formulario.add(jtf3);
        jtf3.setBackground(Color.getHSBColor(200, 200, 200));

        jtf3.setBorder(new CompoundBorder(border, margin));
        jtf4 = new JTextField(busc.getEmail());
        formulario.add(jtf4);
        jtf4.setBackground(Color.getHSBColor(200, 200, 200));
        jtf4.setForeground(Color.white);

        jtf4.setBorder(new CompoundBorder(border, margin));

        rbtn1 = new JRadioButton("Hombre");
        rbtn1.setBackground(Color.DARK_GRAY);
        rbtn1.setForeground(Color.white);
        rbtn2 = new JRadioButton("Mujer");
        rbtn2.setBackground(Color.DARK_GRAY);
        rbtn2.setForeground(Color.white);
        grupo1 = new ButtonGroup();
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        panelradiob.add(rbtn1);
        panelradiob.add(rbtn2);

        rbtn1.setSelected(true);

        b1 = new JButton("Editar cuenta");
        panelbotones.add(b1);
        b1.setBackground(Color.getHSBColor(200, 200, 100));
        b1.setForeground(Color.white);
        b1.setPreferredSize(new Dimension(180, 30));
        ResultadoBusquedaCliente.BordeRedondo border2 = new ResultadoBusquedaCliente.BordeRedondo(30);
        b1.setBorder(border2);
        b1.setOpaque(false);
        b1.addActionListener(this);

        b2 = new JButton("Eliminar cuenta");
        panelbotones.add(b2);
        b2.setBackground(Color.getHSBColor(200, 200, 100));
        b2.setPreferredSize(new Dimension(180, 30));
        b2.setForeground(Color.white);
        b2.setBorder(border2);
        b2.setOpaque(false);
        b2.addActionListener(this);

        formulario.add(panelradiob);
        panelContenedor.add(panelbotones);

        setVisible(true);
        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button)) {
            frame.remove(this);
            frame.add(new Buscar(frame, entrada, userlogged, regis, conec));
            frame.setVisible(true);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.repaint();
        }
        if (e.getSource().equals(b1)) {

            Funciones f = new Funciones(conec);
            if (rbtn2.isSelected()) {
                Cliente modif = new Cliente(busc.getId(), jtf5.getText(), jtf2.getText(), Integer.valueOf(jtf3.getText()), jtf4.getText(), "Mujer");
                f.modificarCliente(modif);
                f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Edición del cliente con id"+busc.getId()) );
                frame.remove(this);
                frame.add(new Buscar(frame, entrada, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
            } else {
                Cliente modif = new Cliente(busc.getId(), jtf5.getText(), jtf2.getText(), Integer.valueOf(jtf3.getText()), jtf4.getText(), "Hombre");
                f.modificarCliente(modif);
                f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Edición del cliente con id"+busc.getId()) );
                frame.remove(this);
                frame.add(new Buscar(frame, entrada, userlogged, regis, conec));
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.repaint();
            }

        }

        if (e.getSource().equals(b2)) {

            Funciones f = new Funciones(conec);
            f.eliminarPorId(entrada, busc.getId());
            f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Eliminación del cliente con id"+busc.getId()) );
            JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito", "Info", JOptionPane.INFORMATION_MESSAGE);
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
