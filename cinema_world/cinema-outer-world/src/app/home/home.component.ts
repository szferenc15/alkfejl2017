import { Router } from '@angular/router';
import { BookingService } from '../services/booking.service';
import { AuthenticationService } from './../services/authentication.service';
import { Film } from './../interfaces/film.interface';
import { FilmService } from './../services/film.service';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { Component, HostListener, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {
  rate = [];
  activeElement = 0;
  activeFilmIndex = 0;
  activeTrailer = 0;
  activeFilm = 0;
  previousActiveElement = 0;
  url: SafeResourceUrl;

  films: Film[] = null;
  activeFilms: Film[] = null;

  isLoggedIn: boolean = false;
  loaded: boolean = false;

  filmSubscription: Subscription;

  constructor( private filmService: FilmService,
               private bookingService: BookingService,
               private authService: AuthenticationService,
               private router: Router,
               private sanitizer: DomSanitizer) {
  }

  ngOnInit() {
    this.filmSubscription = this.filmService.getFilms().subscribe((films: Film[]) => {
      this.films = films;
      this.activeFilms = [
        this.films[this.activeFilmIndex],
        this.films[this.activeFilmIndex + 1],
        this.films[this.activeFilmIndex + 2],
      ];
      this.rate = Array(this.films[this.activeElement].rate - 1).fill(0).map((x,i)=>i);
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[0].url);
      this.isLoggedIn = this.authService.isLoggedIn();
      this.loaded = true;
    })
  }

  ngOnDestroy() {
    this.filmSubscription.unsubscribe();
  }

  changeActiveElement(index: number) {
    if (index + this.activeFilmIndex != this.previousActiveElement) {
      this.activeElement = index + this.activeFilmIndex;
      this.activeFilm = index;
      this.rate = Array(this.films[this.activeElement].rate - 1).fill(0).map((x,i)=>i);
      this.activeTrailer = 0;
      this.previousActiveElement = this.activeElement;
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[0].url);
    }
  }

  goUp() {
    if (this.activeFilmIndex > 0) {
      this.activeFilmIndex--;
      this.activeFilms.splice(this.activeFilms.length - 1, 1);
      this.activeFilms.unshift(this.films[this.activeFilmIndex]);
      this.activeFilm++;
    }
  }

  goDown() {
    if (this.activeFilmIndex < this.films.length - 3) {
      this.activeFilmIndex++;
      this.activeFilms.splice(0, 1);
      this.activeFilms.push(this.films[this.activeFilmIndex + 2]);
      this.activeFilm--;
    }
  }

  nextTrailer() {
    if (this.activeTrailer < this.films[this.activeElement].trailers.length - 1) {
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[++this.activeTrailer].url);
    }
  }

  previousTrailer() {
    if (this.activeTrailer > 0) {
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[--this.activeTrailer].url);
    }
  }

  @HostListener('window:keydown', ['$event.key'])
  goUpOrDown(event_key: string) {
    switch (event_key) {
      case "s":
        if (this.activeFilm == 2) {
          this.goDown();
        }
        if (this.activeFilm < 2) {
          this.activeFilm++;
          if (this.activeFilm < 0) {
            this.activeFilm = 0;
          }
          this.changeActiveElement(this.activeFilm);
        }
        if (this.activeFilm > 2) {
          this.activeFilm = 2;
        }
        return false;
      case "w":
        if (this.activeFilm == 0) {
          this.goUp();
        }
        if (this.activeFilm > 0) {
          this.activeFilm--;
          if (this.activeFilm > 2) {
            this.activeFilm = 2;
          }
          this.changeActiveElement(this.activeFilm);
        }
        if (this.activeFilm < 0) {
          this.activeFilm = 0;
        }
        return false;
      case "a":
        this.previousTrailer();
        return false;
      case "d":
        this.nextTrailer();
        return false;
      default:
        break;
    }
  }

  setZeroStageInfoOfBooking(film: Film) {
    this.router.navigateByUrl('/booking');
    setTimeout(() => {this.bookingService.setZeroStageInfoOfBooking(film)}, 0);
  }
}

/*
A Marvel Studios új filmjében Thort pörölyétől megfosztva bebörtönzik az univerzum túlsó felén.
    Az idővel versenyt futva próbál visszajutni Asgardba, és megállítani a Ragnarököt;
    egy háborút, ami otthonának pusztulásával és az asgardi civilizáció eltűnésével járhat,
    és amit egy mindenható új ellenség, a könyörtelen Hela idézett elő.
    Először azonban túl kell élnie egy halálos gladiátorviadalt,
    amelyben ellenfele korábbi szövetségese és szintén a Bosszúállók tagja: a hihetetlen Hulk!
*/
