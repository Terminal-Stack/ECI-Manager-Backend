package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.EmployeeRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.EmployeeNotFoundException;
import edu.eci.ieti.ecimanager.model.Employee;
import edu.eci.ieti.ecimanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "employees")
@CrossOrigin(origins = {"http://localhost:3000", "https://eci-manager-frontend-herokuapp.com"})
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRepresentationModelAssembler employeeRepresentationModelAssembler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public CollectionModel<EntityModel<Employee>> all() {
        List<EntityModel<Employee>> employees = employeeRepository.findAll().stream()
                .map(employeeRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(employees, linkTo(TuitionController.class).withSelfRel());
    }

    @GetMapping("/{collegeId}")
    public EntityModel<Employee> findByCollegeId(@PathVariable Long personalId) {
        Employee employee = employeeRepository.findById(personalId).orElseThrow(() -> new EmployeeNotFoundException(personalId));

        return employeeRepresentationModelAssembler.toModel(employee);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Employee newEmployee) throws URISyntaxException {
        newEmployee.setPassword(passwordEncoder.encode(newEmployee.getPassword()));
        EntityModel<Employee> entityModel = employeeRepresentationModelAssembler
                .toModel(employeeRepository.insert(newEmployee));

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

}