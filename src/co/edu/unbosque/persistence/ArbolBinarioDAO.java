package co.edu.unbosque.persistence;

import co.edu.unbosque.model.ArbolBinario;
import co.edu.unbosque.model.Pelicula;

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
        }
    }

    public void agregarPelicula(Pelicula pelicula) throws ClassNotFoundException {
        if(operacion.obtener()!=null){
            arbolBinario = operacion.obtener();
        }
        pelicula.setClave(arbolBinario[obtenerIndexLibre()].obtenerClaveLibre());
        arbolBinario[0].insertar(pelicula);
        System.out.println(arbolBinario[0].busqueda(283508).getPelicula().toString());
        operacion.escribir(arbolBinario);


    }

    public boolean editarPelicula(int id, String titulonuevo) throws ClassNotFoundException {
        System.out.println("entra al metodo");
        if(operacion.obtener()!=null){
            arbolBinario = operacion.obtener();
        }
        for(int i=0;i<arbolBinario.length-1;i++){
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
