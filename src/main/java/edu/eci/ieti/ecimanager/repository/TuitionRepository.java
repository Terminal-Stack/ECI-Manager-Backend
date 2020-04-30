package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Tuition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TuitionRepository extends MongoRepository<Tuition, String> {

    Optional<Tuition> findNyStudentCollegeId(Long studentCollegeId);

}
