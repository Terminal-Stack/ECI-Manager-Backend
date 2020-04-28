package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.EmployeeController;
import edu.eci.ieti.ecimanager.model.Employee;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author Daniel Vela
 */
@Component
public class EmployeeRepresentationModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        return new EntityModel<Employee>(employee,
                linkTo(EmployeeController.class).slash(employee.getPersonalId()).withSelfRel(),
                linkTo(EmployeeController.class).withRel("employees"));
    }

}
