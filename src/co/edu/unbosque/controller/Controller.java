package co.edu.unbosque.controller;

import co.edu.unbosque.model.ArbolBinarioDAO;
import co.edu.unbosque.view.VentanaPrincipal;
import sun.font.TextRecord;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements ActionListener {

    private VentanaPrincipal view;
    private ArbolBinarioDAO arbol;

    public Controller() throws ClassNotFoundException {
        view = new VentanaPrincipal();
        asignarOyentes();
        arbol = new ArbolBinarioDAO();

        //dao.agregarPelicula(new Pelicula("Titulo1"));
        // dao.editarPelicula(175461,"Nuevo nombre");


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
        } else if (command.equals("CARGAR_DATASET")) {

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    try {
                        arbol.leerDatosCsv();
                        view.mensajeAlerta("Datos cargados con exito", "Se han cargado satisfactoriametne los datos del csv.", view.devolverImagenButton("chulito", "png", 50, 50));
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
            };
            Date fecha = new Date();
            timer.schedule(task, fecha);
            view.mensajeAlerta("Cargando", "Cargando data set.", view.devolverImagenButton("progress", "gif", 50, 50));
            view.getPanelMenu().activarBotonesMenu();

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
