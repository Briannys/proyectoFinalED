package co.edu.unbosque.controller;

import co.edu.unbosque.model.ArbolBinarioDAO;
import co.edu.unbosque.model.persistence.Pelicula;
import co.edu.unbosque.view.VentanaPrincipal;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements ActionListener {

    private VentanaPrincipal view;
    private ArbolBinarioDAO arbol;

    public Controller() throws ClassNotFoundException {

        view = new VentanaPrincipal();
        arbol = new ArbolBinarioDAO();
        asignarOyentes();
       /* arbol.leerDatosCsv();
        String aux[][] = arbol.filtrarSegunAnio(2005, 2017);
        arbol.leerDatosCsv();
        //arbol.filtarValorMasCostosoDadoGenero("Horror");
        String aux[][] = arbol.filtrarDadoVersion("LBX, 16:9");

        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(aux[i][j] + ", ");
            }

        }*/

    }

    public void asignarOyentes() {
        view.getPanelBienvenida().getComenzar().addActionListener(this);
        view.getPanelAgregarFilm().getBoton().addActionListener(this);
        view.getPanelTabla().getVolver().addActionListener(this);
        view.getPanelModificarFilm().getGuardar_modifi().addActionListener(this);
        asignarBotonesMenu();
        asignarBotonesFiltro();

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

        } else if (command.equals("VER_FLIMS")) {
            cambiarPanel(view.getPanelTabla());
            ArrayList<Pelicula> films = new ArrayList<Pelicula>();

            String[] header = {"Titulo", "Estudio", "Estado", "Versiones", "Precio", "Casificacion", "Anio", "Genero", "Publicacion", "id"};
            for (int i = 0; i < arbol.getArbolBinario().length; i++) {
                ArrayList<Pelicula> temp = new ArrayList<Pelicula>();
                films.addAll(arbol.getArbolBinario()[i].recorerPreOrden(arbol.getArbolBinario()[i].getRaiz(), temp));
            }
            String[][] matriz = new String[films.size()][header.length];
            for (int i = 0; i < films.size(); i++) {
                matriz[i][0] = films.get(i).getTitulo();
                matriz[i][1] = films.get(i).getEstudio();
                matriz[i][2] = films.get(i).getEstado();
                matriz[i][3] = films.get(i).getVersion();
                matriz[i][4] = String.valueOf(films.get(i).getPrecio());
                matriz[i][5] = films.get(i).getClasificacion();
                matriz[i][6] = films.get(i).getAnio();
                matriz[i][7] = films.get(i).getGenero();
                matriz[i][8] = films.get(i).getFechaPublicacion();
                matriz[i][9] = String.valueOf(films.get(i).getId());
            }
            DefaultTableModel model = new DefaultTableModel(matriz, header);
            view.getPanelTabla().getTablaDatos().setModel(model);
            view.repaint();
//hasta aqui mostrar trabla______________________________________________________________________________
        } else if (command.equals("EDITAR_FILM")) {
            cambiarPanel(view.getPanelModificarFilm());

        } else if (command.equals("GUARDAR_EDITAR_PELICULA")) {
            System.out.println();
            if (view.getPanelModificarFilm().validarTextField() == 10) {
                Pelicula temp = view.getPanelModificarFilm().capturarDatos();
                try {
                    arbol.editarPelicula(temp.getId(), temp);
                    view.mensajeAlerta("Dato guardado.", "Se ha modificado correctamente la nueva pelicula"
                            , view.devolverImagenButton("chulito", "png", 50, 50));
                    cambiarPanel(view.getPanelMenu());
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }
        } else if (command.equals("BUSCAR_DEBUT")) {
            cambiarPanel(view.getPanelBuscarDebut());

        } else if (command.equals("BUSQUEDA_AÑO")) {
            if (view.getPanelBuscarDebut().verficarDatos()) {
                Integer[] filtro = view.getPanelBuscarDebut().capturarAños();
                String[][] matriz = arbol.filtrarSegunfechaPublicacion(filtro[0], filtro[1]);
                String[] header = {"Titulo", "Estudio", "Estado", "Versiones", "Precio", "Casificacion", "Anio", "Genero", "Publicacion", "id"};
                DefaultTableModel model = new DefaultTableModel(matriz, header);
                view.getPanelBuscarDebut().getTable().setModel(model);
                view.getPanelBuscarDebut().verTabla();
            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }

        } else if (command.equals("VOlVER_AÑO")) {
            cambiarPanel(view.getPanelMenu());

            //hasta aqui bsuqeuda por año_______________________________________________________________________

        } else if (command.equals("BUSCAR_GENEROS")) {
            cambiarPanel(view.getPanelBuscarGenero());

        } else if (command.equals("BUSQUEDA_GEN")) {
            if (view.getPanelBuscarGenero().verficarDatos()) {
                String[][] matriz = arbol.filtrarSegunGenero(view.getPanelBuscarGenero().capturarGenero());
                String[] header = {"Titulo", "Estudio", "Estado", "Versiones", "Precio", "Casificacion", "Anio", "Genero", "Publicacion", "id"};
                view.getPanelBuscarGenero().verTabla(matriz, header);

            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }

        } else if (command.equals("BUSCAR_TITULO")) {
            cambiarPanel(view.getPanelBuscarTitulo());
        } else if (command.equals("BUSQUEDA_TIT")) {
            if (view.getPanelBuscarTitulo().verficarDatos()) {
                String[][] matriz = arbol.filtrarSeguntitulo(view.getPanelBuscarTitulo().capturarTitle());
                String[] header = {"Titulo", "Estudio", "Estado", "Versiones", "Precio", "Casificacion", "Anio", "Genero", "Publicacion", "id"};
                view.getPanelBuscarTitulo().verTabla(matriz, header);
            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }
        } else if (command.equals("ELIMINAR_FILM")) {
            cambiarPanel(view.getPanelEliminarFilm());

        } else if (command.equals("ELIMINAR")) {
            if (view.getPanelEliminarFilm().verficarDatos()) {
                arbol.eliminarPelicula(view.getPanelEliminarFilm().capturarId());
                view.mensajeAlerta("Dato Eliminado.", "Se ha eliminado correctamente la pelicula"
                        , view.devolverImagenButton("delete", "png", 50, 50));
                cambiarPanel(view.getPanelMenu());
            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }
        } else if (command.equals("MAS_COSTO")) {
            cambiarPanel(view.getPanelBuscarCostoso());

        } else if (command.equals("BUSQUEDA_COST")) {
            if (view.getPanelBuscarCostoso().verficarDatos()) {
                String[][] matriz = arbol.filtarValorMasCostosoDadoGenero(view.getPanelBuscarCostoso().capturarGenero());
                String[] header = {"Titulo", "Estudio", "Estado", "Versiones", "Precio", "Casificacion", "Anio", "Genero", "Publicacion", "id"};
                view.getPanelBuscarCostoso().verTabla(matriz, header);
            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }
        } else if (command.equals("BUSCAR_CLASIFICACIONES")) {
            cambiarPanel(view.getPanelBuscarClasificaciones());

        } else if (command.equals("BUSQUEDA_CLAS")) {
            if (view.getPanelBuscarClasificaciones().verficarDatos()) {
                String[][] matriz = arbol.filtrarDadoClasificacion(view.getPanelBuscarClasificaciones().capturarClasificacion());
                String[] header = {"Titulo", "Estudio", "Estado", "Versiones", "Precio", "Casificacion", "Anio", "Genero", "Publicacion", "id"};
                view.getPanelBuscarClasificaciones().verTabla(matriz, header);
            } else {
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }
        } else if (command.equals("BUSCAR_VERSIONES")) {
            cambiarPanel(view.getPanelBuscarVersiones());

        } else if (command.equals("BUSQUEDA_VER")) {
            if (view.getPanelBuscarVersiones().verficarDatos()) {
                String[][] matriz = arbol.filtrarDadoVersion(view.getPanelBuscarVersiones().capturarVersion());
                String[] header = {"Titulo", "Estudio", "Estado", "Versiones", "Precio", "Casificacion", "Anio", "Genero", "Publicacion", "id"};
                view.getPanelBuscarVersiones().verTabla(matriz, header);
            }else{
                view.mensajeAlerta("Error", "Verifique datos ingresados"
                        , view.devolverImagenButton("error", "png", 50, 50));
            }


        } else if (command.equals("VOLVER_TABLA")) {
            cambiarPanel(view.getPanelMenu());

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

    public void asignarBotonesFiltro() {
        for (int i = 0; i < 2; i++) {
            view.getPanelBuscarDebut().devolverBoton(i).addActionListener(this);
            view.getPanelBuscarGenero().devolverBoton(i).addActionListener(this);
            view.getPanelBuscarTitulo().devolverBoton(i).addActionListener(this);
            view.getPanelEliminarFilm().devolverBoton(i).addActionListener(this);
            view.getPanelBuscarCostoso().devolverBoton(i).addActionListener(this);
            view.getPanelBuscarClasificaciones().devolverBoton(i).addActionListener(this);
            view.getPanelBuscarVersiones().devolverBoton(i).addActionListener(this);
        }
    }


}
