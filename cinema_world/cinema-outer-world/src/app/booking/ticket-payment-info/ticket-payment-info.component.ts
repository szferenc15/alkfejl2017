import { Ticket, TicketDatabase } from './ticket-payment.database';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticket-payment-info',
  templateUrl: './ticket-payment-info.component.html',
  styleUrls: ['./ticket-payment-info.component.css']
})
export class TicketPaymentInfoComponent implements OnInit {

  availableTickets: Ticket[] = [];
  ticketInfoDatabase: TicketDatabase = new TicketDatabase();
  amenitiesCharge = 40;

  paymentMethods = [
    {name: 'PayPal', pictureUrl: '../../../assets/paypal.png'},
    {name: 'MasterCard', pictureUrl: '../../../assets/master_card.png'},
    {name: 'Maestro', pictureUrl: '../../../assets/maestro.png'},
    {name: 'VISA', pictureUrl: '../../../assets/visa.png'},
    {name: 'WESTERN UNION', pictureUrl: '../../../assets/western_union.jpg'},
    {name: 'SWITCH', pictureUrl: '../../../assets/switch.png'},
    {name: 'DELTA', pictureUrl: '../../../assets/delta.png'},
    {name: 'Cirrus', pictureUrl: '../../../assets/cirrus.png'}
  ];

  selectedPaymentMethod = {};

  constructor() { }

  ngOnInit() {
    this.availableTickets = this.ticketInfoDatabase.getData();
  }

  setSelectedPaymentMethod(paymentMethod) {
    this.selectedPaymentMethod = paymentMethod;
  }

}
