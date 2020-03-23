package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.GradesRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.GradesNotFoundException;
import edu.eci.ieti.ecimanager.exception.StudentNotFoundException;
import edu.eci.ieti.ecimanager.exception.SubjectNotFoundInStudentException;
import edu.eci.ieti.ecimanager.model.Grades;
import edu.eci.ieti.ecimanager.model.Student;
import edu.eci.ieti.ecimanager.repository.GradesRepository;
import edu.eci.ieti.ecimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradesRepresentationModelAssembler gradesRepresentationModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Grades>> all() {
        List<EntityModel<Grades>> grades = gradesRepository.findAll().stream()
                .map(gradesRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(grades, linkTo(GradesController.class).withSelfRel());
    }

    @GetMapping("/{studentId}")
    public CollectionModel<EntityModel<Grades>> findById(@PathVariable Long studentId) {
        studentRepository.findByCollegeId(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        List<EntityModel<Grades>> grades = gradesRepository.findByStudentId(studentId).stream()
                .map(gradesRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(grades, linkTo(GradesController.class).withSelfRel());
    }

    @GetMapping("/{studentId}/{semester}")
    public CollectionModel<EntityModel<Grades>> findByStudentAndSemester(@PathVariable Long studentId, @PathVariable int semester) {
        studentRepository.findByCollegeId(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        List<EntityModel<Grades>> grades = gradesRepository.findByStudentIdAndSemester(studentId, semester).stream()
                .map(gradesRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(grades, linkTo(GradesController.class).withSelfRel());
    }

    @GetMapping("/{studentId}/{subject}")
    public EntityModel<Grades> findByStudentAndSubject(@PathVariable Long studentId, @PathVariable String subject) {
        studentRepository.findByCollegeId(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        Grades grades = gradesRepository.findByStudentIdAndSubject(studentId, subject).orElseThrow(() -> new SubjectNotFoundInStudentException(studentId, subject));

        return gradesRepresentationModelAssembler.toModel(grades);
    }

}