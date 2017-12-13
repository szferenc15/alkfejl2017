import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { User } from './../interfaces/user.interface';
import { Subject } from 'rxjs/Rx';

@Injectable()
export class AuthenticationService {

    activeUser: Subject<User> = new Subject<User>();
    activeUsername: string = null;

    constructor(private http: Http) { }

    login(emailOrUsername: string, password: string) {
      let user = { identifier: emailOrUsername, password: password }
      let loginPromise = this.http.post('http://localhost:8080/user/login', user).toPromise()

      loginPromise.then((response: Response) => {
        return response.json();
      }).then((response) => {
        let user: User = response.data;
        this.activeUser.next(user);
        this.activeUsername = user.username;
        sessionStorage.setItem('user', JSON.stringify(user));
      })
    }

    isLoggedIn(): boolean {
        return sessionStorage.getItem('user') != null;
    }

    getActiveUser() {
      return this.activeUser;
    }

    getUsername() {
      return JSON.parse(sessionStorage.getItem('user')).username;
    }

}
