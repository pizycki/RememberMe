import {inject} from 'aurelia-framework';
import {FilmData} from './filmData';

@inject(FilmData)
export class List {
    
    constructor(filmData) {
        this.data = filmData;
    }

    activate() {
        return this.data.getAll()
                        .then(films => this.films = films);
    }
}