package izzy.sggw.films;

import izzy.sggw.films.omdbApiClient.FilmApi;
import izzy.sggw.films.omdbApiClient.OmdbFilm;
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
    private FilmApi filmApi;

    @Autowired
    public FilmController(FilmRepository filmRepository, FilmApi filmApi)
    {
        this.filmRepository = filmRepository;
        this.filmApi = filmApi;
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

    @RequestMapping(value = "/watched/{watched}", method = RequestMethod.GET)
    public List<Film> getWatchedFilms(@PathVariable("watched") String watched) {
        return filmRepository.findBySeen(Boolean.parseBoolean(watched));
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<Film> getTop10(){
        return filmRepository.findTop10BySeen(true, new Sort(Sort.Direction.DESC, "rate"));
    }

    @RequestMapping(value = "/cover/{title}", method = RequestMethod.GET)
    public ResponseEntity<String> getCover(@PathVariable("title") String title){
        String cover = this.filmApi.getCover(title);
        return "".equals(cover)
            ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(cover, HttpStatus.OK);
    }

    @RequestMapping(value = "details/{title}", method = RequestMethod.GET)
    public OmdbFilm getFilmDetails(@PathVariable("title") String title)
    {
        return this.filmApi.getFilmDetails(title);
    }
}
