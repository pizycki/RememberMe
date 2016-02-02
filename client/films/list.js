import {inject} from 'aurelia-framework';
import {FilmData} from './filmData';
import {Router} from 'aurelia-router'

@inject(FilmData, Router)
export class List {

    constructor(filmData, router) {
        this.data = filmData;
        this.router = router;
    }

	range(n) {
		var arr = [];
		while (n >= 0) {
		    arr.unshift(--n);
		}
		return arr;
	}

    activate(params) {    		
       	return this.data.getAll()
                   .then(films => this.films = films);	
    }

    loadAll(){
    	return this.data.getAll()
                   .then(films => this.films = films);	
    }

    loadTop10(){    	
    	return this.data.getTop10()
    					.then(films => this.films = films);
    }

    loadWatched(){
    	return this.data.getWatched(true)
    					.then(films => this.films = films);
    }

	loadToWatch(){
    	return this.data.getWatched(false)
    					.then(films => this.films = films);
    }

	delete() {
		// TODO implement
	}
}