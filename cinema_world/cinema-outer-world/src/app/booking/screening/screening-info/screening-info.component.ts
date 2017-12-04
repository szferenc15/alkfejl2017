import { ScreeningInfo, ScreeningInfoDatabase } from './screening-info.database';
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

  private _filteredScreenings = [];

  screeningInfoColumns = [
    'synchron', 'inscriptive','twoDimensional',
    'threeDimensional', 'fourDimensional',
    'imax', 'screenDay', 'screenTime', 'booking'
  ];

  screeningInfoDataSource: MatTableDataSource<ScreeningInfo> | null;

  constructor() { }

  ngOnInit() {
    this.screeningInfoDataSource = new MatTableDataSource<ScreeningInfo>(this._filteredScreenings);
  }

  ngAfterViewInit() {
    this.screeningInfoDataSource.sort = this.screeningInfoSort;
  }

  get filteredScreenings(): ScreeningInfo[] {
    return this._filteredScreenings;
  }

  @Input()
  set filteredScreenings(newFilteredScreenings: ScreeningInfo[]) {
    this._filteredScreenings = newFilteredScreenings;
  }
}
