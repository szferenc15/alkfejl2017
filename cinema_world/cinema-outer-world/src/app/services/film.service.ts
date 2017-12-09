import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { Film } from './../interfaces/film.interface';
import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class FilmService {
  constructor(private http: Http) {}

  getFilms(): Observable<Film[]> {
    return this.http.get('http://localhost:8080/world/films').map((response: Response) => response.json().data);
  }

}
