package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author anrodriguez
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    Optional<Student> findByEmail(String email);
}
