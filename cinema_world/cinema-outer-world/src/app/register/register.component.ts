import { matchOtherValidator } from '../validators/match-other-validate.validator';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm = new FormGroup({
    username: new FormControl(null, [Validators.required,
                                     Validators.pattern('^[a-z0-9_-]{3,15}$')]),
    password: new FormControl(null, [Validators.required,
                                     Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,25}$')]),
    passwordConfirmation: new FormControl(null, [Validators.required,
                                                 matchOtherValidator('password')]),
    email: new FormControl(null, [Validators.required,
                                  Validators.pattern('^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$')]),
    phoneNumber: new FormControl(null, [Validators.required,
                                        Validators.pattern('^\\+?[0-9]{7,14}$')])
  });

  constructor() { }

  ngOnInit() {
  }

}
