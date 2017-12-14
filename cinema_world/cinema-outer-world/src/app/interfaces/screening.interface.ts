import { Booking } from './booking.interface';
import { Room } from './room.interface';
import { Time } from '@angular/common';

export interface Ticket {
  ticket: {
    type: string;
    price: number;
  }
}

export interface Screening {
  id?: number;
  twoDimensional?: boolean;
  threeDimensional?: boolean;
  fourDimensional?: boolean;
  imax?: boolean;
  language?: string;
  synchron?: boolean;
  inscriptive?: boolean;
  screenDay?: Date;
  screenTime?: Time;
  filmTitle?: string;
  roomId: Room;
  availableTickets?: Ticket[];
  bookings?: Booking[];
}
