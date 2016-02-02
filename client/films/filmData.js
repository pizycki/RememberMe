import {inject} from "aurelia-framework";
import {HttpClient} from "aurelia-http-client";

let baseUrl = "http://localhost:8080/api/films";
let parse = message => JSON.parse(message.response);

@inject(HttpClient)
export class FilmData {
    
    constructor(httpClient) {
        this.http = httpClient;
        this.http.configure(c => {
            c.withBaseUrl(baseUrl);
            c.withHeader("Accept", "application/json");
            c.withHeader("Content-Type", "application/json");
        });

    }

    getById(id) {
        return this.http.get(`/${id}`)
                        .then(parse);
    }

    getAll() {
        return this.http.get().then(parse);
    }

    save(film) {
        if(film.Id) {
            return this.http.put('', film).then(parse);                          
        }
        return this.http.post('', film).then(parse);
    }
}