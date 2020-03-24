package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.StudentRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.StudentNotFoundException;
import edu.eci.ieti.ecimanager.model.Student;
import edu.eci.ieti.ecimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping(value = "students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRepresentationModelAssembler studentRepresentationModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Student>> all() {
        List<EntityModel<Student>> students = studentRepository.findAll().stream()
                .map(studentRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(students, linkTo(StudentController.class).withSelfRel());
    }

    @GetMapping("/{collegeId}")
    public EntityModel<Student> findByCollegeId(@PathVariable Long collegeId) {
        Student student = studentRepository.findById(collegeId).orElseThrow(() -> new StudentNotFoundException(collegeId));

        return studentRepresentationModelAssembler.toModel(student);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Student newStudent) throws URISyntaxException {
        EntityModel<Student> entityModel = studentRepresentationModelAssembler
                .toModel(studentRepository.insert(newStudent));

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

}