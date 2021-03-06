package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.TuitionController;
import edu.eci.ieti.ecimanager.model.Student;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author Daniel Vela
 */
@Component
public class StudentRepresentationModelAssembler implements RepresentationModelAssembler<Student, EntityModel<Student>> {

    @Override
    public EntityModel<Student> toModel(Student student) {
        return new EntityModel<Student>(student,
                linkTo(TuitionController.class).slash(student.getCollegeId()).withSelfRel(),
                linkTo(TuitionController.class).withRel("students"));
    }
}
