package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anrodriguez
 */
@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, String> {

    List<Invoice> findByStudentId(Long studentId);
}
