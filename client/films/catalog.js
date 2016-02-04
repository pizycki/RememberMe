import {inject} from 'aurelia-framework';
import {FilmApi} from './filmApi';
import {Router} from 'aurelia-router'

@inject(FilmApi, Router)
export class Catalog {

    constructor(filmApi, router) {
        this.api = filmApi;
        this.router = router;
    }

    activate(params) {
    	this.query = "";
       	this.list = [];
    }    

    search(){
    	return this.api.searchFilmsByTitle(this.query).then(result => 
    		{
    			this.list = result.search;
    			this.totalResults = result.totalResults;
    			this.fullSearchUrl = "";
    		});
    }
}