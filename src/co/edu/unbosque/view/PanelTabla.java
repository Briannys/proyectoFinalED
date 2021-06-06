package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelTabla extends JPanel {

    private JTable tablaDatos;
    private JButton volver;


    public PanelTabla() {
        setLayout(null);
        setVisible(false);
        setBackground(new Color(157, 205, 90));
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        tablaDatos = new JTable();
        tablaDatos.setBounds(20, 20, 840, 570);
        JScrollPane sp = new JScrollPane(tablaDatos);
        sp.setBounds(20, 20, 840, 570);
        add(sp);

        volver = new JButton("Volver a menu");
        volver = new JButton("Guardar");
        MouseListener ml = new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(new Color(24, 34, 51));
                c.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(Color.white);
                c.setForeground(new Color(24, 34, 51));
            }
        };
        volver.setActionCommand("VOLVER_TABLA");
        volver.addMouseListener(ml);
        volver.setBackground(Color.WHITE);
        volver.setBounds(400, 600, 100, 40);
        add(volver);
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public JButton getVolver() {
        return volver;
    }
}
