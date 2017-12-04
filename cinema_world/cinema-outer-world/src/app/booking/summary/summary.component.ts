import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  goBackToHomePage() {
    this.router.navigateByUrl('/home');
  }

}
