import { BookingService } from './../../../services/booking.service';
import { Screening } from './../../../interfaces/screening.interface';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material';
import { Component, OnInit, ViewChild, AfterViewInit, Input } from '@angular/core';

@Component({
  selector: 'app-screening-info',
  templateUrl: './screening-info.component.html',
  styleUrls: ['./screening-info.component.css']
})
export class ScreeningInfoComponent implements OnInit, AfterViewInit {
  @ViewChild(MatSort) screeningInfoSort: MatSort;

  private _filteredScreenings: Screening[] = [];

  screeningColumns = [
    'synchron', 'inscriptive','twoDimensional',
    'threeDimensional', 'fourDimensional',
    'imax', 'screenDay', 'screenTime', 'booking'
  ];

  screeningDataSource: MatTableDataSource<Screening> = null;

  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    this.screeningDataSource = new MatTableDataSource<Screening>(this._filteredScreenings);
  }

  ngAfterViewInit() {
    this.screeningDataSource.sort = this.screeningInfoSort;
  }

  get filteredScreenings(): Screening[] {
    return this._filteredScreenings;
  }

  @Input()
  set filteredScreenings(newFilteredScreenings: Screening[]) {
    this._filteredScreenings = newFilteredScreenings;
  }

  setSecondStageInfoOfBooking(screening: Screening) {
    this.bookingService.setSecondStageInfoOfBooking(screening);
  }
}
