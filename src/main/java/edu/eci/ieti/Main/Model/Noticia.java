package edu.eci.ieti.Main.Model;

import java.util.Date;

public class Noticia{
    private int id;
    private String url;
    private String titulo;
    private String contenido;
    private Date fechaPublicacion;
    private String imagen;
    private String autor;

    public Noticia(int id, String url, String titulo, String contenido, Date fechaPublicacion, String imagen, String autor) {
        this.id = id;
        this.url = url;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.imagen = imagen;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getAutor() {
        return autor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
    
}