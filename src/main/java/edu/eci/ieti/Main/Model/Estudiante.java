package edu.eci.ieti.Main.Model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estudiante{
    @Id
    private String id;
    private int carnet;
    private String correo;
    private String nombre;
    private String password;
    private int documento;
    private String programa;
    private ArrayList<Notas> notas=new ArrayList<Notas>();

    public Estudiante(String id, int carnet, String correo, String nombre, String password, int documento, String programa, ArrayList<Notas> notas) {
        this.id = id;
        this.carnet = carnet;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
        this.documento = documento;
        this.programa = programa;
        this.notas = notas;
    }
    public Estudiante() {
    }
    public void agregarNota(Notas nota){
        notas.add(nota);
    }
    public Notas consultarNotaPorMateria(String n){
        Notas res=null;
        for(int i=0;i<notas.size();i++){
            if(n.equals(notas.get(i).getMateria())){
                res=notas.get(i);
            }
        }
        return res;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ArrayList<Notas> getNotas() {
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

    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }
}