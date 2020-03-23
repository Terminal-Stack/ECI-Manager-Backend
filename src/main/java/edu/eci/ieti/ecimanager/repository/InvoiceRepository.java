package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Invoice;
import edu.eci.ieti.ecimanager.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author anrodriguez
 */
public interface InvoiceRepository extends MongoRepository<Invoice, String> {

    Object findByStudent(Optional<Student> byId);
}
