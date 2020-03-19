/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Persistence;

import edu.eci.ieti.Main.Model.Estudiante;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolas Patino
 */
@Service
public interface EstudiantePersistence {
    public List<Estudiante> getAllEstudiantes();
    public Estudiante getEstudianteById(String idEstudiante);
    
}
