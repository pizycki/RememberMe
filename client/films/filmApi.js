import {inject} from "aurelia-framework";
import {HttpClient} from "aurelia-http-client";

export let baseUrl = "http://localhost:8080/api/films";
let parse = message => JSON.parse(message.response);

@inject(HttpClient)
export class FilmApi {
    
    constructor(httpClient) {
        this.http = httpClient;
        this.http.configure(c => {
            c.withBaseUrl(baseUrl);
            c.withHeader("Accept", "application/json");
            c.withHeader("Content-Type", "application/json");
        });

    }

    getFilmDetailsByTitle(title) {
        return this.http.get("details/" + title)
                        .then(parse);
    }

    getFilmCover(title){
        return this.http.get("cover/" + title)
                        .then(parse);
    }

    searchFilmsByTitle(title){
        return this.http.get("catalog/" + title)
                        .then(parse);
    }
}