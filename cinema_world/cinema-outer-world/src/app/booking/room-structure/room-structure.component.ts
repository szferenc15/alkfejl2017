import { Component, ElementRef, OnInit, Renderer } from '@angular/core';

@Component({
  selector: 'app-room-structure',
  templateUrl: './room-structure.component.html',
  styleUrls: ['./room-structure.component.css']
})
export class RoomStructureComponent implements OnInit {

  roomDimension = {rows: 5, columns: 19};
  rows = [];
  columns = [];
  selectedChairs = []

  constructor(private renderer: Renderer) { }

  ngOnInit() {
    this.rows = Array(this.roomDimension.rows).fill(0).map((x,i)=>i + 1);
    this.columns = Array(this.roomDimension.columns).fill(0).map((x,i)=>i + 1);
  }

  selectChair(row: number, column: number, charBtn: ElementRef) {
    let index = this.getSelectedChairIndex(row, column);
    if (index === -1) {
      this.selectedChairs.push({row: row, column: column});
      this.renderer.setElementClass(charBtn['_elementRef'].nativeElement,"selected-chair",true);
    } else {
      this.selectedChairs.splice(index, 1);
      this.renderer.setElementClass(charBtn['_elementRef'].nativeElement,"selected-chair",false);
    }
  }

  getSelectedChairIndex(row: number, column: number) {
    let index = -1;
    for(let i = 0; i < this.selectedChairs.length; i++) {
        if (this.selectedChairs[i].row === row && this.selectedChairs[i].column === column) {
            index = i;
            break;
        }
    }

    return index;
  }
}
