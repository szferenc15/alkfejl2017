export interface Ticket {
  type: string;
  price: number;
}

export class TicketDatabase {
  private ticketDatabase: Ticket[] = [
    {
      type: 'Normal',
      price: 1760
    },
    {
      type: 'Diak',
      price: 1320
    },
    {
      type: 'Junior',
      price: 1320
    },
    {
      type: 'Szenior',
      price: 1320
    },
    {
      type: 'Fogy. elo',
      price: 1320
    }
  ];

  getData(): Ticket[] {
    return this.ticketDatabase.slice();
  }
}


