/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ClasesTablas.RegistroLogin;
import ClasesTablas.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;

/**
 *
 * @author victo
 */
public class Login extends JPanel implements ActionListener {

    private JLabel j1;

    private JTextField jtf1;
    private JTextField jtf2;
    private JButton b1;
    private JButton b2;
    private JButton b3;

    private JPasswordField jpsw;
    private JPanel panelCentro, panelContenedor, formulario, top, botones;
    private final Dimension texto = new Dimension(100, 15);
    private final JFramePrincipal frame;
    private final LineBorder border = new LineBorder(Color.black);
    private final Border margin = new EmptyBorder(0, 10, 0, 0);
    private ConexionBD conec;

    public Login(JFramePrincipal frame, ConexionBD conec) {
        super();
        this.frame = frame;
        this.conec = conec;

        add(panelCentro(), "Center");
    }

    public JPanel panelCentro() {

        panelCentro = new JPanel();
        panelContenedor = new JPanel();
        formulario = new JPanel();
        botones = new JPanel();
        top = new JPanel();

        panelContenedor.add(top);
        panelContenedor.add(formulario);
        panelCentro.add(panelContenedor);

        panelCentro.setOpaque(false);
        panelContenedor.setOpaque(false);
        formulario.setOpaque(false);
        botones.setOpaque(false);
        top.setOpaque(false);

        top.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        formulario.setLayout(new GridLayout(3, 1, 10, 10));
        botones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(iconoEscalado);
        imageLabel.setVisible(true);
        top.add(imageLabel);

        j1 = new JLabel();
        j1.setText("Login");
        j1.setForeground(Color.white);
        top.add(j1);

        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/chinatown.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel2 = new JLabel(iconoEscalado2);
        imageLabel2.setVisible(true);
        top.add(imageLabel2);

        jtf1 = new JTextField("Introduce nombre");
        jtf1.setBackground(Color.getHSBColor(200, 200, 200));
        jtf1.setForeground(Color.white);
        jtf1.setBorder(new CompoundBorder(border, margin));
        jtf1.setPreferredSize(texto);
        jtf1.setPreferredSize(texto);
        formulario.add(jtf1);

        jpsw = new JPasswordField();
        jpsw.setToolTipText("Introduce contraseña");
        jpsw.setBorder(new CompoundBorder(border, margin));
        jpsw.setBackground(Color.getHSBColor(200, 200, 200));
        jpsw.setForeground(Color.white);
        jpsw.setPreferredSize(texto);
        formulario.add(jpsw);

        b1 = new JButton("Iniciar Sesion");
        botones.add(b1);
        BordeRedondo border2 = new BordeRedondo(30);
        b1.setBorder(border2);
        b1.setOpaque(false);
        b1.setPreferredSize(new Dimension(150, 30));
        b1.setBackground(Color.getHSBColor(200, 200, 100));

        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2 = new JButton("Crear cuenta");

        b1.setMargin(new Insets(20, 0, 20, 0));
        b2.setOpaque(false);
        b2.setBorder(border2);
        botones.add(b2);
        b2.setBackground(Color.getHSBColor(200, 200, 100));
        b2.setPreferredSize(new Dimension(150, 30));
        b2.setForeground(Color.white);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.addActionListener(this);

        b3 = new JButton("Inserts");
        b3.setOpaque(false);
        b3.setBorder(border2);
        botones.add(b3);
        b3.setBackground(Color.getHSBColor(200, 200, 100));
        b3.setPreferredSize(new Dimension(150, 30));
        b3.setForeground(Color.white);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.addActionListener(this);

        formulario.add(botones);

        setBackground(Color.DARK_GRAY);
        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(b1)) {

            if (!conec.dbExists()) {
                JOptionPane.showMessageDialog(null, "La base de datos aún no ha sido creada", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String contra = new String(jpsw.getPassword());
                if (jtf1.getText().equals("") || contra.equals("")) {
                    JOptionPane.showMessageDialog(null, "Te faltan datos por introducir", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {

                        Funciones f = new Funciones(conec);

                        Usuario u1 = new Usuario(jtf1.getText(), contra);
                        conec.ConectarBasedeDatos();
                        if (f.consultaLogin(u1)) {
                            conec.ConectarBasedeDatos();
                            Usuario userlogged = f.consultaUsuarioNombre(u1);
                            RegistroLogin r1 = new RegistroLogin(userlogged.getId(), Date.valueOf(LocalDate.now()));

                            f.insertRegistroLogin(r1);
                            MenuPrincipal menu = new MenuPrincipal(frame, userlogged, r1, conec);

                            frame.remove(this);
                            frame.add(menu);
                            frame.setVisible(true);
                            frame.pack();
                            frame.setLocationRelativeTo(null);

                        } else {
                            JOptionPane.showMessageDialog(null, "Alguno de los datos introducidos no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        }
        if (e.getSource().equals(b2)) {

            Funciones f = new Funciones(conec);

            if (!conec.dbExists()) {
                JOptionPane.showMessageDialog(null, "La base de datos aún no ha sido creada", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                UsuarioCrear menu2 = new UsuarioCrear(frame, conec);
                frame.remove(this);
                frame.add(menu2);
                frame.setVisible(true);
                frame.pack();
                frame.setLocationRelativeTo(null);

            }

        }
        if (e.getSource().equals(b3)) {
            if (!conec.dbExists()) {
                JOptionPane.showMessageDialog(null, "La base de datos aún no ha sido creada", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                    JOptionPane.showMessageDialog(null, "Los inserts se han realizado correctamente", "Error", JOptionPane.INFORMATION_MESSAGE);
                conec.insertsEjemplo();

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
