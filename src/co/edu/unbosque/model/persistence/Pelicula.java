package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo;
    private String estudio;
    private String estado;
    private String version;
    private int precio;
    private String clasificacion;
    private String anio;
    private String genero;
    private String fechaPublicacion;
    private int id;
    private int clave;

    public Pelicula(String titulo, String estudio, String estado, String version, int precio, String clasificacion, String anio, String genero, String fechaPublicacion, int id, int clave) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.estado = estado;
        this.version = version;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.anio = anio;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.id = id;
        this.clave = clave;
    }

    public Pelicula(String titulo) {
        this.titulo = titulo;
        this.estudio = "";
        this.estado = "";
        this.version = "version";
        this.precio = 1000;
        this.clasificacion = "clasificacion";
        this.anio = "anio";
        this.genero = "genero";
        this.fechaPublicacion = "fechaPublicacion";
        this.id = 1231231;
        this.clave = 0;
    }



    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", estudio='" + estudio + '\'' +
                ", estado='" + estado + '\'' +
                ", version='" + version + '\'' +
                ", precio=" + precio +
                ", clasificacion='" + clasificacion + '\'' +
                ", anio='" + anio + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                ", id=" + id +
                ", clave=" + clave +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
}
