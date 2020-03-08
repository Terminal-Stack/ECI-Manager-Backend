package edu.eci.ieti.Main.Model;

import java.util.Date;

public class Factura{
    private int id;
    private int valor;
    private String descripcion;
    private Date fecha;
    private Estudiante estudiante; 

    public Factura(int id, int valor, String descripcion, Date fecha, Estudiante estudiante) {
        this.id = id;
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
}