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

  @ViewChild(MatSort) ticketInfoSort: MatSort;

  constructor() {}

  ngOnInit() {
    this.ticketInfoDataSource = new MatTableDataSource<TicketInfo>(this.ticketInfoDatabase.getData());
  }

  ngAfterViewInit() {
    this.ticketInfoDataSource.sort = this.ticketInfoSort;
  }
}
