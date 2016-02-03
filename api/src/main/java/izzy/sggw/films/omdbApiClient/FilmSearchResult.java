package izzy.sggw.films.omdbApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paweł on 03.02.2016.
 */

public class FilmSearchResult {

    public FilmSearchResult(){
        this.search = new ArrayList<>();
    }

    private List<OmdbFilm> search;

    private int totalResults;

    private boolean response;

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<OmdbFilm> getSearch() {
        return search;
    }

    public void setSearch(List<OmdbFilm> search) {
        this.search = search;
    }
}
