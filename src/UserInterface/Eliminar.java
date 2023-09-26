/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ClasesTablas.RegistroAcciones;
import ClasesTablas.RegistroLogin;
import UserInterface.JFramePrincipal;
import UserInterface.Login;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;
import ClasesTablas.Usuario;

/**
 *
 * @author victo
 */
public class Eliminar extends JPanel implements ActionListener {

    private JLabel j1;
    private JTextField jtf1;
    private JTextField jtf2;
    private JTextField jtf3;
    private JTextField jtf4;
    private JButton b1, button;
    private ButtonGroup grupo1;
    private JRadioButton rbtn1;
    private JRadioButton rbtn2;
    private Usuario userlogged;
    private ConexionBD conec;

    private RegistroLogin regis;
    private final Dimension texto = new Dimension(200, 30);

    private JPanel panelCentro;
    private JPanel panelContenedor;
    private JFramePrincipal frame;

    public Eliminar(JFramePrincipal frame, Usuario userlogged, RegistroLogin regis, ConexionBD conec) {
        super();
        this.conec = conec;
        this.regis = regis;

        this.userlogged = userlogged;
        this.frame = frame;
         conec.ConectarBasedeDatos();
        add(panelCentro(), "Center");
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

        top.setLayout(new FlowLayout(CENTER, 10, 10));
        formulario.setLayout(new GridLayout(3, 1, 5, 15));
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        setBackground(Color.DARK_GRAY);

        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(iconoEscalado);
        imageLabel.setVisible(true);
        top.add(imageLabel);

        j1 = new JLabel();
        j1.setText("Eliminar Cliente, Usuario y Factura");
        j1.setPreferredSize(texto);
        top.add(j1);
        j1.setForeground(Color.white);

        LineBorder border = new LineBorder(Color.black);
        Border margin = new EmptyBorder(0, 10, 0, 0);

        jtf1 = new JTextField("Introduce tipo");

        jtf1.setBackground(Color.getHSBColor(200, 200, 200));
        jtf1.setForeground(Color.white);
        formulario.add(jtf1);
        jtf1.setBorder(new CompoundBorder(border, margin));
        
        jtf2 = new JTextField("Introduce id a eliminar");

        jtf2.setBackground(Color.getHSBColor(200, 200, 200));
        jtf2.setForeground(Color.white);
        formulario.add(jtf2);
        jtf2.setBorder(new CompoundBorder(border, margin));


        b1 = new JButton("Eliminar objeto");

        formulario.add(b1);
        b1.setBackground(Color.getHSBColor(200, 200, 100));
        b1.setForeground(Color.white);
        Eliminar.BordeRedondo border2 = new Eliminar.BordeRedondo(30);
        b1.setBorder(border2);
        b1.setPreferredSize(new Dimension(180, 30));
        b1.setOpaque(false);
        b1.addActionListener(this);

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
            Funciones f = new Funciones(conec);
            f.eliminarPorId(jtf1.getText(), Integer.valueOf(jtf2.getText()));
            f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Eliminación de "+jtf1.getText()+" con id"+jtf2.getText()) );
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
