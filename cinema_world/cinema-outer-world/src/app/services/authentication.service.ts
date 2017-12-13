import { Injectable } from '@angular/core';
import { Http, Response, URLSearchParams } from '@angular/http';
import { User } from './../interfaces/user.interface';
import { Subject } from 'rxjs/Rx';

@Injectable()
export class AuthenticationService {

    activeUser: Subject<User> = new Subject<User>();

    constructor(private http: Http) { }

    login(emailOrUsername: string, password: string) {
      let user = { identifier: emailOrUsername, password: password }
      let loginPromise = this.http.post('http://localhost:8080/user/login', user).toPromise()

      loginPromise.then((response: Response)=> {
        return response.json();
      }).then((response) => {
        let user: User = response.data;
        this.activeUser.next(user);
        sessionStorage.setItem('user', JSON.stringify(user));
      })
    }

    isLoggedIn(): boolean {
        return sessionStorage.getItem('user') != null;
    }

    getUsername() {
      return this.activeUser;
    }
}
