/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Model.Notas;
import edu.eci.ieti.Main.Services.ServiciosNotas;
import edu.eci.ieti.Persistence.NotasPersistence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danie
 */
public class ServiciosNotasImpl implements ServiciosNotas{
    
    @Autowired
    NotasPersistence notasRp = null;
    
    @Override
    public List<Notas> getNotasByStudent(int studentId) {
        return notasRp.getNotasByStudent(studentId);
    }

    @Override
    public List<Notas> getNotasByStudentSemester(int studentId, int semestre) {
        return notasRp.getNotasByStudentSemester(studentId, semestre);
    }

    @Override
    public List<Notas> getNotasDeMateria(int studentId, String materiaS) {
        return notasRp.getNotasDeMateria(studentId, materiaS);
    }
    
}
