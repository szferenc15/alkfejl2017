import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from "../services/authentication.service";

@Injectable()
export class CanActivateViaAuthGuard implements CanActivate {

  constructor(private authService: AuthenticationService,
              private router: Router) {}

  canActivate() {
    if (this.authService.isLoggedIn()) {
        return true;
    }
    else {
        this.router.navigateByUrl('/login');
        return false;
    }
  }
}