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
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.Funciones;

/**
 *
 * @author victo
 */
public class Grafico extends JPanel implements ActionListener {

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
private Usuario userlogged;
    private String entrada;
    private RegistroLogin regis;
    private final Dimension texto = new Dimension(100, 30);
    
    public Grafico(JFramePrincipal frame, Usuario userlogged, RegistroLogin regis, ConexionBD conec) {
        super();
        this.userlogged = userlogged;
        this.frame = frame;
        this.conec = conec;
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
        panelCentro.setOpaque(false);
        top.setOpaque(false);
        
        ImageIcon icono2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button = new JButton(iconoEscalado2);
        button.setBackground(Color.DARK_GRAY);
        button.setBorderPainted(false);
        top.add(button);
        button.addActionListener(this);
        
        setBackground(Color.DARK_GRAY);

       Funciones f = new Funciones(conec);
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Hombres", f.consultaHombres() );
        data.setValue("Mujeres", f.consultaMujeres());
        

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Grafico de hombres y mujeres", 
         data, 
         true, 
         true, 
         false);

        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panelContenedor.add(chartPanel);

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
       
    }
}
