package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author anrodriguez
 */
@Repository
public interface GradeRepository extends MongoRepository<Grade, String> {

    List<Grade> findByStudentId(Long studentId);

    List<Grade> findByStudentIdAndSemester(Long studentId, int semester);

    Optional<Grade> findByStudentIdAndSubject(Long studentId, String subject);
}
