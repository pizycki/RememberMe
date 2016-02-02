package izzy.sggw.films;

/**
 * Created by Paweł on 01.02.2016.
 */

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<Film, String> {

}
