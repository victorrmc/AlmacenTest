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
import javax.swing.JPopupMenu;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;
import ClasesTablas.Usuario;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class ClienteEditar extends JPanel implements ActionListener {

    private JLabel j1;
    private JLabel j2;
    private JTextField jtf1;
    private JTextField jtf2;
    private JTextField jtf3;
    private JTextField jtf4;
    private JTextField jtf5;
    private JButton b1, button;
    private ButtonGroup grupo1;
    private JRadioButton rbtn1;
    private JRadioButton rbtn2;
    private Usuario userlogged;
    private ConexionBD conec;

    private RegistroLogin regis;

    private JPanel panelCentro;
    private JPanel panelContenedor;
    private JFramePrincipal frame;

    public ClienteEditar(JFramePrincipal frame, Usuario userlogged, RegistroLogin regis, ConexionBD conec) {
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
        JPanel panelradiob = new JPanel();

        panelContenedor.add(top);
        panelContenedor.add(formulario);
        panelCentro.add(panelContenedor);
        panelCentro.setOpaque(false);
        panelContenedor.setOpaque(false);
        formulario.setOpaque(false);
        top.setOpaque(false);
        panelradiob.setOpaque(false);

        panelradiob.setLayout(new FlowLayout());
        top.setLayout(new GridLayout(1, 3, 5, 15));
        formulario.setLayout(new GridLayout(8, 1, 5, 15));
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        setBackground(Color.DARK_GRAY);

        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(iconoEscalado);

        imageLabel.setVisible(true);
        top.add(imageLabel);

        j1 = new JLabel();
        j1.setText("Editar de cliente");

        top.add(j1);
        j1.setForeground(Color.white);

        LineBorder border = new LineBorder(Color.black);
        Border margin = new EmptyBorder(0, 10, 0, 0);

        jtf1 = new JTextField("Introduce id del cliente a cambiar");

        jtf1.setBackground(Color.getHSBColor(200, 200, 200));
        jtf1.setForeground(Color.white);

        jtf1.setBorder(new CompoundBorder(border, margin));
        formulario.add(jtf1);

        j2 = new JLabel();
        j2.setText("Datos a cambiar");

        formulario.add(j2);
        j2.setForeground(Color.white);
        jtf5 = new JTextField("Introduce nuevo nombre");

        jtf5.setBackground(Color.getHSBColor(200, 200, 200));
        jtf5.setForeground(Color.white);

        jtf5.setBorder(new CompoundBorder(border, margin));
        formulario.add(jtf5);

        jtf2 = new JTextField("Introduce nuevo apellido");

        formulario.add(jtf2);

        jtf2.setBackground(Color.getHSBColor(200, 200, 200));
        jtf2.setForeground(Color.white);
        jtf2.setBorder(new CompoundBorder(border, margin));
        jtf3 = new JTextField("Introduce nuevo telefono");
        jtf3.setForeground(Color.white);
        LanzaFoco elFoco = new LanzaFoco();

        formulario.add(jtf3);
        jtf3.setBackground(Color.getHSBColor(200, 200, 200));

        jtf3.setBorder(new CompoundBorder(border, margin));
        jtf4 = new JTextField("Introduce nuevo gmail");

        formulario.add(jtf4);
        jtf4.setBackground(Color.getHSBColor(200, 200, 200));
        jtf4.setForeground(Color.white);
        jtf4.addFocusListener(elFoco);

        jtf4.setBorder(new CompoundBorder(border, margin));

        rbtn1 = new JRadioButton("txt1", true);

        rbtn1.setBackground(Color.DARK_GRAY);
        rbtn1.setForeground(Color.white);
        rbtn2 = new JRadioButton("txt2", false);

        rbtn2.setBackground(Color.DARK_GRAY);
        rbtn2.setForeground(Color.white);
        grupo1 = new ButtonGroup();
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        panelradiob.add(rbtn1);
        panelradiob.add(rbtn2);
        rbtn1.setText("Hombre");
        rbtn2.setText("Mujer");
        rbtn1.setSelected(true);

        formulario.add(panelradiob);

        b1 = new JButton("Editar cuenta");

        formulario.add(b1);
        b1.setBackground(Color.getHSBColor(200, 200, 100));
        b1.setForeground(Color.white);
        b1.setPreferredSize(new Dimension(180, 30));
        ClienteEditar.BordeRedondo border2 = new ClienteEditar.BordeRedondo(30);
        b1.setBorder(border2);
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
            frame.add(new MenuPrincipal(frame, userlogged, regis, conec));
            frame.setVisible(true);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.repaint();
        }
        if (e.getSource().equals(b1)) {
            
        }
         Funciones f = new Funciones(conec);

         if (rbtn2.isSelected()) {
            Cliente modif = new Cliente(jtf5.getText(), jtf2.getText(), Integer.valueOf(jtf3.getText()), jtf4.getText(),"Mujer");
            f.modificarCliente(modif);
            f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Modificación de cliente con id"+modif.getId()) );
        }else{
          Cliente modif = new Cliente(jtf5.getText(), jtf2.getText(), Integer.valueOf(jtf3.getText()), jtf4.getText(),"Hombre");
            f.modificarCliente(modif);
            f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Modificación de cliente con id"+modif.getId()) );
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
