import { Screening } from './../interfaces/screening.interface';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { Film } from './../interfaces/film.interface';
import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ScreeningService {
  constructor(private http: Http) {}

  getScreenings(): Observable<Screening[]> {
    return this.http.get('http://localhost:8080/world/screenings').map((response: Response) => response.json().data);
  }
}
