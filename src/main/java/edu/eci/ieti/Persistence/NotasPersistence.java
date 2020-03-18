/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Persistence;

import edu.eci.ieti.Main.Model.Notas;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public interface NotasPersistence {
    List<Notas> getNotasByStudent(int studentId);
    List<Notas> getNotasByStudentSemester(int studentId,int semestre);
    List<Notas> getNotasDeMateria(int studentId, String materiaS);
}
