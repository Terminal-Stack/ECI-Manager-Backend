package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.StudentRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.StudentNotFoundException;
import edu.eci.ieti.ecimanager.model.Student;
import edu.eci.ieti.ecimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/{id}")
    public EntityModel<Student> findByCollegeId(@PathVariable Long id) {
        Student student = studentRepository.findByCollegeId(id).orElseThrow(() -> new StudentNotFoundException(id));

        return studentRepresentationModelAssembler.toModel(student);
    }

}