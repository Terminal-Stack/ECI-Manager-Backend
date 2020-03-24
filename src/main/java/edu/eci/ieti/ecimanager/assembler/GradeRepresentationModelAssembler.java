package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.GradeController;
import edu.eci.ieti.ecimanager.model.Grade;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author Daniel Vela
 */
@Component
public class GradeRepresentationModelAssembler implements RepresentationModelAssembler<Grade, EntityModel<Grade>> {

    @Override
    public EntityModel<Grade> toModel(Grade grade) {
        return new EntityModel<Grade>(grade,
                linkTo(GradeController.class).slash(grade.getId()).withSelfRel(),
                linkTo(GradeController.class).withRel("grades"));
    }

}
