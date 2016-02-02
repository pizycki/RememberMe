package izzy.sggw.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Paweł on 31.01.2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> register(@Valid @RequestBody User user)
    {
        // TODO validation

        this.userRepository.insert(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable String id, @Valid @RequestBody User user){
        User p = userRepository.findOne(id);
        if (p==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        user.setId(id);
        this.userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") String id)
    {
        return this.userRepository.findOne(id);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable("email") String id) {
        return this.userRepository.findOne(id);
    }



//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteUser(@PathVariable("id")String id){
//        this.userRepository.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}

