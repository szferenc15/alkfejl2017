import { Film } from './../../interfaces/film.interface';
import { FilmService } from './../../services/film.service';
import { Subscription } from 'rxjs/Subscription';
import { FilmInfo, FilmInfoDatabase } from './../film-info.database';
import { MatTableDataSource } from '@angular/material/table';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material';

@Component({
  selector: 'app-film-info',
  templateUrl: './film-info.component.html',
  styleUrls: ['./film-info.component.css']
})
export class FilmInfoComponent implements OnInit {
  @Input() selectedCinema = '';
  @Input() showFilms = false;

  @ViewChild(MatSort) filmSort: MatSort;

  filmColumns = [
    'title', 'language', 'playTime', 'premiere',
    'ageLimit', 'directorFirstName', 'directorLastName',
    'country', 'year', 'rate', 'booking'
  ];

  filmDataSource: MatTableDataSource<Film> = null;
  films: Film[] = null;

  loaded: boolean = false;

  filmSubscription: Subscription;

  constructor(private filmService: FilmService) { }

  ngOnInit() {
    this.filmSubscription = this.filmService.getFilms().subscribe((films: Film[]) => {
      this.filmDataSource = new MatTableDataSource<Film>(films);
      this.filmDataSource.sort = this.filmSort;
      this.loaded = true;
    })
  }
}
