import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material';
import { CinemaInfoDatabase, CinemaInfo } from './cinema-info.database';
import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FilmInfoDatabase, FilmInfo } from './film-info.database';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {
  filmInfoColumns = [
    'title', 'language', 'playTime', 'premiere',
    'ageLimit', 'directorFirstName', 'directorLastName',
    'country', 'year', 'rate', 'booking'
  ];

  filmInfoDataSource: MatTableDataSource<FilmInfo> | null;
  filmInfoDatabase: FilmInfoDatabase = new FilmInfoDatabase();

  @ViewChild(MatSort) ticketInfoSort: MatSort;

  cinemaInfoDatabase: CinemaInfoDatabase = new CinemaInfoDatabase();
  cinemaInfos: CinemaInfo[] = [];

  showCinemas = false;
  showFilms = false;

  selectedCinema = '';

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

  constructor() { }

  ngOnInit() {
    this.filmInfoDataSource = new MatTableDataSource<FilmInfo>(this.filmInfoDatabase.getData());

    this.cinemaInfos = this.cinemaInfoDatabase.getData();
    this.lastFilteredCinemaInfo = this.cinemaInfos;
  }

  ngAfterViewInit() {
    this.filmInfoDataSource.sort = this.ticketInfoSort;
  }

  setFormToDefault() {
    this.showCinemas = false;
    this.showFilms = false;
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

  cinemaSearchSubmit() {
    this.showCinemas = true;
    this.showFilms = false;
  }

  getActualFilmsOfCinema(cinemaName: string) {
    this.selectedCinema = cinemaName;
    this.showFilms = true;
  }
}
