package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author anrodriguez
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);
}
