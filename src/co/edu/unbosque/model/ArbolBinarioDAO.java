package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArbolBinario;
import co.edu.unbosque.model.persistence.OperacionArchivo;
import co.edu.unbosque.model.persistence.Pelicula;

public class ArbolBinarioDAO  {
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
        System.out.println("el tamanio antes es "+arbolBinario[arbolBinario.length-1].getCantidadNodos());
        operacion.escribir(arbolBinario);


    }

    public boolean editarPelicula(int id, String titulonuevo) throws ClassNotFoundException {
        System.out.println("entra al metodo");
        for(int i=0;i<arbolBinario.length-1;i++){
            System.out.println("i = "+i);
            if(arbolBinario[i].encontrarPelicula(id,0)!=null){
                arbolBinario[i].encontrarPelicula(id,0).setTitulo(titulonuevo);
                System.out.println("Pelicula encontrada");
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
