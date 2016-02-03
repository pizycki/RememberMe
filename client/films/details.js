import {inject} from 'aurelia-framework';
import {FilmData} from './filmData';
import {FilmApi} from './filmApi';

@inject(FilmData, FilmApi)
export class Details {

    constructor(filmData, api) {
        this.data = filmData;
        this.api = api;
        this.details = {};
    }

    activate(params) {
        return this.data.getById(params.id).then(film => this.film = film);
    }

    loadDetails() {
    	return this.api.getFilmDetailsByTitle(this.film.title)
    				   .then(details => this.details = details);
    }

	range(n) {
		var arr = [];
		while (n >= 0) {
		    arr.unshift(--n);
		}
		return arr;
	}
}