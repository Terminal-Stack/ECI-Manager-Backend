/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Model.Estudiante;
import edu.eci.ieti.Main.Model.Notas;
import edu.eci.ieti.Main.Services.ServiciosEstudiantes;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author andres.rodriguez-de
 */
@Service
public class ServiciosEstudiantesImpl implements ServiciosEstudiantes{
    private List<Estudiante> estudiantes;
    @Override
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    @Override
    public Estudiante getEstudianteById(int carnet) {   
        Estudiante res=null;
        for(Estudiante e: estudiantes){
            if(e.getCarnet()==carnet){
                res=e;
            }
        }
        return res;
    }
    @Override
    public List<Notas> consultarNotas(int carnet){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
