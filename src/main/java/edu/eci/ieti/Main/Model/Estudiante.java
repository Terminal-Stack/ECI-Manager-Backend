package edu.eci.ieti.Main.Model;

public class Estudiante{
    private int carnet;
    private String correo;
    private String nombre;
    private String password;
    private int documento;
    private String programa;
    private Notas notas;


    public Estudiante(int carnet, String correo, String nombre, String password, int documento, String programa) {
        this.carnet = carnet;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
        this.documento = documento;
        this.programa = programa;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public int getDocumento() {
        return documento;
    }

    public String getPrograma() {
        return programa;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }
}