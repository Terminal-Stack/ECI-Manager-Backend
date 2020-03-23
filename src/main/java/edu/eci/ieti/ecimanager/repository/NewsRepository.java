package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anrodriguez
 */
@Repository
public interface NewsRepository extends MongoRepository<News, String> {

}
