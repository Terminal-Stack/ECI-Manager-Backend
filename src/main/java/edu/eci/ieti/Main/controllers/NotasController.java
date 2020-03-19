import edu.eci.ieti.Main.Model.Noticia;
import edu.eci.ieti.Main.Services.ServiciosFactura;
import edu.eci.ieti.Main.Services.ServiciosNotas;
import edu.eci.ieti.Main.controllers.FacturaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/Notas")
public class NotasController {
    
    @Autowired
    private ServiciosNotas servNotas = null;
    
    
    @RequestMapping(method = RequestMethod.GET, path ="/{estudianteId}")
    public ResponseEntity<?> getNotasById(@PathVariable int estudianteId) {
        try {
            return new ResponseEntity<>(servNotas.getNotasByStudent(estudianteId),HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer las notas de ese estudiante", HttpStatus.FORBIDDEN);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path ="/{estudianteId}/{semester}")
    public ResponseEntity<?> getNotasByStudentSemester(@PathVariable int estudianteId,  @PathVariable int semester) {
        try {
            return new ResponseEntity<>(servNotas.getNotasByStudentSemester(estudianteId, semester),HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer las notas del semestre de ese estudiante", HttpStatus.FORBIDDEN);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path ="/{estudianteId}/{materia}")
    public ResponseEntity<?> getNotasDeMateria(@PathVariable int estudianteId,  @PathVariable String materia) {
        try {
            return new ResponseEntity<>(servNotas.getNotasDeMateria(estudianteId, materia),HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer las notas del semestre de ese estudiante", HttpStatus.FORBIDDEN);
        }
    }
    
}