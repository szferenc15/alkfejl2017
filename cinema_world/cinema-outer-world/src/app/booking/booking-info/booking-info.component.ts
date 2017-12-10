import { Time } from '@angular/common';
import { Screening } from './../../interfaces/screening.interface';
import { BookingService } from './../../services/booking.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-booking-info',
  templateUrl: './booking-info.component.html',
  styleUrls: ['./booking-info.component.css']
})
export class BookingInfoComponent implements OnInit {

  @Input() cinema = false;
  @Input() screening = false;
  @Input() tickets = false;
  selectedFilm: string = null;
  selectedCinema: string = null;
  selectedScreening: Screening = null;
  ageLimit: number = null;
  selectedTicketsCount: number = null;

  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    this.bookingService.getSelectedFilmName().subscribe((film: string) => {
      this.selectedFilm = film;
    })

    this.bookingService.getSelectedCinemaName().subscribe((cinemaName: string) => {
      this.selectedCinema = cinemaName;
    })

    this.bookingService.getSelectedScreening().subscribe((screening: Screening) => {
      this.selectedScreening = screening;
    })

    this.bookingService.getSelectedTicketsCount().subscribe((count: number) => {
      this.selectedTicketsCount = count;
    })

    this.ageLimit = this.bookingService.getAgeLimit();
  }

  ngAfterViewInit() {

  }

}
