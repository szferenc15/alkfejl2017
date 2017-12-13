import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from "../services/authentication.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    username: new FormControl(null, [Validators.required,
                                     Validators.pattern('^[a-z0-9_-]{3,15}$')]),
    email: new FormControl(null, [Validators.required,
                                  Validators.pattern('^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$')]),
    password: new FormControl(null, [Validators.required,
                                     Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,25}$')]),
  });

  constructor(private authService: AuthenticationService,
              private router: Router) { }

  ngOnInit() {
  }

  login(email: string, username: string, password: string) {
    if (username == null) {
      this.authService.login(email, password);
    } else {
      this.authService.login(username, password);
    }

    this.router.navigateByUrl('/home');
  }

}
