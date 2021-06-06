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

        // dao.editarPelicula(175461,"Nuevo nombre");


    }

    public void asignarOyentes() {
        view.getPanelBienvenida().getComenzar().addActionListener(this);
        view.getPanelAgregarFilm().getBoton().addActionListener(this);
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
                        view.mensajeAlerta("Datos cargados con exito", "Se han cargado satisfactoriametne los datos del csv."
                                , view.devolverImagenButton("chulito", "png", 50, 50));
                        view.getPanelMenu().activarBotonesMenu();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
            };
            Date fecha = new Date();
            timer.schedule(task, fecha);
            view.mensajeAlerta("Cargando", "Espere un momento mientras se cargan los datos"
                    , view.devolverImagenButton("progress", "gif", 50, 50));

//Hasta aqui cargar datos_______________________________________________________________________________________________________________________________
        } else if (command.equals("AGREGAR_FILM")) {
            cambiarPanel(view.getPanelAgregarFilm());
        } else if (command.equals("GUARDAR_NUEVA_PELICULA")) {
            System.out.println(view.getPanelAgregarFilm().validarTextField());
            if (view.getPanelAgregarFilm().validarTextField() == 9) {
                try {
                    arbol.agregarPelicula(view.getPanelAgregarFilm().capturarDatos());
                    view.mensajeAlerta("Dato guardado.", "Se ha guardado correctamente la nueva pelicula"
                            , view.devolverImagenButton("chulito", "png", 50, 50));
                    cambiarPanel(view.getPanelMenu());
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }
            //guarda film_____________________________________________________________________________________________________________________
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
