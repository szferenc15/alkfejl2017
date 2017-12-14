import { BookingService } from './../services/booking.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit, ApplicationRef } from '@angular/core';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  isFromFilmInfo: boolean = false;

  constructor(private bookingService: BookingService, private applicationRef: ApplicationRef) { }

  ngOnInit() {
    this.isFromFilmInfo = this.bookingService.getIsFromFilmInfoConstant();
    this.bookingService.getIsFromFilmInfo().subscribe((isFromFilmInfo: boolean) => {
      this.isFromFilmInfo = isFromFilmInfo;
    })
  }

}
