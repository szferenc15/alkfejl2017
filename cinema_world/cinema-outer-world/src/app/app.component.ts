import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  leftMenu: Menu[] = [
    { name: "Aktuális filmek", path: "/films"},
    { name: "Büfé és jegyinformáció", path: "/cinema-ticket-info"},
    { name: "Nyereményjáték", path: "/sweepstakes"},
    { name: "Díjak", path: "/awards"}
  ];

  rightMenu: Menu[] = [
    { name: "Bejelentkezés", path: "/login"},
    { name: "Regisztráció", path: "/register"}
  ];
}

export interface Menu {
  name: string;
  path: string;
}
