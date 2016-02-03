package izzy.sggw.films.omdbApiClient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

/**
 * Created by Paweł on 03.02.2016.
 */
@Component
public class FilmApiImpl implements FilmApi {

    public FilmSearchResult searchFilmByTitle(String title) {
        try {

            RestTemplate template = new RestTemplate();

            String rawJson =
                    template.getForObject("http://www.omdbapi.com/?s={title}", String.class, title);
            JSONObject json = (JSONObject)new JSONParser().parse(rawJson);

            FilmSearchResult searchResult = new FilmSearchResult();
            searchResult.setResponse(Boolean.parseBoolean((String) json.get("Response")));
            searchResult.setTotalResults(Integer.parseInt((String)json.get("totalResults")));

            JSONArray listOfFilms = (JSONArray) json.get("Search");
            Iterator<JSONObject> cursor = listOfFilms.iterator();
            while(cursor.hasNext())
            {
                JSONObject item = cursor.next();
                OmdbFilm film = new OmdbFilm();
                film.setPoster((String) item.get("Poster"));
                film.setImdbID((String)item.get("imdbID"));
                film.setTitle((String) item.get("Title"));
                film.setType((String) item.get("Type"));
                film.setYear(Integer.parseInt((String) item.get("Year")));

                searchResult.getSearch().add(film);
            }
            return searchResult;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    @Override
    public String getCover(String title)  {
        FilmSearchResult searchResult = searchFilmByTitle(title);
        if (searchResult.getTotalResults() == 0
                || searchResult.getSearch().isEmpty())
            return "";

        return searchResult.getSearch().get(0).getPoster();
    }

    @Override
    public OmdbFilm getFilmDetails(String title) {
        return searchFilmByTitle(title).getSearch().get(0);
    }
}
