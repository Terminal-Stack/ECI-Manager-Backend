package edu.eci.ieti.Main.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notas{
    @Id
    private String id;
    private int semestre;
    private String materia;
    private int tercio;
    private long nota;

    public Notas() {
    }

    public Notas(String id, int semestre, String materia, int tercio, long nota) {
        this.id = id;
        this.semestre = semestre;
        this.materia = materia;
        this.tercio = tercio;
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getMateria() {
        return materia;
    }

    public int getTercio() {
        return tercio;
    }

    public long getNota() {
        return nota;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setTercio(int tercio) {
        this.tercio = tercio;
    }

    public void setNota(long nota) {
        this.nota = nota;
    }
    
}