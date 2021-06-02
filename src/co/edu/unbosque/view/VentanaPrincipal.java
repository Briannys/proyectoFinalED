package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelBienvenida panelBienvenida;
    private PanelMenu panelMenu;


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

        panelMenu = new PanelMenu();
    }

    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }

    public void setPanelBienvenida(PanelBienvenida panelBienvenida) {
        this.panelBienvenida = panelBienvenida;
    }

    public PanelMenu getPanelMenu() {
        return panelMenu;
    }

    public void setPanelMenu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
    }
}
