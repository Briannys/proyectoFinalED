package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class NodoArbol implements Serializable {

    private Pelicula pelicula;
    private NodoArbol padre;
    private NodoArbol hijoIzquierdo;
    private NodoArbol hijoDerecho;

    public NodoArbol() {
        this.pelicula = null;
        this.padre = null;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public NodoArbol(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.padre = null;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }
}
