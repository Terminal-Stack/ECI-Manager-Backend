package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Grades;
import edu.eci.ieti.ecimanager.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author anrodriguez
 */
@Repository
public interface GradesRepository extends MongoRepository<Grades, String> {

    List<Grades> findByStudentId(Long studentId);

    List<Grades> findByStudentIdAndSemester(Long studentId, int semester);

    Optional<Grades> findByStudentIdAndSubject(Long studentId, String subject);
}
