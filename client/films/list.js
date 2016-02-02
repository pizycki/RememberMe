import {inject} from 'aurelia-framework';
import {FilmData} from './filmData';

@inject(FilmData)
export class List {

    constructor(filmData) {
        this.data = filmData;        
    }

	range(n) {
		var arr = [];
		while (n >= 0) {
		    arr.unshift(--n);
		}
		return arr;
	}

    activate() {
        return this.data.getAll()
                        .then(films => this.films = films);
    }

	delete() {
		// TODO implement
	}
}