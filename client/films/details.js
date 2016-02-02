import {inject} from 'aurelia-framework';
import {FilmData} from './filmData';

@inject(FilmData)
export class Details {

    constructor(filmData) {
        this.data = filmData;
    }

    activate(params) {
        return this.data.getById(params.id).then(film => this.film = film);
    }

	range(n) {
		var arr = [];
		while (n >= 0) {
		    arr.unshift(--n);
		}
		return arr;
	}
}