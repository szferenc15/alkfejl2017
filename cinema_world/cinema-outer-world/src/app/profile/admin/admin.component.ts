import { TicketService } from './../../services/ticket.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  /*newFilmFormGroup = new FormGroup({
    title: new FormControl(null, [Validators.required]),
    picture: new FormControl(null, [Validators.required]),
    language: new FormControl(null, [Validators.required]),
    playTime: new FormControl(null, [Validators.required]),
    premiere: new FormControl(null, [Validators.required]),
    ageLimit: new FormControl(null, [Validators.required]),
    director_fname: new FormControl(null, [Validators.required]),
    director_lname: new FormControl(null, [Validators.required]),
    country: new FormControl(null, [Validators.required]),
    year: new FormControl(null, [Validators.required]),
    rate: new FormControl(null, [Validators.required]),
    description: new FormControl(null, [Validators.required]),
  });*/


  ticketUpdateGroup = new FormGroup({
    type: new FormControl(null, [Validators.required]),
    price: new FormControl(null, [Validators.required]),
  });

  constructor(private ticketService: TicketService) { }

  ngOnInit() {
  }

  updateTicket(type: string, price: number) {
    this.ticketService.updateTicket(type, price);
  }

}
