package izzy.sggw.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Paweł on 01.02.2016.
 */
@RestController
@RequestMapping("/api/films")
public class FilmController {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository)
    {
        this.filmRepository = filmRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Film> addFilm(@Valid @RequestBody Film film) {
        Film created = this.filmRepository.insert(film);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Film> updateFilm(@Valid @RequestBody Film film){
        Film updated = this.filmRepository.save(film);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Film> deleteFilm(@PathVariable("id") String id){
        this.filmRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Film getFilm(@PathVariable("id") String id)
    {
        return this.filmRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Film> getAllFilm()
    {
        return this.filmRepository.findAll();
    }
//
//    @RequestMapping(value = "/seen", method = RequestMethod.GET)
//    public List<Film> getSeenFilms() {
//        return FilmDao.
//    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<Film> getTop10(){
        return filmRepository.findTop10BySeen(true, new Sort(Sort.Direction.DESC, "rate"));
    }
}
