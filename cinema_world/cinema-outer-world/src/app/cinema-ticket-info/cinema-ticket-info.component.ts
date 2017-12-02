import { FormControl, FormGroup } from '@angular/forms';
import { CinemaInfoDatabase, CinemaInfo } from './cinema-info.database';
import { MatTableDataSource } from '@angular/material/table';
import { TicketInfoDatabase, TicketInfo } from './ticket-info.database';
import { Observable } from 'rxjs/Rx';
import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material';

@Component({
  selector: 'app-cinema-ticket-info',
  templateUrl: './cinema-ticket-info.component.html',
  styleUrls: ['./cinema-ticket-info.component.css']
})
export class CinemaTicketInfoComponent implements OnInit, AfterViewInit {
  ticketInfoColumns = ['type', 'twoDimensionalPrice', 'imaxPrice',
                       'imaxGlassPrice', 'threeDimensionalPrice', 'threeDimensionalGlassPrice',
                       'fourDimensionalPrice', 'fourDimensionalGlassPrice', 'bedRoomPrice',
                       'bedRoomGlassPrice'];
  ticketInfoDataSource: MatTableDataSource<TicketInfo> | null;
  ticketInfoDatabase: TicketInfoDatabase = new TicketInfoDatabase();
  cinemaInfoDatabase: CinemaInfoDatabase = new CinemaInfoDatabase();
  cinemaInfos: CinemaInfo[] = [];

  showCinemas = false;
  countrySelected = false;
  citySelected = false;
  districtSelected = false;
  cinemaSelected = false;

  filteredCinemaCities = [];
  filteredCinemaDistricts = [];
  filteredCinemaNames = [];

  lastFilteredCinemaInfo = [];

  cinemaSearchForm = new FormGroup({
    country: new FormControl(),
    city: new FormControl({value: '', disabled: true}),
    district: new FormControl({value: '', disabled: true}),
    name: new FormControl({value: '', disabled: true})
  });

  @ViewChild(MatSort) ticketInfoSort: MatSort;

  constructor() {}

  ngOnInit() {
    this.ticketInfoDataSource = new MatTableDataSource<TicketInfo>(this.ticketInfoDatabase.getData());
    this.cinemaInfos = this.cinemaInfoDatabase.getData();
    this.lastFilteredCinemaInfo = this.cinemaInfos;
  }

  ngAfterViewInit() {
    this.ticketInfoDataSource.sort = this.ticketInfoSort;
  }

  setFormToDefault() {
    this.showCinemas = false;
    this.cinemaSearchForm.reset();
    this.cinemaSearchForm.get('city').disable();
    this.cinemaSearchForm.get('district').disable();
    this.cinemaSearchForm.get('name').disable();
    this.lastFilteredCinemaInfo = this.cinemaInfos;
  }

  setFilteredCinemaCities(cinemaCountry: string) {
    this.filteredCinemaCities = this.cinemaInfos.filter((cinema) => {
      if (cinemaCountry === cinema.country) {return cinema}
    });
    this.cinemaSearchForm.get('city').enable();
    this.lastFilteredCinemaInfo = this.filteredCinemaCities;
  }

  setFilteredCinemaDistricts(cinemaCity: string) {
    this.filteredCinemaDistricts = this.filteredCinemaCities.filter((cinema) => {
      if (cinemaCity === cinema.city) {return cinema}
    });
    this.cinemaSearchForm.get('district').enable();
    this.lastFilteredCinemaInfo = this.filteredCinemaDistricts;
  }

  setFilteredCinemaNames(cinemaDistricts: string) {
    this.filteredCinemaNames = this.filteredCinemaDistricts.filter((cinema) => {
      if (cinemaDistricts === cinema.district) {return cinema}
    });
    this.cinemaSearchForm.get('name').enable();
    this.lastFilteredCinemaInfo = this.filteredCinemaNames;
  }
}
