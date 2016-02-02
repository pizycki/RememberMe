package izzy.sggw.films;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Paweł on 01.02.2016.
 */

@Document(collection = "films")
public class Film {

    @Id
    private String id;

    private String Title;

    private String ReleaseYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        ReleaseYear = releaseYear;
    }
}
