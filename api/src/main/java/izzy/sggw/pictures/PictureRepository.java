package izzy.sggw.pictures;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Paweł on 28.01.2016.
 */
public interface PictureRepository extends MongoRepository<Picture, String> {

    List<Picture> findByUserId(String userId);
}
