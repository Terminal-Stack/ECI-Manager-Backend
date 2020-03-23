package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.repository.GradesRepository;
import edu.eci.ieti.ecimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getNotasById(@PathVariable String studentId) {
        try {
            return new ResponseEntity<>(gradesRepository.findByStudent(studentRepository.findById(studentId).get()), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer las notas de ese estudiante", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{studentId}/{semester}")
    public ResponseEntity<?> getGradesByStudentAndSemester(@PathVariable String studentId, @PathVariable int semester) {
        try {
            return new ResponseEntity<>(gradesRepository.findByStudentAndSemester(studentRepository.findById(studentId).get(), semester), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer las notas del semestre de ese estudiante", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{studentId}/{subject}")
    public ResponseEntity<?> findByStudentAndSubject(@PathVariable String studentId, @PathVariable String subject) {
        try {
            return new ResponseEntity<>(gradesRepository.findByStudentAndSubject(studentRepository.findById(studentId).get(), subject), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer las notas de esa materia para ese estudiante", HttpStatus.FORBIDDEN);
        }
    }

}