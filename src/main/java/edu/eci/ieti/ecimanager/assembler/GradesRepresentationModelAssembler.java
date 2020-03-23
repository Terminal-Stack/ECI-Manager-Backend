package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.GradesController;
import edu.eci.ieti.ecimanager.model.Grades;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class GradesRepresentationModelAssembler implements RepresentationModelAssembler<Grades, EntityModel<Grades>> {

    @Override
    public EntityModel<Grades> toModel(Grades grades) {
        return new EntityModel<Grades>(grades,
                linkTo(GradesController.class).slash(grades.getId()).withSelfRel(),
                linkTo(GradesController.class).withRel("grades"));
    }

}
