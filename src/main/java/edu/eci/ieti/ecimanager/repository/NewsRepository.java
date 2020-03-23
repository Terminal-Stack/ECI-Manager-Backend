package edu.eci.ieti.ecimanager.repository;

import edu.eci.ieti.ecimanager.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author anrodriguez
 */
@Repository
public interface NewsRepository extends MongoRepository<News, String> {

    Optional<News> findByUrl(String url);

}
