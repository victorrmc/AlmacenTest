/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ClasesTablas.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class UsuarioCrear extends JPanel implements ActionListener {

    private JLabel j1;
    private JTextField jtf1;
    private JTextField jtf4;
    private JPasswordField jpsw;
    private JPasswordField jpsw2;
    private JButton b1, button;
    private JFramePrincipal frame;
    private JPanel panelCentro;
    private JPanel panelContenedor;
    private ConexionBD conec;

    private final Dimension texto = new Dimension(70, 30);

    public UsuarioCrear(JFramePrincipal frame, ConexionBD conec) {
        super();
        this.frame = frame;
        this.conec = conec;
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
        panelCentro.setOpaque(false);
        top.setOpaque(false);
        setBackground(Color.DARK_GRAY);

        top.setLayout(new GridLayout(1, 3));
        formulario.setLayout(new GridLayout(5, 1, 10, 10));

        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        LineBorder border = new LineBorder(Color.black);
        Border margin = new EmptyBorder(0, 10, 0, 0);
        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(iconoEscalado);

        imageLabel.setVisible(true);
        top.add(imageLabel);

        j1 = new JLabel();
        j1.setText("Creacion de usuario");

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

        jtf1 = new JTextField("Introduce nombre");
        jtf1.setBackground(Color.getHSBColor(200, 200, 200));
        jtf1.setForeground(Color.white);
        jtf1.setBorder(new CompoundBorder(border, margin));
        jtf1.setPreferredSize(texto);
        formulario.add(jtf1);

        jpsw = new JPasswordField();
        jpsw.setToolTipText("Introduce contraseña");
        jpsw.setBorder(new CompoundBorder(border, margin));
        jpsw.setBackground(Color.getHSBColor(200, 200, 200));
        jpsw.setForeground(Color.white);
        jpsw.setPreferredSize(texto);
        formulario.add(jpsw);

        jpsw2 = new JPasswordField();
        jpsw2.setToolTipText("Introduce la confirmacion de contraseña");
        jpsw2.setBorder(new CompoundBorder(border, margin));
        jpsw2.setBackground(Color.getHSBColor(200, 200, 200));
        jpsw2.setForeground(Color.white);
        jpsw2.setPreferredSize(texto);
        formulario.add(jpsw2);
        LanzaFoco elFoco = new LanzaFoco();

        jtf4 = new JTextField("Introduce email");
        jtf4.setBackground(Color.getHSBColor(200, 200, 200));
        jtf4.setForeground(Color.white);
        jtf4.setBorder(new CompoundBorder(border, margin));
        jtf4.setPreferredSize(texto);
        formulario.add(jtf4);
        b1 = new JButton("Crear cuenta");
        jtf4.addFocusListener(elFoco);

        b1.setBackground(Color.getHSBColor(200, 200, 100));
        b1.setForeground(Color.white);
        UsuarioCrear.BordeRedondo border2 = new UsuarioCrear.BordeRedondo(30);
        b1.setBorder(border2);
        b1.setOpaque(false);
        b1.addActionListener(this);
        b1.setPreferredSize(texto);
        formulario.add(b1);

        setVisible(true);
        return panelCentro;

    }
     public boolean isEmail (String correo){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if(mat.find()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button)) {
            frame.remove(this);
            frame.add(new Login(frame, conec));
            frame.setVisible(true);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.repaint();
        }
        if (e.getSource().equals(b1)) {
            Funciones f1 = new Funciones();
            if ((jtf1.getText().equals(null) || String.valueOf(jpsw.getPassword()).equals(null) || String.valueOf(jpsw2.getPassword()).equals(null) || jtf4.getText().equals(null))
                    || (jtf1.getText().equals("") || String.valueOf(jpsw.getPassword()).equals("") || String.valueOf(jpsw2.getPassword()).equals("")) || jtf4.getText().equals("")
                    || (jtf1.getText().equals("Introduce nombre") || jtf4.getText().equals("Introduce email"))) {
                JOptionPane.showMessageDialog(null, "Alguno de los campos se encuntra vacío", "Error", JOptionPane.ERROR_MESSAGE);

            } else {

                if (String.valueOf(jpsw.getPassword()).equals(String.valueOf(jpsw2.getPassword()))) {
                    conec.ConectarBasedeDatos();
                    Funciones f = new Funciones(conec);
                    f.insertUsuario(new Usuario(jtf1.getText(), String.valueOf(jpsw.getPassword()), jtf4.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

    }
     class LanzaFoco implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(!isEmail(jtf4.getText())){
            JOptionPane.showMessageDialog(null, "¡Debes validar el email!", "ATENCIÓN ADMINISTRADOR", JOptionPane.WARNING_MESSAGE);
            jtf4.requestFocus();
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
