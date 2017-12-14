import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class TicketService {
  constructor(private http: Http) {}

  updateTicket(type: string, price: number) {
    let updatePromise = this.http.patch('http://localhost:8080/world/ticket/update?type=' + type + '&price=' + price).toPromise()

    updatePromise.then((response: Response)=> {
      return response.json();
    })
  }
}
