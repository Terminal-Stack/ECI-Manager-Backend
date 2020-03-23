package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author anrodriguez
 */
public interface NewsRepository extends MongoRepository<News, String> {

}
