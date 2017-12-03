import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

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

  constructor() { }

  ngOnInit() {
  }

}
