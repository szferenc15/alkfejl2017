import { Time } from '@angular/common/src/i18n/locale_data_api';
import { Subscription } from 'rxjs/Subscription';
import { ScreeningService } from './../../services/screening.service';
import { Screening } from './../../interfaces/screening.interface';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material';
import { FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit, ViewChild, Input } from '@angular/core';

@Component({
  selector: 'app-screening',
  templateUrl: './screening.component.html',
  styleUrls: ['./screening.component.css']
})
export class ScreeningComponent implements OnInit {

  showScreeningTable: boolean = false;
  loaded: boolean = false;

  selectedCinema = '';

  synchrons = [];
  dimensions = [];

  screeningsFilteredOfLanguageType: Screening[] = [];
  screeningsFilteredOfDimension: Screening[] = [];
  screeningsFilteredOfScreenDay: Screening[] = [];
  screeningsFilteredOfScreenTime: Screening[] = [];
  filteredScreenings: Screening[] = [];
  screenings: Screening[] = [];

  screeningSubscription: Subscription;

  screeningSearchForm = new FormGroup({
    isSynchron: new FormControl(),
    dimension: new FormControl({value: '', disabled: true}),
    screeningDay: new FormControl({value: '', disabled: true}),
    screeningTime: new FormControl({value: '', disabled: true})
  });

  constructor(private screeningService: ScreeningService) { }

  ngOnInit() {
    this.screeningSubscription = this.screeningService.getScreenings().subscribe((screening: Screening[]) => {
      this.screenings = screening;

      this.filteredScreenings.forEach((screening) => {
        if (!this.synchrons.includes('Szinkronos') && screening.synchron) {
          this.synchrons.push('Szinkronos');
        } else if (!this.synchrons.includes('Feliratos') && screening.inscriptive) {
          this.synchrons.push('Feliratos');
        } else if (this.synchrons.includes('Szinkronos') &&
                   this.synchrons.includes('Feliratos')) {
          return;
        }
      })

      this.loaded = true;
    })
  }

  setFormToDefault(setDefaultUntil: number) {
    switch (setDefaultUntil) {
      case 3:
        this.screeningSearchForm.get('dimension').disable();
        this.screeningSearchForm.get('dimension').reset();
        this.screeningSearchForm.get('screeningDay').disable();
        this.screeningSearchForm.get('screeningDay').reset();
        this.screeningSearchForm.get('screeningTime').disable();
        this.screeningSearchForm.get('screeningTime').reset();
        this.filteredScreenings = this.screenings;
        this.showScreeningTable = false;
        this.dimensions = [];
        break;
      case 2:
        this.screeningSearchForm.get('screeningDay').disable();
        this.screeningSearchForm.get('screeningDay').reset();
        this.screeningSearchForm.get('screeningTime').disable();
        this.screeningSearchForm.get('screeningTime').reset();
        this.filteredScreenings = this.screeningsFilteredOfDimension;
        this.showScreeningTable = false;
        break;
      case 1:
        this.screeningSearchForm.get('screeningTime').disable();
        this.screeningSearchForm.get('screeningTime').reset();
        this.filteredScreenings = this.screeningsFilteredOfScreenDay;
        this.showScreeningTable = false;
        break;
    }
  }

  setScreeningsFilteredOfLanguageType(languageType: string) {
    this.setFormToDefault(3);
    this.screeningsFilteredOfLanguageType = this.screenings.slice().filter((screening) => {
      if (languageType === 'Szinkronos') {
        if (screening.synchron) {return screening}
      } else if (languageType === 'Feliratos') {
        if (screening.inscriptive) {return screening}
      }
    });

    this.screeningsFilteredOfLanguageType.forEach((screening) => {
      if (!this.dimensions.includes('2D') && screening.twoDimensional) {
        this.dimensions.push('2D');
      } else if (!this.dimensions.includes('3D') && screening.threeDimensional) {
        this.dimensions.push('3D');
      } else if (!this.dimensions.includes('4D') && screening.fourDimensional) {
        this.dimensions.push('4D');
      } else if (this.dimensions.includes('2D') &&
                 this.dimensions.includes('3D') &&
                 this.dimensions.includes('4D')) {
        return;
      }
    })

    this.screeningSearchForm.get('dimension').enable();
    this.filteredScreenings = this.screeningsFilteredOfLanguageType;
  }

  setScreeningsFilteredOfDimension(dimension: string) {
    this.setFormToDefault(2);
    this.screeningsFilteredOfDimension = this.screeningsFilteredOfLanguageType.filter((screening) => {
      switch (dimension){
        case '2D':
          if (screening.twoDimensional) {return screening}
          break;
        case '3D':
          if (screening.threeDimensional) {return screening}
          break;
        case '4D':
          if (screening.fourDimensional) {return screening}
          break;
      }
    });

    this.screeningSearchForm.get('screeningDay').enable();
    this.filteredScreenings = this.screeningsFilteredOfDimension;
  }

  setScreeningsFilteredOfScreenDay(screenDay: Date) {
    this.setFormToDefault(1);
    this.screeningsFilteredOfScreenDay = this.screeningsFilteredOfDimension.filter((screening) => {
      if (screenDay.toDateString() === screening.screenDay.toDateString()) {return screening}
    });
    this.screeningSearchForm.get('screeningTime').enable();
    this.filteredScreenings = this.screeningsFilteredOfScreenDay;
  }

  setScreeningsFilteredOfScreenTime(screenTime: Time) {
    this.screeningsFilteredOfScreenTime = this.screeningsFilteredOfScreenDay.filter((screening) => {
      if (screenTime === screening.screenTime) {return screening}
    });
    this.filteredScreenings = this.screeningsFilteredOfScreenTime;
  }

  screeningSearchSubmit() {
    this.showScreeningTable = true;
  }
}
