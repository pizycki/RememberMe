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
            .ensure('film.title') 
              .isNotEmpty()
              .hasMinLength(3)
              .hasMaxLength(100)
            .ensure('film.interestLevel')
              .isNumber()
              .isBetween(0,5)
            .ensure('film.rate')
              .isNumber()
              .isBetween(1,10)
    }

    activate(params) {
        if(params.id) {
            this.data.getById(params.id).then(film => {
                this.film = film;
                this.validation.validate();
            });
        }
        else {
            this.film = {
                rate: 5,
                interestLevel: 3
            };
        }
    }

    save() {
        this.validation.validate().then(() => {
            return this.data.save(this.film);
        }).then(film => {
            console.log(film);
            let url = this.router.generate("details", { id: film.id });
            this.router.navigate(url);
        });
    }

}