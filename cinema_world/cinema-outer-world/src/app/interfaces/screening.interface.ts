import { Time } from '@angular/common';

export interface Ticket {
  ticket: {
    type: string;
    price: number;
  }
}

export interface Screening {
  twoDimensional?: boolean;
  threeDimensional?: boolean;
  fourDimensional?: boolean;
  language?: string;
  synchron?: boolean;
  inscriptive?: boolean;
  screenDay?: Date;
  screenTime?: Time;
  availableTickets?: Ticket[];
}
