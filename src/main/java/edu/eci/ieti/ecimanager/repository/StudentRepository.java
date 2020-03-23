package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author anrodriguez
 */
public interface StudentRepository extends MongoRepository<Student, String> {

}
