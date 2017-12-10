import { Subscription } from 'rxjs/Subscription';
import { BookingService } from './../../services/booking.service';
import { Ticket } from './../../interfaces/screening.interface';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-ticket-payment-info',
  templateUrl: './ticket-payment-info.component.html',
  styleUrls: ['./ticket-payment-info.component.css']
})
export class TicketPaymentInfoComponent implements OnInit, OnDestroy {

  availableTickets: Ticket[] = [];
  amenitiesCharge: number = null;

  ticketSubscription: Subscription;

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

  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    this.ticketSubscription = this.bookingService.getTicketsOfSelectedScreening().subscribe((availableTickets: Ticket[]) => {
      this.availableTickets = availableTickets;
      this.amenitiesCharge = this.bookingService.getAmenitiesChargeOfSelectedCinema();
    })
  }

  ngOnDestroy() {
    this.ticketSubscription.unsubscribe();
  }

  setSelectedPaymentMethod(paymentMethod) {
    this.selectedPaymentMethod = paymentMethod;
  }

}
