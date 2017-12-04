import { FilmInfo, FilmInfoDatabase } from './../film-info.database';
import { MatTableDataSource } from '@angular/material/table';
import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material';

@Component({
  selector: 'app-film-info',
  templateUrl: './film-info.component.html',
  styleUrls: ['./film-info.component.css']
})
export class FilmInfoComponent implements OnInit, AfterViewInit {
  @Input() selectedCinema = '';
  @Input() showFilms = false;

  @ViewChild(MatSort) ticketInfoSort: MatSort;

  filmInfoColumns = [
    'title', 'language', 'playTime', 'premiere',
    'ageLimit', 'directorFirstName', 'directorLastName',
    'country', 'year', 'rate', 'booking'
  ];

  filmInfoDataSource: MatTableDataSource<FilmInfo> | null;
  filmInfoDatabase: FilmInfoDatabase = new FilmInfoDatabase();

  constructor() { }

  ngOnInit() {
    this.filmInfoDataSource = new MatTableDataSource<FilmInfo>(this.filmInfoDatabase.getData());
  }

  ngAfterViewInit() {
    this.filmInfoDataSource.sort = this.ticketInfoSort;
  }

}
