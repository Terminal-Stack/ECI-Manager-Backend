package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.StudentController;
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
                linkTo(StudentController.class).slash(student.getId()).withSelfRel(),
                linkTo(StudentController.class).withRel("students"));
    }
}
