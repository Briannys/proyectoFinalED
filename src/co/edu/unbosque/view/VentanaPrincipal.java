package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelBienvenida panelBienvenida;


    public VentanaPrincipal() {
        setTitle("TVBosque");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(10, 10));
        inicializarComponentes();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarComponentes() {
        panelBienvenida = new PanelBienvenida();
        getContentPane().add(panelBienvenida);
    }

    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }

    public void setPanelBienvenida(PanelBienvenida panelBienvenida) {
        this.panelBienvenida = panelBienvenida;
    }
}
