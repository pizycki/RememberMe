package izzy.sggw.pictures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Paweł on 28.01.2016.
 */
@RestController
public class PictureController {
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureController(PictureRepository pictureRepository)
     {
         this.pictureRepository = pictureRepository;
     }

    @RequestMapping(value = "users/{userId}/pictures/",method = RequestMethod.POST)
    public ResponseEntity<Picture> addPicture(@Valid @RequestBody Picture picture,
                                              @PathVariable("userId") String userId)
    {
        picture.setUserId(userId);
        this.pictureRepository.insert(picture);
        return new ResponseEntity<>(picture, HttpStatus.CREATED);
    }

    @RequestMapping(value = "pictures/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Picture> updatePicture(@PathVariable String id,
                                                 @Valid @RequestBody Picture picture){
        Picture p = pictureRepository.findOne(id);
        if (p==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        picture.setId(id);
        this.pictureRepository.save(picture);
        return new ResponseEntity<>(picture, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "pictures/{id}", method = RequestMethod.GET)
    public Picture getPicture(@PathVariable("id") String id)
    {
        return this.pictureRepository.findOne(id);
    }

    @RequestMapping(value = "/users/{userId}/pcitures", method = RequestMethod.GET)
    public List<Picture> getAllPictures(@PathVariable("userId") String userId)
    {
        return this.pictureRepository.findByUserId(userId);
    }

    @RequestMapping(value = "pictures/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Picture> deletePicture(@PathVariable("id") String id){
        this.pictureRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
