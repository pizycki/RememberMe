package izzy.sggw.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Paweł on 31.01.2016.
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String email);
}