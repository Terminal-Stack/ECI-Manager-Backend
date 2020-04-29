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

@RestController
@RequestMapping(value = "students")
@CrossOrigin(origins = {"http://localhost:3000", "https://eci-manager-frontend-herokuapp.com"})
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

    @GetMapping("{id}")
    public EntityModel<Student> findByIdOrEmail(@PathVariable String id) {
        if (id.contains("@")) {
            Student student = studentRepository.findByEmail(id).orElseThrow(() -> new StudentNotFoundException(id));

            return studentRepresentationModelAssembler.toModel(student);
        }
        Student student = studentRepository.findById(Long.parseLong(id)).orElseThrow(() -> new StudentNotFoundException(id));

        return studentRepresentationModelAssembler.toModel(student);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Student newStudent) throws URISyntaxException {
        newStudent.setPassword(newStudent.getPassword());
        EntityModel<Student> entityModel = studentRepresentationModelAssembler
                .toModel(studentRepository.insert(newStudent));

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

}