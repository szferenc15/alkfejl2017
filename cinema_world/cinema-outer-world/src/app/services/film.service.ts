import { Cinema } from './../interfaces/cinema.interface';
import { Observable, Subject } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { Film } from './../interfaces/film.interface';
import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class FilmService {
  actualFilmsOfCinema: Subject<Cinema[]> = new Subject<Cinema[]>();

  constructor(private http: Http) {}

  getFilms(): Observable<Film[]> {
    return this.http.get('http://localhost:8080/world/films').map((response: Response) => response.json().data);
  }

  getActualFilmsOfCinema() {
    return this.actualFilmsOfCinema;
  }

  setActualFilmsOfCinema(cinema: Cinema) {
    console.log(cinema)
    return this.actualFilmsOfCinema.next(cinema.films);
  }

  deleteFilmByTitle(title: string) {
    let deletetionPromise = this.http.delete('http://localhost:8080/world/films/delete?title=' + title).toPromise()

    deletetionPromise.then((response: Response)=> {
      return response.json();
    })
  }
}
