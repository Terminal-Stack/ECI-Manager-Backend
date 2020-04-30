package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.TuitionRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.TuitionNotFoundException;
import edu.eci.ieti.ecimanager.model.Tuition;
import edu.eci.ieti.ecimanager.repository.TuitionRepository;
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
@RequestMapping(value = "tuitions")
@CrossOrigin(origins = {"http://localhost:3000", "https://eci-manager-frontend-herokuapp.com"})
public class TuitionController {

    @Autowired
    private TuitionRepository tuitionRepository;

    @Autowired
    private TuitionRepresentationModelAssembler tuitionRepresentationModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Tuition>> all() {
        List<EntityModel<Tuition>> tuition = tuitionRepository.findAll().stream()
                .map(tuitionRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(tuition, linkTo(TuitionController.class).withSelfRel());
    }

    @GetMapping("/{studentCollegeId}")
    public EntityModel<Tuition> findByStudentCollegeId(@PathVariable Long studentCollegeId) {
        Tuition tuition = tuitionRepository.findNyStudentCollegeId(studentCollegeId).orElseThrow(() -> new TuitionNotFoundException(studentCollegeId));

        return tuitionRepresentationModelAssembler.toModel(tuition);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Tuition newTuition) throws URISyntaxException {
        EntityModel<Tuition> entityModel = tuitionRepresentationModelAssembler
                .toModel(tuitionRepository.insert(newTuition));

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

    @PostMapping("/pay/{studentCollegeId}")
    public ResponseEntity<?> pay(@RequestBody Long studentCollegeId) throws URISyntaxException, TuitionNotFoundException {
        Tuition paidTuition = tuitionRepository.findNyStudentCollegeId(studentCollegeId).map(tuition -> {
            tuition.setPaid(true);
            return tuitionRepository.save(tuition);
        }).orElseThrow(() -> new TuitionNotFoundException(studentCollegeId));

        EntityModel<Tuition> entityModel = tuitionRepresentationModelAssembler.toModel(paidTuition);

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref())).body(entityModel);
    }

    @PutMapping("/{studentCollegeId}")
    private ResponseEntity<EntityModel<Tuition>> update(@PathVariable Long studentCollegeId, @RequestBody Tuition newTuition)
            throws URISyntaxException {
        Tuition updatedTuition = tuitionRepository.findNyStudentCollegeId(studentCollegeId).map(tuition -> {
            tuition.setValue(newTuition.getValue());
            tuition.setPaid(newTuition.getPaid());
            return tuitionRepository.save(tuition);
        }).orElseGet(() -> {
            newTuition.setStudentCollegeId(studentCollegeId);
            return tuitionRepository.save(newTuition);
        });

        EntityModel<Tuition> entityModel = tuitionRepresentationModelAssembler.toModel(updatedTuition);

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref())).body(entityModel);
    }

}