import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  rate = [];

  films = [
    {link: '../../assets/thor_ragnarok.jpg', name: 'Thor: Ragnarök', rate: 8},
    {link: '../../assets/star_wars_the_last_jedi.jpg', name: 'Star Wars: Az utolsó Jedik', rate: 10},
    {link: '../../assets/jungle.jpg', name: 'Dzsungel', rate: 9},
  ];
  constructor() {
    this.rate = Array(this.films[0].rate - 1).fill(0).map((x,i)=>i);
  }

  ngOnInit() {
  }

}
