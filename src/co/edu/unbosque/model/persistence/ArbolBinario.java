package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.ArrayList;


public class ArbolBinario implements Serializable {

    private NodoArbol raiz;
    private int cantidadNodos;


    public ArbolBinario() {
        cantidadNodos = 0;
        raiz = null;

    }

    public boolean arbolVacio() {
        return raiz == null;
    }

    public void insertar(Pelicula pelicula) {
        int cont = 0;
        NodoArbol newNodo = new NodoArbol(pelicula);
        if (arbolVacio()) {
            raiz = newNodo;
        } else {
            NodoArbol aux = raiz;
            while (aux != null) {
                newNodo.setPadre(aux);
                if (newNodo.getPelicula().getId() >= aux.getPelicula().getId()) {
                    aux = aux.getHijoDerecho();
                    // System.out.println(cont);
                    // System.out.println("Insert derecha");
                    cont++;
                } else {
                    // System.out.println("insert izquierda");
                    aux = aux.getHijoIzquierdo();
                }
            }
            if (newNodo.getPelicula().getId() < newNodo.getPadre().getPelicula().getId()) {

                newNodo.getPadre().setHijoIzquierdo(newNodo);
                cantidadNodos++;
            } else {

                newNodo.getPadre().setHijoDerecho(newNodo);
                cantidadNodos++;

            }
        }


    }


    public Boolean eliminar(int dato) {
        NodoArbol aux = raiz; //va a recorrer el arbol
        NodoArbol padre = raiz; //va a sabeer el padre del que estamos recorriendo
        boolean esHijoIzq = true; //para saber si es hijo izquierdo o derecho

        while (aux.getPelicula().getClave() != dato) {
            padre = aux;
            if (dato < aux.getPelicula().getClave()) {
                esHijoIzq = true;
                aux = aux.getHijoIzquierdo();
            } else {
                esHijoIzq = false;
                aux = aux.getHijoDerecho();
            }
            if (aux == null) {
                return false;
            }
        }
        //si ecuentra el nodo
        if (aux.getHijoIzquierdo() == null && aux.getHijoDerecho() == null) { //para saber si ese nodo es una hoja
            if (aux == raiz) { //para saber si solo tengo un nodo
                raiz = null;
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(null);
            } else {
                padre.setHijoDerecho(null);
            }
        } else if (aux.getHijoDerecho() == null) { //se reacomoda los punteros
            if (aux == raiz) {
                raiz = aux.getHijoIzquierdo();
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(aux.getHijoIzquierdo());
            } else {
                padre.setHijoDerecho(aux.getHijoIzquierdo());
            }
        } else if (aux.getHijoIzquierdo() == null) {
            if (aux == raiz) {
                raiz = aux.getHijoDerecho();
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(aux.getHijoDerecho());
            } else {
                padre.setHijoDerecho(aux.getHijoIzquierdo());
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplaz(aux); // remplazar el nodo que vamos a eliminar
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.setHijoIzquierdo(reemplazo);
            } else {
                padre.setHijoDerecho(reemplazo);
            }
            reemplazo.setHijoIzquierdo(aux.getHijoIzquierdo());
        }

        return true;

    }

    public int obtenerClaveLibre() {
        NodoArbol aux = raiz;
        while (aux.getHijoDerecho() != null) {
            aux = aux.getHijoDerecho();
        }
        return aux.getPelicula().getClave() + 1;
    }

    public int calcularTamanio() {
        NodoArbol aux = raiz;
        int cont = 0;
        while (aux != null) {
            cont++;
            aux = aux.getHijoDerecho();
        }
        return cont;
    }

    public ArrayList recorerPreOrden(NodoArbol nodo, ArrayList a) {
        if (nodo != null) {
            a.add(nodo.getPelicula());
            recorerPreOrden(nodo.getHijoIzquierdo(), a);
            recorerPreOrden(nodo.getHijoDerecho(), a);
        }
        return a;
    }



    public Pelicula encontrarPelicula(int id, int cont) {
        NodoArbol aux = raiz;
        while (aux != null) {
            // System.out.println(cont);
            if (aux.getPelicula().getId() == id) {
                return aux.getPelicula();
            }
            aux = aux.getHijoDerecho();
            cont++;
        }
        return null;
    }

    public NodoArbol busqueda(int a) {
        NodoArbol aux = raiz;
        while (aux.getPelicula().getClave() != a) {
            if (a < aux.getPelicula().getClave()) {
                aux = aux.getHijoIzquierdo();
            } else {
                aux = aux.getHijoDerecho();
            }
            if (aux == null) { //saber si ya estamos en el fina
                return null;
            }
        }
        return aux;
    }

    private NodoArbol obtenerNodoReemplaz(NodoArbol aux) {
        NodoArbol reemplazarPadre = aux;
        NodoArbol reemplazo = aux;
        NodoArbol auxiliar = aux.getHijoDerecho();
        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.getHijoIzquierdo();
        }
        if (reemplazo != aux.getHijoDerecho()) { //para reacomodar los enlases
            reemplazarPadre.setHijoIzquierdo(reemplazo.getHijoDerecho());
            reemplazo.setHijoDerecho(aux.getHijoDerecho());
        }
        System.out.println("El nodo de reemplazo es " + reemplazo.getPelicula().getClave());
        return reemplazo;

    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }
    /* public boolean elementoNOExite(int a) {
        int cont = 0;
        if (!arbolVacio()) {
            for (int i = 0; i < elementos.size(); i++) {
                if (a == elementos.get(i)) {
                    cont++;

                }
            }
        }
        return cont == 0;
    }*/

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }


}
