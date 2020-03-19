/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services;

import edu.eci.ieti.Main.Model.Notas;
import java.util.List;

/**
 *
 * @author Daniel Felipe Rodriguez Villalba
 */
public interface ServiciosNotas {
    List<Notas> getNotasByStudent(int studentId);
    List<Notas> getNotasByStudentSemester(int studentId,int semestre);
    List<Notas> getNotasDeMateria(int studentId, String materiaS);
}
