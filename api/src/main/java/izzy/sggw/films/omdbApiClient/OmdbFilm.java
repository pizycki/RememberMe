package izzy.sggw.films.omdbApiClient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Paweł on 03.02.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbFilm {

    private final String imdbBaseUrl = "http://www.imdb.com/title/";

    private String title;
    private int year;
    private String imdbID;
    private String type;
    private String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbUrl() {
        return imdbBaseUrl + imdbID;
    }
}
