package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelTabla extends JPanel {

    private JTable tablaDatos;


    public PanelTabla() {
        setLayout(null);
        setVisible(false);
        setBackground(new Color(157, 205, 90));
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        tablaDatos = new JTable();
        tablaDatos.setBounds(20, 20, 840, 610);
        JScrollPane sp = new JScrollPane(tablaDatos);
        sp.setBounds(20, 20, 840, 610);
        add(sp);
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }
}
