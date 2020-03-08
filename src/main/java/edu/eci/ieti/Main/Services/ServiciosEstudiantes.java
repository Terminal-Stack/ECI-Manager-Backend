/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services;

import edu.eci.ieti.Main.Model.Estudiante;
import edu.eci.ieti.Main.Model.Notas;
import java.util.List;

/**
 *
 * @author andres.rodriguez-de
 */
public interface ServiciosEstudiantes {
    public List<Estudiante> getEstudiantes();
    public Estudiante getEstudianteById(int carnet);
    public List<Notas> consultarNotas(int carnet);
}
