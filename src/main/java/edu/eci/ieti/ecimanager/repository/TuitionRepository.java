package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Tuition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TuitionRepository extends MongoRepository<Tuition, String> {

    Optional<Tuition> findByStudentCollegeId(Long studentCollegeId);

}
