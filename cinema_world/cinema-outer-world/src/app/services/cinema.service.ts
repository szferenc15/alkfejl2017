import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { Http, Response } from '@angular/http';
import { Cinema } from './../interfaces/cinema.interface';
import { Injectable } from '@angular/core';

@Injectable()
export class CinemaService {
    constructor(private http: Http) {}

    getCinemas(): Observable<Cinema[]> {
      return this.http.get('http://localhost:8080/world/cinemas').map((response: Response) => response.json().data);
    }

}
