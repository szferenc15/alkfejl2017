import { BookingService } from './../services/booking.service';
import { CinemaService } from '../services/cinema.service';
import { Cinema } from './../interfaces/cinema.interface';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material';
import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { FilmInfoDatabase, FilmInfo } from './film-info.database';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  @Input() inStepper = false;

  showCinemas: boolean = false;
  showFilms: boolean = false;
  hasDistrict: boolean = true;
  loaded: boolean = false;

  selectedCinema: string = '';

  cinemas: Cinema[] = [];
  cinemasFilteredOfCountry: Cinema[] = [];
  cinemasFilteredOfCity: Cinema[] = [];
  cinemasFilteredOfDistrict: Cinema[] = [];
  cinemasFilteredOfName: Cinema[] = [];
  filteredCinemas: Cinema[] = [];

  cinemaSubscription: Subscription;

  cinemaSearchForm = new FormGroup({
    country: new FormControl(),
    city: new FormControl({value: '', disabled: true}),
    district: new FormControl({value: '', disabled: true}),
    name: new FormControl({value: '', disabled: true})
  });

  constructor(private cinemaService: CinemaService,
              private bookingService: BookingService) { }

  ngOnInit() {
    if (this.inStepper) {
      this.cinemaSubscription = this.bookingService.getCinemasOfSelectedFilm().subscribe((cinemas: Cinema[]) => {
        this.cinemas = cinemas;
        this.filteredCinemas = this.cinemas;
        this.loaded = true;
      })
    } else {
      this.cinemaSubscription = this.cinemaService.getCinemas().subscribe((cinema: Cinema[]) => {
        this.cinemas = cinema;
        this.filteredCinemas = this.cinemas;
        this.loaded = true;
      })
    }
  }

  ngOnDestroy() {
    this.cinemaSubscription.unsubscribe();
  }

  setFormToDefault(setDefaultUntil: number) {
    switch (setDefaultUntil) {
      case 3:
        this.cinemaSearchForm.get('city').disable();
        this.cinemaSearchForm.get('city').reset();
        this.cinemaSearchForm.get('district').disable();
        this.cinemaSearchForm.get('district').reset();
        this.cinemaSearchForm.get('name').disable();
        this.cinemaSearchForm.get('name').reset();
        this.filteredCinemas = this.cinemas;
        this.showCinemas = false;
        this.showFilms = false;
        break;
      case 2:
        this.cinemaSearchForm.get('district').disable();
        this.cinemaSearchForm.get('district').reset();
        this.cinemaSearchForm.get('name').disable();
        this.cinemaSearchForm.get('name').reset();
        this.filteredCinemas = this.cinemasFilteredOfCountry;
        this.showCinemas = false;
        this.showFilms = false;
        break;
      case 1:
        this.cinemaSearchForm.get('name').disable();
        this.cinemaSearchForm.get('name').reset();
        this.filteredCinemas = this.cinemasFilteredOfDistrict;
        this.showCinemas = false;
        this.showFilms = false;
        break;
    }
  }

  setCinemasFilteredOfCountry(cinemaCountry: string) {
    this.setFormToDefault(3);
    this.cinemasFilteredOfCountry = this.cinemas.slice().filter((cinema: Cinema) => {
      if (cinemaCountry === cinema.country) {return cinema}
    });
    this.cinemaSearchForm.get('city').enable();
    this.filteredCinemas = this.cinemasFilteredOfCountry;
  }

  setCinemasFilteredOfCity(cinemaCity: string) {
    this.setFormToDefault(2);
    this.cinemasFilteredOfCity = this.cinemasFilteredOfCountry.filter((cinema: Cinema) => {
      if (cinemaCity === cinema.city) {return cinema}
    });

    this.hasDistrict = this.cinemasFilteredOfCity[0].district != null && this.cinemasFilteredOfCity[0].district != '';
    if (this.hasDistrict) {
      this.cinemaSearchForm.get('district').enable();
    } else {
      this.cinemaSearchForm.get('name').enable();
    }
    this.filteredCinemas = this.cinemasFilteredOfCity;
  }

  setCinemasFilteredOfDistrict(cinemaDistrict: string) {
    this.setFormToDefault(1);
    this.cinemasFilteredOfDistrict = this.cinemasFilteredOfCity.filter((cinema: Cinema) => {
      if (cinemaDistrict === cinema.district) {return cinema}
    });
    this.cinemaSearchForm.get('name').enable();
    this.filteredCinemas = this.cinemasFilteredOfDistrict;
  }

  setCinemasFilteredOfName(cinemaName: string) {
    if (this.hasDistrict) {
      this.cinemasFilteredOfName = this.cinemasFilteredOfDistrict.filter((cinema: Cinema) => {
        if (cinemaName === cinema.name) {return cinema}
      });
    } else {
      this.cinemasFilteredOfName = this.cinemasFilteredOfCity.filter((cinema: Cinema) => {
        if (cinemaName === cinema.name) {return cinema}
      });
    }
    this.filteredCinemas = this.cinemasFilteredOfName;
  }

  cinemaSearchSubmit() {
    this.showCinemas = true;
  }

  getActualFilmsOfCinema(cinemaName: string) {
    this.selectedCinema = cinemaName;
    this.showFilms = true;
  }

  setFirstStageInfoOfBooking(cinema: Cinema) {
    this.bookingService.setFirstStageInfoOfBooking(cinema);
  }
}
