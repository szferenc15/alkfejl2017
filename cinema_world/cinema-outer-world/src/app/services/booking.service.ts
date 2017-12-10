import { RoomDimension } from './../interfaces/room.interface';
import { Chair } from './../interfaces/booking-ticket.interface';
import { Http, Response } from '@angular/http';
import { Subject, Observable } from 'rxjs/Rx';
import { Screening, Ticket } from './../interfaces/screening.interface';
import { Cinema } from './../interfaces/cinema.interface';
import { Film } from './../interfaces/film.interface';
import { Injectable } from '@angular/core';

@Injectable()
export class BookingService {
  screeningsOfSelectedCinema: Subject<Screening[]> = new Subject<Screening[]>();
  cinemasOfSelectedFilm: Subject<Cinema[]> = new Subject<Cinema[]>();
  ticketsOfSelectedScreening: Subject<Ticket[]> = new Subject<Ticket[]>();
  selectedFilmName: Subject<string> = new Subject<string>();
  selectedCinemaName: Subject<string> = new Subject<string>();
  selectedScreening: Subject<Screening> = new Subject<Screening>();
  selectedTicketsCount: Subject<number> = new Subject<number>();
  selectedScreeningId: Subject<number> = new Subject<number>();
  roomDimension: Subject<RoomDimension> = new Subject<RoomDimension>();
  selectedTickets: Ticket[] = [];
  selectedPaymentMethodName: string = '';
  ageLimit: number = null;
  amenitiesChargeOfSelectedCinema: number = 0;

  constructor(private http: Http) { }

  getAgeLimit() {
    return 12;
  }

  getAmenitiesChargeOfSelectedCinema() {
    return this.amenitiesChargeOfSelectedCinema;
  }

  getSelectedFilmName() {
    return this.selectedFilmName;
  }

  getSelectedCinemaName() {
    return this.selectedCinemaName;
  }

  getCinemasOfSelectedFilm() {
    return this.cinemasOfSelectedFilm;
  }

  getScreeningsOfSelectedCinema() {
    return this.screeningsOfSelectedCinema;
  }

  getTicketsOfSelectedScreening() {
    return this.ticketsOfSelectedScreening;
  }

  getSelectedScreeningId() {
    return this.selectedScreeningId;
  }

  getSelectedScreening() {
    return this.selectedScreening;
  }

  getSelectedTickets() {
    return this.selectedTickets.slice();
  }

  getSelectedTicketsCount() {
    return this.selectedTicketsCount;
  }

  getRoomDimension() {
    return this.roomDimension;
  }

  setZeroStageInfoOfBooking(film: Film) {
    this.selectedFilmName.next(film.title);
    this.cinemasOfSelectedFilm.next(film.cinemas);
  }

  setFirstStageInfoOfBooking(cinema: Cinema) {
    this.selectedCinemaName.next(cinema.name);
    this.amenitiesChargeOfSelectedCinema = cinema.amenitiesCharge;
    this.screeningsOfSelectedCinema.next(cinema.screenings);
  }

  setSecondStageInfoOfBooking(screening: Screening) {
    this.selectedScreening.next(screening);
    this.selectedScreeningId.next(screening.id);
    this.roomDimension.next({row: screening.roomId.row, seatNumber: screening.roomId.seatNumber});
    this.ticketsOfSelectedScreening.next(screening.availableTickets);
  }

  setThirdStageInfoOfBooking(selectedTickets: Ticket[], paymentMethodName: string) {
    this.selectedTickets = selectedTickets;
    this.selectedTicketsCount.next(this.selectedTickets.length);
    this.selectedPaymentMethodName = paymentMethodName;
  }

  getOccupiedChairs(screeningId: string): Observable<Chair[]> {
    return this.http.get('http://localhost:8080/booking/tickets?screeningId=' + screeningId).map((response: Response) => response.json().data[0].tickets);
  }

  saveBookingInDatabase(selectedChairs: Chair[]) {

  }
}
