import { AuthenticationService } from './authentication.service';
import { Booking } from './../interfaces/booking.interface';
import { RoomDimension } from './../interfaces/room.interface';
import { Chair } from './../interfaces/booking-ticket.interface';
import { Http, Response, URLSearchParams  } from '@angular/http';
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
  selectedFilmTitle: string = '';
  selectedPaymentMethodName: string = '';
  amenitiesChargeOfSelectedCinema: number = 0;

  constructor(private http: Http,
              private authService: AuthenticationService) { }

  getAgeLimit() {
    return this.ageLimit;
  }

  getAmenitiesChargeOfSelectedCinema() {
    return this.amenitiesChargeOfSelectedCinema;
  }

  getSelectedFilmName() {
    return this.selectedFilmName;
  }

  getSelectedFilmTitle() {
    return this.selectedFilmTitle;
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
    this.selectedFilmTitle = film.title;
    let nonEmptyCinemasOfFilm = film.cinemas.filter((cinema: Cinema) => {
      for (let i = 0; i < cinema.screenings.length; i++) {
        return cinema.screenings[i].filmTitle === film.title;
      }
    })
    console.log(nonEmptyCinemasOfFilm)
    this.cinemasOfSelectedFilm.next(nonEmptyCinemasOfFilm);
    this.ageLimit.next(film.ageLimit);
  }

  setFirstStageInfoOfBooking(cinema: Cinema) {
    this.selectedCinemaName.next(cinema.name);
    this.amenitiesChargeOfSelectedCinema = cinema.amenitiesCharge;
    console.log(cinema.screenings)
    this.screeningsOfSelectedCinema.next(cinema.screenings);
  }

  setSecondStageInfoOfBooking(screening: Screening) {
    this.selectedScreening.next(screening);
    this.selectedScreeningId.next(screening.id);
    this.roomDimension.next({row: screening.roomId.row, seatNumber: screening.roomId.seatNumber});
    this.ticketsOfSelectedScreening.next(screening.availableTickets);
    this.bookingsOnSelectedScreening.next(screening.bookings);
  }

  setThirdStageInfoOfBooking(selectedTickets: Ticket[], paymentMethodName: string) {
    this.selectedTickets = selectedTickets;
    this.selectedTicketsCount.next(this.selectedTickets.length);
    this.selectedPaymentMethodName = paymentMethodName;
  }

  getOccupiedChairs(screeningId: string): Observable<Chair[]> {
    return this.http.get('http://localhost:8080/booking/tickets?screeningId=' + screeningId).map((response: Response) => response.json().data[0].tickets);
  }


  getFilmsOfCinema(film: Film) {
    return this.http.get('http://localhost:8080/world/cinema_by_film_title').map((response: Response) => console.log(response));
  }

  saveBookingInDatabase(selectedChairs: Chair[], screeningId: number) {
    let bookingTypes = [];
    for (let i = 0; i < this.selectedTickets.length; i++) {
      bookingTypes.push({ticketType: this.selectedTickets[i].ticket.type,
                         row: selectedChairs[i].row.toString(),
                         chair: selectedChairs[i].chair.toString()});
    }

    let newBooking = {
                      screeningId: screeningId,
                      username: this.authService.getUsername(),
                      paymentMethod: this.selectedPaymentMethodName,
                      bookings: bookingTypes
                     }
    console.log(newBooking);

    let bookingPromise = this.http.post('http://localhost:8080/booking/new_booking', newBooking).toPromise();

    bookingPromise.then((response: Response) => {
      return response.json();
    }).then((response) => {
      console.log(response);
    })
  }
}
