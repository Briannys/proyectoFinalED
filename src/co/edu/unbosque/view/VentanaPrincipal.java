package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelBienvenida panelBienvenida;
    private PanelAgregarFilm panelAgregarFilm;
    private PanelModificarFilm panelModificarFilm;
    private PanelMenu panelMenu;
    private PanelTabla panelTabla;
    private PanelBuscarDebut panelBuscarDebut;
    private PanelBuscarGenero panelBuscarGenero;


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
        panelAgregarFilm = new PanelAgregarFilm();
        panelTabla = new PanelTabla();
        panelModificarFilm = new PanelModificarFilm();
        panelBuscarDebut = new PanelBuscarDebut();
        panelBuscarGenero = new PanelBuscarGenero();
    }

    public void mensajeAlerta(String title, String message, Icon icon) {

        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public ImageIcon devolverImagenButton(String src, String tipo, int escalax, int escalay) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        return icon;
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

    public PanelAgregarFilm getPanelAgregarFilm() {
        return panelAgregarFilm;
    }

    public void setPanelAgregarFilm(PanelAgregarFilm panelAgregarFilm) {
        this.panelAgregarFilm = panelAgregarFilm;
    }

    public PanelTabla getPanelTabla() {
        return panelTabla;
    }

    public void setPanelTabla(PanelTabla panelTabla) {
        this.panelTabla = panelTabla;
    }

    public PanelModificarFilm getPanelModificarFilm() {
        return panelModificarFilm;
    }

    public void setPanelModificarFilm(PanelModificarFilm panelModificarFilm) {
        this.panelModificarFilm = panelModificarFilm;
    }

    public PanelBuscarDebut getPanelBuscarDebut() {
        return panelBuscarDebut;
    }

    public PanelBuscarGenero getPanelBuscarGenero() {
        return panelBuscarGenero;
    }
}
