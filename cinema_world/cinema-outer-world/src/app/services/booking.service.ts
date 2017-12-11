import { Booking } from './../interfaces/booking.interface';
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
  ageLimit: Subject<number> = new Subject<number>();
  selectedCinemaName: Subject<string> = new Subject<string>();
  selectedScreening: Subject<Screening> = new Subject<Screening>();
  selectedTicketsCount: Subject<number> = new Subject<number>();
  selectedScreeningId: Subject<number> = new Subject<number>();
  roomDimension: Subject<RoomDimension> = new Subject<RoomDimension>();
  bookingsOnSelectedScreening: Subject<Booking[]> = new Subject<Booking[]>();
  selectedTickets: Ticket[] = [];
  selectedPaymentMethodName: string = '';
  amenitiesChargeOfSelectedCinema: number = 0;

  constructor(private http: Http) { }

  getAgeLimit() {
    return this.ageLimit;
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

  getBookingsOnSelectedScreening() {
    return this.bookingsOnSelectedScreening;
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
    this.ageLimit.next(film.ageLimit);
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
    this.bookingsOnSelectedScreening.next(screening.bookings);
    console.log(screening.bookings);
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
    let params = new URLSearchParams();
    params.append('tickets', `{
      payment: 'Booking',
      row: 5,
      chair: 10,
      bookingId: 3,
      ticketType: 'IMAX 3D Normal',
      username: 'almafa'
    }`);
    params.append('screeningId', "1");
    return this.http.post('http://localhost:8080/booking/new_booking', params).map(
      (response) => console.log(response)
    )
  }
}
