/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Config.Mongoconfig;
import edu.eci.ieti.Main.Model.Estudiante;
import edu.eci.ieti.Main.Model.Notas;
import edu.eci.ieti.Main.Repository.EstudianteRepository;
import edu.eci.ieti.Main.Services.ServiciosEstudiantes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Service;

/**
 *
 * @author andres.rodriguez-de
 */
@Service
public class ServiciosEstudiantesImpl implements ServiciosEstudiantes{
    @Autowired
    EstudianteRepository er;
    
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Mongoconfig.class);
    private MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
    @Override
    public List<Estudiante> getEstudiantes() {
        return er.findAll();
    }

    @Override
    public Estudiante getEstudianteById(int carnet) {   
        Estudiante res=null;
        List<Estudiante> estudiantes=er.findAll();
        for(Estudiante e: estudiantes){
            if(e.getCarnet()==carnet){
                res=e;
            }
        }
        return res;
    }

    @Override
    public Estudiante agregarEstudiante(Estudiante e) {
        return er.save(new Estudiante( e.getId(), e.getCarnet(), e.getCorreo(), e.getNombre(), e.getPassword(),e.getDocumento(), e.getPrograma(), e.getNotas()));
        
    }

    @Override
    public Estudiante UpdateEstudiante(Estudiante e) {
        Query query= new Query();
        query.addCriteria(Criteria.where("id").is(e.getId()));
        Estudiante e2=mongoOperation.findOne(query, Estudiante.class);
        e2.setId(e.getId());
        e2.setCarnet(e.getCarnet());
        e2.setCorreo(e.getCorreo());
        e2.setNombre(e.getNombre());
        e2.setPassword(e.getPassword());
        e2.setPrograma(e.getPrograma());
        e2.setNotas(e.getNotas());
        mongoOperation.save(e2);
        return e2;
    }

    @Override
    public void removeEstudiante(int carnet) {
        Query query = new Query();
        query.addCriteria(Criteria.where("carnet").is(carnet));
        mongoOperation.remove(query, Estudiante.class);
    }

    @Override
    public Estudiante getByCorreo(String correo) {
         Query q=new Query();
        q.addCriteria(Criteria.where("correo").is(correo));
        Estudiante e=mongoOperation.findOne(q,Estudiante.class);
        return e;
    }
    
    /**@Override
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
    }*/

   
   
    
    
}
