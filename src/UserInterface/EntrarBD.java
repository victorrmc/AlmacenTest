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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
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
import proyectoalmacentest.CrearBD;
import proyectoalmacentest.Funciones;

/**
 *
 * @author victo
 */
public class EntrarBD extends JPanel implements ActionListener {

    private JLabel j1;

    private JTextField jtf1;
    private JTextField jtf2;
    private JButton b1;
    private JButton b2;
    private JPasswordField jpsw;
    private JPanel panelCentro, panelContenedor, formulario, top, botones;
    private final Dimension texto = new Dimension(100, 15);
    private final JFramePrincipal frame;
    private final LineBorder border = new LineBorder(Color.black);
    private final Border margin = new EmptyBorder(0, 10, 0, 0);

    private String userBD;
    private String passBD;

    public EntrarBD(JFramePrincipal frame) {
        super();
        this.frame = frame;
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
        j1.setText("EntrarBD");
        j1.setForeground(Color.white);
        top.add(j1);

        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/chinatown.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel2 = new JLabel(iconoEscalado2);
        imageLabel2.setVisible(true);
        top.add(imageLabel2);

        jtf1 = new JTextField("Introduce usuario");
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

        formulario.add(botones);

        setBackground(Color.DARK_GRAY);
        return panelCentro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(b1)) {
            String contra = new String(jpsw.getPassword());
            if (jtf1.getText().equals("") || contra.equals("")) {
                JOptionPane.showMessageDialog(null, "Te faltan datos por introducir", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                userBD = jtf1.getText();

                ConexionBD conec = new ConexionBD(userBD, contra);
                Funciones f = new Funciones(conec);
                Usuario u1 = new Usuario(jtf1.getText(), contra);

                if (conec.dbExists()) {
                    Login log = new Login(frame, conec);

                    frame.remove(this);
                    frame.add(log);
                    frame.setVisible(true);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                } else {

                    new CrearBD(userBD, contra);
                    Login log = new Login(frame, conec);

                    frame.remove(this);
                    frame.add(log);
                    frame.setVisible(true);
                    frame.pack();
                    frame.setLocationRelativeTo(null);

                }

            }
        }

    }
}
