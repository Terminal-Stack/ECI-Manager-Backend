package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.TuitionController;
import edu.eci.ieti.ecimanager.model.Student;
import edu.eci.ieti.ecimanager.model.Tuition;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author Daniel Vela
 */
@Component
public class TuitionRepresentationModelAssembler implements RepresentationModelAssembler<Tuition, EntityModel<Tuition>> {

    @Override
    public EntityModel<Tuition> toModel(Tuition student) {
        return new EntityModel<Tuition>(student,
                linkTo(TuitionController.class).slash(student.getStudentCollegeId()).withSelfRel(),
                linkTo(TuitionController.class).withRel("students"));
    }
}
