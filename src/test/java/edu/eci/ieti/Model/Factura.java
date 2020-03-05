
package edu.eci.ieti.Model;

public class Factura{
    private int id;
    private int valor;
    private String descripcion;
    private Date fecha;

    public Factura(int id, int valor, String descripcion, Date fecha) {
        this.id = id;
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha = fecha;
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
}