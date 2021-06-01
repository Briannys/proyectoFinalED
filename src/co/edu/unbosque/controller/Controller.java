package co.edu.unbosque.controller;

import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private VentanaPrincipal view;

    public Controller() {
        view = new VentanaPrincipal();
        asignarOyentes();
    }

    public void asignarOyentes() {
        view.getPanelBienvenida().getComenzar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("COMENZAR")) {

        }

    }

    public void cambiarPanel(Component panel) {
        view.getContentPane().removeAll();
        view.getContentPane().add(panel);
        panel.setVisible(true);
        view.getContentPane().repaint();
    }
}
