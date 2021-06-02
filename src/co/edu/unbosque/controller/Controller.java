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
        asignarBotonesMenu();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("COMENZAR")) {
            cambiarPanel(view.getPanelMenu());

        } else if (command.equals("MAS_OPCIONES")) {
            view.getPanelMenu().moreOptions();
        } else if (command.equals("VOLVER")) {
            view.getPanelMenu().volver();
        }

    }

    public void cambiarPanel(Component panel) {
        view.getContentPane().removeAll();
        view.getContentPane().add(panel);
        panel.setVisible(true);
        view.getContentPane().repaint();
    }

    public void asignarBotonesMenu() {
        for (int i = 0; i < 13; i++) {
            view.getPanelMenu().devolverBoton(i).addActionListener(this);
        }
    }
}
