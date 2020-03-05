

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
    private ServiciosEstudiante servEstudiante;

    @RequestMapping(value="estudiantes/{estudianteID}", method =RequestMethod.GET)
    public ResponseEntity<Estudiante> getById(@Pathvariable String estudianteID){
        Estudiante estudiante = servEstudiante.getById(estudianteID);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }
    @RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
    public ResponseEntity<List<Estudiante>> getEstudiantesList() {
        List<Estudiante> estudiantes = servEstudiante.getEstudiantesList();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

}