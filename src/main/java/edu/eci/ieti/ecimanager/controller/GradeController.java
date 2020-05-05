package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.GradeRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.StudentNotFoundException;
import edu.eci.ieti.ecimanager.model.Grade;
import edu.eci.ieti.ecimanager.repository.GradeRepository;
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
@RequestMapping(value = "grades")
@CrossOrigin(origins = {"http://localhost:3000", "https://eci-manager-frontend.herokuapp.com"})
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepresentationModelAssembler gradeRepresentationModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Grade>> all() {
        List<EntityModel<Grade>> grades = gradeRepository.findAll().stream()
                .map(gradeRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(grades, linkTo(GradeController.class).withSelfRel());
    }

    @GetMapping("/{studentId}")
    public CollectionModel<EntityModel<Grade>> findByStudentId(@PathVariable Long studentId, @RequestParam(required = false) Integer semester) {
        studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        if (semester != null) {
            List<EntityModel<Grade>> grades = gradeRepository.findByStudentIdAndSemester(studentId, semester).stream()
                    .map(gradeRepresentationModelAssembler::toModel).collect(Collectors.toList());

            return new CollectionModel<>(grades, linkTo(GradeController.class).withSelfRel());
        }
        List<EntityModel<Grade>> grades = gradeRepository.findByStudentId(studentId).stream()
                .map(gradeRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(grades, linkTo(GradeController.class).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Grade newGrade) throws URISyntaxException {
        EntityModel<Grade> entityModel = gradeRepresentationModelAssembler
                .toModel(gradeRepository.insert(newGrade));

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

}