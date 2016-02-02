package izzy.sggw.films;

/**
 * Created by Paweł on 01.02.2016.
 */

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilmRepository extends MongoRepository<Film, String> {
    List<Film> findTop10BySeen(boolean seen, Sort sort);
}
