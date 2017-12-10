import { Chair } from './../../interfaces/booking-ticket.interface';
import { BookingService } from './../../services/booking.service';
import { Component, ElementRef, OnInit, Renderer } from '@angular/core';

@Component({
  selector: 'app-room-structure',
  templateUrl: './room-structure.component.html',
  styleUrls: ['./room-structure.component.css']
})
export class RoomStructureComponent implements OnInit {

  roomDimension = {rows: 10, columns: 30};
  rows = [];
  columns = [];
  selectedChairs: Chair[] = []
  selectedTicketsCount = null;
  occupiedChairs: Chair[] = [];
  selectedScreeningId: number = null;

  constructor(private renderer: Renderer,
              private bookingService: BookingService) { }

  ngOnInit() {
    this.rows = Array(this.roomDimension.rows).fill(0).map((x,i)=>i + 1);
    this.columns = Array(this.roomDimension.columns).fill(0).map((x,i)=>i + 1);

    this.bookingService.getSelectedTicketsCount().subscribe((count: number) => {
      this.selectedTicketsCount = count;
    })

    this.bookingService.getSelectedScreeningId().subscribe((screeningId: number) => {
      this.selectedScreeningId = screeningId;
      this.bookingService.getOccupiedChairs(this.selectedScreeningId.toString()).subscribe((occupiedChairs: Chair[]) => {
        this.occupiedChairs = occupiedChairs;
      })
    });
  }

  selectChair(row: number, column: number, charBtn: ElementRef) {
    let index = this.getSelectedChairIndex(row, column);
    if (index === -1) {
      if (this.selectedTicketsCount > 0) {
        this.selectedChairs.push({row: row, chair: column});
        this.bookingService.getSelectedTicketsCount().next(--this.selectedTicketsCount);
        this.renderer.setElementClass(charBtn['_elementRef'].nativeElement,"selected-chair",true);
      }
    } else if (index > -1 && this.selectedChairs.length > 0) {
      this.selectedChairs.splice(index, 1);
      this.bookingService.getSelectedTicketsCount().next(++this.selectedTicketsCount);
      this.renderer.setElementClass(charBtn['_elementRef'].nativeElement,"selected-chair",false);
    }
  }

  getSelectedChairIndex(row: number, column: number) {
    let index = -1;
    for(let i = 0; i < this.selectedChairs.length; i++) {
        if (this.selectedChairs[i].row === row && this.selectedChairs[i].chair === column) {
            index = i;
            break;
        }
    }

    return index;
  }

  isFree(row: number, column: number) {
    if (this.occupiedChairs.length > 0) {
      for (let i = 0; i < this.occupiedChairs.length; i++) {
        if (this.occupiedChairs[i].row == row && this.occupiedChairs[i].chair == column) {
          return false;
        }
      }
      return true;
    } else {
      return true;
    }
  }

  saveBookingInDatabase() {
    this.bookingService.saveBookingInDatabase(this.selectedChairs);
  }
}
