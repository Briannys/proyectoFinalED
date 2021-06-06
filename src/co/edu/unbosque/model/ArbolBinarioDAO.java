package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArbolBinario;
import co.edu.unbosque.model.persistence.OperacionArchivo;
import co.edu.unbosque.model.persistence.Pelicula;

import java.util.ArrayList;

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
    //Requerimiento 2
    public void agregarPelicula(Pelicula pelicula) throws ClassNotFoundException {
        System.out.println("el tamanio antes es " + arbolBinario[arbolBinario.length - 1].getCantidadNodos());
        arbolBinario[arbolBinario.length - 1].insertar(pelicula);
        System.out.println("el tamanio antes es " + arbolBinario[arbolBinario.length - 1].getCantidadNodos());
        operacion.escribir(arbolBinario);
    }
    //Requerimiento 3
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
    //Requerimiento 5
    public String[][] filtrarSegunfechaPublicacion(int anioInicio, int anioFinal){

        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunFechaPublicacion(arbolBinario[i].getRaiz(),anioInicio,anioFinal,peliculas);
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

    //Requerimiento 6
    public String [][] filtrarSegunGenero(String genero){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunGenero(arbolBinario[i].getRaiz(),genero,peliculas);
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

    //Requerimiento 7
    public String [][] filtrarSeguntitulo(String titulo){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunTitulo(arbolBinario[i].getRaiz(),titulo,peliculas);
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

    //Requerimiento 8
    public void eliminarPelicula(int id){
        boolean bandera = false;
        for(int i=0;i<=arbolBinario.length-1;i++){
            if(arbolBinario[i].eliminar(id)){
                System.out.println("Eliminada correctamente");
                bandera = true;
                operacion.escribir(arbolBinario);
                break;
            }
        }
        if(!bandera){
            System.out.println("No se encontro");
        }
    }

    //Requerimiento 9
    public String [][] filtarValorMasCostosoDadoGenero(String genero){
        String aux[][] = filtrarSegunGenero(genero);
        int n = aux.length-1;
        sort(aux,0,n);
        return aux;
    }

    //Requerimiento 10
    public String[][] filtrarDadoClasificacion(String clasificacion){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunClasificacion(arbolBinario[i].getRaiz(),clasificacion,peliculas);
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

    //Requerimiento 11
    public String[][] filtrarDadoVersion(String version){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for(int i=0;i<=arbolBinario.length-1;i++){
            arbolBinario[i].cantidadPeliculasSegunVersion(arbolBinario[i].getRaiz(),version,peliculas);
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

    private void sort(String arr[][], int left, int right){
        if(left < right){
            int middle = (left + right) / 2;

            sort(arr, left, middle);
            sort(arr, middle+1, right);

            merge(arr, left, middle, right);
        }
    }

    private void merge(String arr[][], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        String leftArray[] = new String [n1];
        String rightArray[] = new String [n2];

        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i][4];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1][4];
        }

        int i = 0, j = 0;


        int k = left;


        while (i < n1 && j < n2) {
            if (Integer.parseInt(leftArray[i]) >= Integer.parseInt(rightArray[j])) {
                arr[k][4] = leftArray[i];
                i++;
            } else {
                arr[k][4] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i > n1) {
            arr[k][4] = leftArray[i];
            i++;
            k++;
        }
        while (j > n2) {
            arr[k][4] = rightArray[j];
            j++;
            k++;
        }
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
