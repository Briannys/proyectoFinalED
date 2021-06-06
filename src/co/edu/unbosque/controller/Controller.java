package co.edu.unbosque.controller;

import co.edu.unbosque.model.ArbolBinario;
import co.edu.unbosque.model.Pelicula;
import co.edu.unbosque.persistence.ArbolBinarioDAO;
import co.edu.unbosque.persistence.OperacionArchivo;
import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller implements ActionListener {

    private VentanaPrincipal view;

    public Controller() throws ClassNotFoundException {
        Scanner entrada = new Scanner(System.in);
        view = new VentanaPrincipal();
        asignarOyentes();
        ArbolBinarioDAO dao = new ArbolBinarioDAO();
        dao.leerDatosCsv();
        String aux[][] =dao.filtrarSegunAnio(2005,2017);
        for(int i=0;i<aux.length;i++){
            for(int j = 0;j<10;j++){
                System.out.print(aux[i][j]+", ");
            }
            System.out.println("");
        }
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
