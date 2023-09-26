/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.CardLayout;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import proyectoalmacentest.ConexionBD;
import proyectoalmacentest.CrearBD;

/**
 *
 * @author victo
 */
public class JFramePrincipal extends JFrame implements ActionListener {

    private JMenuBar mb, mb1;
    private JMenu menu1, menu2;
    private JMenuItem mi1, mi2, mi3;
    private JFramePrincipal frame;
    private EntrarBD logDB;

    public JFramePrincipal() {
        initComponents();
    }

    public void initComponents() {
        getIconImage();
        setTitle("Chinatown");
        this.setIconImage(getIconImage());

        setLayout(new CardLayout());
        logDB = new EntrarBD(this);
        add(logDB);

        Dimension pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(pantalla);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //</editor-fold>
        setLocationRelativeTo(null);
       

        
        pack();
    }

    


    @Override
    public void actionPerformed(ActionEvent e) {
       

        

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/favicon.png"));
        return retValue;
    }

    public static void main(String[] args) {
        new JFramePrincipal().setVisible(true);
    }
    
}
