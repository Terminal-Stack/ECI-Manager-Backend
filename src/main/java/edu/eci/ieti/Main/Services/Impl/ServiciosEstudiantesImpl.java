/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Model.Estudiante;
import edu.eci.ieti.Main.Model.Notas;
import edu.eci.ieti.Main.Repository.EstudianteRepository;
import edu.eci.ieti.Main.Services.ServiciosEstudiantes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andres.rodriguez-de
 */
@Service
public class ServiciosEstudiantesImpl implements ServiciosEstudiantes{
    @Autowired
    EstudianteRepository er;
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
    public ArrayList<Notas> consultarNotas(String idEstu){
        Estudiante temp=null;
        for(Estudiante e: estudiantes){
            if(idEstu.equals(e.getId())){
                temp=e;
            }
        }
        return temp.getNotas();
    }

    @Override
    public Notas consultarNotasPorMateria(String idEstu, String mate) {
        Estudiante temp=null;
        for(Estudiante e: estudiantes){
            if(idEstu.equals(e.getId())){
                temp=e;
            }
        }
        Notas res=null;
        for(Notas n:temp.getNotas()){
            if(n.getMateria().equals(mate)){
                res=n;
            }
        }
        return res;
    }

   
   
    
    
}
