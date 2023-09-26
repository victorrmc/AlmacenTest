/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import ClasesTablas.RegistroAcciones;
import ClasesTablas.RegistroLogin;
import java.awt.Color;
import java.awt.Component;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;
import ClasesTablas.Usuario;
import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class FacturaExportar extends JPanel implements ActionListener {

    private JLabel j1;

    private JButton b1,b2, button;

    private JCheckBox check1, check2, check3;
    private JComboBox combo;
    private Usuario userlogged;
    private ConexionBD conec;
    private RegistroLogin regis;

    private boolean txt = false;
    private boolean doc = false;

    private String content = "Ejempo de Factura "
            + "Producto-------Cantidad--------Precio"
            + "Mechero --------------3----------3.99"
            + "Toalla ---------------5---------25.99"
            + "Taza -----------------1----------1.99"
            + "Camiseta -------------3---------14.90"
            + "Suma total -----------3---------46.87";

    private JPanel panelCentro;
    private JPanel panelContenedor;
    private JFramePrincipal frame;
    private JPanel formulario;
    private JPanel top, panelarea, panelmedio, panelcheck, espaciador, espaciador2;
    ;
    private JTextArea ta;
    private String[] listadofacturas = {"Factura con ID:1", "Factura con ID:2", "Factura con ID:3"};
    private final Dimension texto = new Dimension(100, 15);

    public FacturaExportar(JFramePrincipal frame, Usuario userlogged, RegistroLogin regis, ConexionBD conec) {
        super();
        this.conec = conec;

        this.userlogged = userlogged;
        this.frame = frame;
         conec.ConectarBasedeDatos();
        add(panelCentro(), "Center");
    }

    public JPanel panelCentro() {

        panelContenedor = new JPanel();
        panelCentro = new JPanel();
        formulario = new JPanel();
        top = new JPanel();
        panelarea = new JPanel();
        panelmedio = new JPanel();
        panelcheck = new JPanel();
        panelContenedor.add(top);
        panelContenedor.add(panelmedio);
        panelContenedor.add(formulario);
        panelCentro.add(panelContenedor);
        espaciador = new JPanel();
        espaciador.setPreferredSize(texto);
        espaciador.setOpaque(false);
        espaciador2 = new JPanel();
        espaciador2.setPreferredSize(texto);
        espaciador2.setOpaque(false);

        panelcheck.setOpaque(false);
        panelmedio.setOpaque(false);
        panelCentro.setOpaque(false);
        panelContenedor.setOpaque(false);
        formulario.setOpaque(false);
        top.setOpaque(false);
        panelarea.setOpaque(false);

        panelcheck.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        panelmedio.setLayout(new BoxLayout(panelmedio, BoxLayout.Y_AXIS));
        panelarea.setLayout(new FlowLayout());
        top.setLayout(new GridLayout(1, 3));
        formulario.setLayout(new GridLayout(2, 1, 5, 15));
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(iconoEscalado);

        imageLabel.setVisible(true);
        top.add(imageLabel);

        j1 = new JLabel();
        j1.setText("Creacion de Factura");

        top.add(j1);

        j1.setForeground(Color.white);

        LineBorder border = new LineBorder(Color.black);
        Border margin = new EmptyBorder(0, 10, 0, 0);

        panelmedio.add(espaciador);

        Funciones f = new Funciones(conec);

        ArrayList<String> listadofacturas = f.consultaIdFacturas();

        String[] listadomostrar = new String[listadofacturas.size()];
        for (int i = 0; i < listadomostrar.length; i++) {
            listadomostrar[i] = listadofacturas.get(i);
        }
        genercheckbox(listadomostrar);

        JPanel PanelTexto = new JPanel();
        panelmedio.add(espaciador2);

        ta = new JTextArea(content);
        ta.setPreferredSize(new Dimension(180, 300));
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setPreferredSize(ta.getPreferredSize());
        PanelTexto.add(scroll);
        PanelTexto.setBackground(Color.DARK_GRAY);
        panelarea.add(ta);
        panelmedio.add(panelarea);

        check1 = new JCheckBox("A txt");
        panelcheck.add(check1);
        check1.setBackground(Color.DARK_GRAY);
        check1.setForeground(Color.WHITE);
        check1.addActionListener(this);

        check2 = new JCheckBox("A doc");
        check2.addActionListener(this);

        panelcheck.add(check2);
        check2.setBackground(Color.DARK_GRAY);
        check2.setForeground(Color.WHITE);

        formulario.add(panelcheck);

        b1 = new JButton("Exportar Factura");

        b1.setBackground(Color.getHSBColor(200, 200, 100));
        b1.setForeground(Color.white);
        FacturaExportar.BordeRedondo border2 = new FacturaExportar.BordeRedondo(30);
        b1.setPreferredSize(new Dimension(180, 30));
        b1.setBorder(border2);
        b1.setOpaque(false);
        b1.addActionListener(this);
        formulario.add(b1);
        
        b2 = new JButton("Limpiar");
        b2.setBackground(Color.getHSBColor(200, 200, 100));
        b2.setForeground(Color.white);
        b2.setPreferredSize(new Dimension(180, 30));
        b2.setBorder(border2);
        b2.setOpaque(false);
        b2.addActionListener(this);
        formulario.add(b2);

        JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button = new JButton(iconoEscalado2);

        button.setBackground(Color.DARK_GRAY);
        button.setBorderPainted(false);
        top.add(button);
        button.addActionListener(this);
        setBackground(Color.DARK_GRAY);

        setVisible(true);
        return panelCentro;
    }

    public void genercheckbox(String[] opciones) {
        combo = new JComboBox();
        combo.addActionListener(this);
        for (String opcion : opciones) {

            combo.addItem("Factura de id: " + opcion);
            combo.setBackground(Color.DARK_GRAY);
            combo.setForeground(Color.WHITE);
            panelmedio.add(combo);
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
        if (e.getSource().equals(b2)) {
         check1.isSelected();
        }

        if (e.getSource().equals(b1)) {
            System.out.println(combo.getSelectedItem().toString());
            JFileChooser fc = new JFileChooser();
            Funciones f = new Funciones(conec);
            f.insertRegistroAcciones(new RegistroAcciones(regis.getId(),"Exportación de factura" ));

            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int seleccion = fc.showSaveDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {

                File fichero = fc.getSelectedFile();
                if (check1.isSelected()) {

                    try (FileWriter fw = new FileWriter(fichero + ".txt")) {

                        fw.write(ta.getText());

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (check2.isSelected()) {

                    try (FileWriter fw = new FileWriter(fichero + ".doc")) {

                        fw.write(ta.getText());

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
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
