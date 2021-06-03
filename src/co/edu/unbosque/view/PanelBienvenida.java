package co.edu.unbosque.view;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;

public class PanelBienvenida extends JavaPanel {
    private JLabel l1;
    private JButton comenzar;

    public PanelBienvenida() {
        setLayout(null);
        setVisible(true);
        setBackground(Color.green);
        inicializarComponentes();
    }

    private void inicializarComponentes() {


        comenzar = new JButton(devolverImagenButton("comenzar", "png", 300, 300));
        comenzar.setRolloverIcon(devolverImagenButton("comenzar1", "png", 300, 300));
        comenzar.setBackground(Color.WHITE);
        comenzar.setBorder(null);
        comenzar.setActionCommand("COMENZAR");
        comenzar.setBounds(335, 450, 240, 100);
        add(comenzar);

        l1 = new JLabel();
        devolverImagenLabel("Bienvenido", "gif", 900, 700, l1);
        l1.setBounds(0, 0, 900, 700);
        add(l1);

    }


    public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        b.setIcon(icon);
    }

    public ImageIcon devolverImagenButton(String src, String tipo, int escalax, int escalay) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        return icon;
    }

    public JLabel getL1() {
        return l1;
    }

    public void setL1(JLabel l1) {
        this.l1 = l1;
    }

    public JButton getComenzar() {
        return comenzar;
    }

    public void setComenzar(JButton comenzar) {
        this.comenzar = comenzar;
    }
}
