import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { User } from './../interfaces/user.interface';
import { Subject } from 'rxjs/Rx';

@Injectable()
export class RegisterService {

    registration: Subject<string> = new Subject<string>();

    constructor(private http: Http) { }

    register(username: string, password: string, email: string, phoneNumber: string) {
      console.log(username)
      let new_user = { username: username, password: password, email: email, phoneNumber: phoneNumber }
      let registerPromise = this.http.post('http://localhost:8080/user/register', new_user).toPromise()

      registerPromise.then((response: Response)=> {
        return response.json();
      }).then((response) => {
        this.registration.next(response);
      })
    }

    getRegistration() {
      return this.registration;
    }
}
