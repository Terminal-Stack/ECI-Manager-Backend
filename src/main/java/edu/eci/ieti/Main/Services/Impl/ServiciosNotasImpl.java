/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Model.Estudiante;
import edu.eci.ieti.Main.Model.Notas;
import edu.eci.ieti.Main.Services.ServiciosEstudiantes;
import edu.eci.ieti.Main.Services.ServiciosNotas;
import edu.eci.ieti.Persistence.NotasPersistence;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class ServiciosNotasImpl implements ServiciosNotas{
    
    //@Autowired
    NotasPersistence notasRp = null;
    
    @Autowired
    ServiciosEstudiantes servEstu = null;
    
    @Override
    public List<Notas> getNotasByStudent(int studentId) {
        Estudiante est = servEstu.getEstudianteById(studentId);
        return est.getNotas();
    }

    @Override
    public List<Notas> getNotasByStudentSemester(int studentId, int semestre) {
        Estudiante est = servEstu.getEstudianteById(studentId);
        List<Notas> notas = est.getNotas();
        ArrayList<Notas> res = new ArrayList<>();
        for (Notas nota : notas) {
            if (nota.getSemestre() == semestre){
                res.add(nota);
            }
        }
        return res;
    }

    @Override
    public List<Notas> getNotasDeMateria(int studentId, String materiaS) {
        Estudiante est = servEstu.getEstudianteById(studentId);
        List<Notas> notas = est.getNotas();
        ArrayList<Notas> res = new ArrayList<>();
        for (Notas nota : notas) {
            if (nota.getMateria().equals(materiaS) ){
                res.add(nota);
            }
        }
        return res;
    }
    
}
