import { AuthenticationService } from './services/authentication.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  hasLoggedInUser: boolean = false;

  leftMenu: Menu[] = [
    { name: "Aktuális filmek", path: "/films"},
    /*{ name: "Büfé és jegyinformáció", path: "/cinema-ticket-info"},
    { name: "Nyereményjáték", path: "/sweepstakes"},
    { name: "Díjak", path: "/awards"}*/
  ];

  rightMenu: Menu[] = [
    { name: "Bejelentkezés", path: "/login"},
    { name: "Regisztráció", path: "/register"}
  ];

  authenticatedUserMenu: Menu[] = [
    { name: "Profil", path: "/profile"},
    { name: "Kijelentkezés", path: "/home"},
  ]

  constructor(private authService: AuthenticationService) {}

  ngOnInit() {
    this.hasLoggedInUser = this.authService.isLoggedIn();
    this.authService.getHasActiveUser().subscribe((hasLoggedInUser: boolean) => {
      this.hasLoggedInUser = hasLoggedInUser;
    })
  }

  logout() {
    this.authService.logout();
  }
}

export interface Menu {
  name: string;
  path: string;
}
