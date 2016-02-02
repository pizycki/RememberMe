import {inject} from "aurelia-framework";
import {Validation} from "aurelia-validation"
import {FilmData} from "./filmData"
import {Router} from "aurelia-router";

@inject(FilmData, Validation, Router)
export class Edit {

    constructor(filmData, validation, router) {
        this.data = filmData;
        this.router = router;
        this.validation = validation.on(this)
            .ensure('film.Title') 
              .isNotEmpty()
              .hasMinLength(3)
              .hasMaxLength(100)
            .ensure('film.ReleaseYear') 
              .isNumber()
              .isBetween(1900,2100);
    }

    activate(params) {
        if(params.id) {
            this.data.getById(params.id).then(film => {
                this.film = film;
                this.validation.validate();
            });
        }
        else {
            this.film = {};
        }
    }

    save() {
        this.validation.validate().then(() => {
            return this.data.save(this.film);
        }).then(film => {
            console.log(film);
            let url = this.router.generate("details", { id: film.Id});
            this.router.navigate(url);
        });
    }

}