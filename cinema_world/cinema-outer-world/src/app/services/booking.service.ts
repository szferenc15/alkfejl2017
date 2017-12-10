import { Subject, Observable } from 'rxjs/Rx';
import { Screening, Ticket } from './../interfaces/screening.interface';
import { Cinema } from './../interfaces/cinema.interface';
import { Film } from './../interfaces/film.interface';
import { Injectable } from '@angular/core';

@Injectable()
export class BookingService {
  selectedFilm: Film = null;
  selectedCinema: Cinema = null;
  screeningsOfSelectedCinema: Subject<Screening[]> = new Subject<Screening[]>();
  ticketsOfSelectedScreening: Subject<Ticket[]> = new Subject<Ticket[]>();
  selectedScreening: Screening = null;
  selectedTickets: Ticket[] = [];
  amenitiesChargeOfSelectedCinema = 0;

  constructor() { }

  getSelectedFilm() {
    return this.selectedFilm;
  }

  getAmenitiesChargeOfSelectedCinema() {
    return this.amenitiesChargeOfSelectedCinema;
  }

  getSelectedCinema() {
    return this.selectedCinema;
  }

  getScreeningsOfSelectedCinema() {
    return this.screeningsOfSelectedCinema;
  }

  getTicketsOfSelectedScreening() {
    return this.ticketsOfSelectedScreening;
  }

  getSelectedScreening() {
    return this.selectedScreening;
  }

  getSelectedTickets() {
    return this.selectedTickets.slice();
  }

  setFirstStageInfoOfBooking(cinema: Cinema) {
    this.selectedCinema = cinema;
    this.amenitiesChargeOfSelectedCinema = cinema.amenitiesCharge;
    this.screeningsOfSelectedCinema.next(this.selectedCinema.screenings);
  }

  setSecondStageInfoOfBooking(screening: Screening) {
    this.selectedScreening = screening;
    this.ticketsOfSelectedScreening.next(this.selectedScreening.availableTickets);
  }

  setSelectedFilm(film: Film) {
    this.selectedFilm = film;
  }
}
