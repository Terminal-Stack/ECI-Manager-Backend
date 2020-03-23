package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Invoice;
import edu.eci.ieti.ecimanager.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author anrodriguez
 */
@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, String> {

    List<Invoice> findByStudentId(Long studentId);
}
