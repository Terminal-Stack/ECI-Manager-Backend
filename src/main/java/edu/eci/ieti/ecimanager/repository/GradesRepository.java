package edu.eci.ieti.ecimanager.repository;


import edu.eci.ieti.ecimanager.model.Grades;
import edu.eci.ieti.ecimanager.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author anrodriguez
 */
public interface GradesRepository extends MongoRepository<Grades, String> {

    Object findByStudent(Student student);

    Object findByStudentAndSemester(Student student, int semester);

    Object findByStudentAndSubject(Student student, String subject);
}
