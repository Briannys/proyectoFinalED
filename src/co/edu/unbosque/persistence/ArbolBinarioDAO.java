package co.edu.unbosque.persistence;

import co.edu.unbosque.model.ArbolBinario;
import co.edu.unbosque.model.Pelicula;

import java.util.ArrayList;

public class ArbolBinarioDAO {
    private ArbolBinario arbolBinario[];
    private OperacionArchivo operacion;


    public ArbolBinarioDAO() {
        arbolBinario = null;
        operacion = new OperacionArchivo();
    }

    public void leerDatosCsv() throws ClassNotFoundException {
        if(operacion.obtener()==null){
            arbolBinario = operacion.leerCsv();
            operacion.escribir(arbolBinario);
        }else{
            arbolBinario = operacion.obtener();
        }
    }

    public void agregarPelicula(Pelicula pelicula) throws ClassNotFoundException {
        System.out.println("el tamanio antes es "+arbolBinario[arbolBinario.length-1].getCantidadNodos());
        arbolBinario[arbolBinario.length-1].insertar(pelicula);
        System.out.println("el tamanio despues es "+arbolBinario[arbolBinario.length-1].getCantidadNodos());
        operacion.escribir(arbolBinario);


    }

    public boolean comprobarExitencia(int id){
        for(int i=0;i<=arbolBinario.length-1;i++){
            if(arbolBinario[i].busqueda(id)!=null){
                System.out.println(arbolBinario[i].busqueda(id).getPelicula().toString());
                return true;
            }
        }
        System.out.println("Pelicula no existe");
        return false;
    }

    public String[][] filtrarSegunAnio(int anioInicio, int anioFinal){
        int tamanio = 0;
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunAnio(arbolBinario[i].getRaiz(),anioInicio,anioFinal,peliculas);
        }
        String filtroPelicula[][] = new String[peliculas.size()][10];
        for(int i=0;i<peliculas.size();i++){
            filtroPelicula[i][0] = peliculas.get(i).getTitulo();
            filtroPelicula[i][1] = peliculas.get(i).getEstudio();
            filtroPelicula[i][2] = peliculas.get(i).getEstado();
            filtroPelicula[i][3] = peliculas.get(i).getVersion();
            filtroPelicula[i][4] = String.valueOf(peliculas.get(i).getPrecio());
            filtroPelicula[i][5] = peliculas.get(i).getClasificacion();
            filtroPelicula[i][6] = peliculas.get(i).getAnio();
            filtroPelicula[i][7] = peliculas.get(i).getGenero();
            filtroPelicula[i][8] = peliculas.get(i).getFechaPublicacion();
            filtroPelicula[i][9] = String.valueOf(peliculas.get(i).getId());
        }

        return filtroPelicula;

    }

    public boolean editarPelicula(int id, String titulonuevo) throws ClassNotFoundException {
        for(int i=0;i<=arbolBinario.length-1;i++){
            if(arbolBinario[i].busqueda(id)!=null){
                arbolBinario[i].busqueda(id).getPelicula().setTitulo(titulonuevo);
                System.out.println("Pelicula encontrada");
                operacion.escribir(arbolBinario);
                return true;
            }
        }

        System.out.println("Pelicula no encontrada");
        return false;
    }



    public int obtenerIndexLibre() throws ClassNotFoundException {
        if(operacion.obtener()!=null){
            arbolBinario = operacion.obtener();
        }
        for (int i=0;i<arbolBinario.length;i++){
            if(arbolBinario[i].calcularTamanio()<1000){
                return i;
            }
        }
        return -1;
    }


    public ArbolBinario[] getArbolBinario() {
        return arbolBinario;
    }

    public void setArbolBinario(ArbolBinario[] arbolBinario) {
        this.arbolBinario = arbolBinario;
    }

    public OperacionArchivo getOperacion() {
        return operacion;
    }

    public void setOperacion(OperacionArchivo operacion) {
        this.operacion = operacion;
    }
}
