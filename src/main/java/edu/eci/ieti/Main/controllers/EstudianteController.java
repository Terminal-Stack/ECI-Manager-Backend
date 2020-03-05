package edu.eci.ieti.Main.controllers;



import edu.eci.ieti.Main.Model.Estudiante;
import edu.eci.ieti.Main.Services.ServiciosEstudiantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EstudianteController{
    @Autowired
    private ServiciosEstudiantes servEstudiante;

    @RequestMapping(value="estudiantes/{estudianteID}", method =RequestMethod.GET)
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable int estudianteID){
        Estudiante estudiante = servEstudiante.getEstudianteById(estudianteID);
        return new ResponseEntity<>(estudiante,HttpStatus.OK);
    }
    @RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
    public ResponseEntity<List<Estudiante>> getEstudiantes() {
        List<Estudiante> estudiantes = servEstudiante.getEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

}