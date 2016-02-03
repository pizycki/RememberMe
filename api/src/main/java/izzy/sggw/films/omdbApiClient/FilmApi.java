package izzy.sggw.films.omdbApiClient;

/**
 * Created by Paweł on 03.02.2016.
 */
public interface FilmApi {
    String getCover(String title);

    OmdbFilm getFilmDetails(String title);
}
