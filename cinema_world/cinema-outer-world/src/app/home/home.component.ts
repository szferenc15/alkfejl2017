import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  rate = [];
  activeElement = 0;
  activeFilmIndex = 0;
  activeTrailer = 0;
  activeFilm = 0;
  previousActiveElement = 0;
  url: SafeResourceUrl;

  films = [
    {
      id: 0,
      link: '../../assets/thor_ragnarok.jpg',
      name: 'Thor: Ragnarök',
      rate: 4,
      trailers: [
        'https://www.youtube.com/embed/v7MGUNV8MxU',
        'https://www.youtube.com/embed/ue80QwXMRHg'
      ],
      description: `Thor leírás.`
    },
    {
      id: 1,
      link: '../../assets/star_wars_the_last_jedi.jpg',
      name: 'Star Wars: Az utolsó Jedik',
      rate: 5,
      trailers: [
        'https://www.youtube.com/embed/zB4I68XVPzQ',
        'https://www.youtube.com/embed/Q0CbN8sfihY'
      ],
      description: `Star Wars leírás.`
    },
    {
      id: 2,
      link: '../../assets/jungle.jpg',
      name: 'Dzsungel',
      rate: 4,
      trailers: [
        'https://www.youtube.com/embed/RI_Iz3-88Fw',
        'https://www.youtube.com/embed/CJIYns1aqzY'
      ],
      description: `Dzsungel leírás.`
    },
    {
      id: 3,
      link: '../../assets/a_viszkis.jpg',
      name: 'A viszkis',
      rate: 3,
      trailers: [
        'https://www.youtube.com/embed/ia_RojiPK50',
        'https://www.youtube.com/embed/YYQa4lj8THM'
      ],
      description: `A viszkis leírás.`
    },
    {
      id: 4,
      link: '../../assets/justice_league.jpg',
      name: 'Az igazság ligája',
      rate: 2,
      trailers: [
        'https://www.youtube.com/embed/r9-DM9uBtVI',
        'https://www.youtube.com/embed/h-Nzxn9qiSg',
        'https://www.youtube.com/embed/JWTLdrIK4FI'
      ],
      description: `Az igazság ligája leírás.`
    },
  ];

  activeFilms = [
    this.films[this.activeFilmIndex],
    this.films[this.activeFilmIndex + 1],
    this.films[this.activeFilmIndex + 2]
  ];

  constructor(private sanitizer: DomSanitizer) {
    this.rate = Array(this.films[this.activeElement].rate - 1).fill(0).map((x,i)=>i);
    this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[0]);
  }

  ngOnInit() {
  }

  changeActiveElement(index: number) {
    if (index + this.activeFilmIndex != this.previousActiveElement) {
      this.activeElement = index + this.activeFilmIndex;
      this.activeFilm = index;
      this.rate = Array(this.films[this.activeElement].rate - 1).fill(0).map((x,i)=>i);
      this.activeTrailer = 0;
      this.previousActiveElement = this.activeElement;
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[0]);
    }
  }

  goUp() {
    if (this.activeFilmIndex > 0) {
      this.activeFilmIndex--;
      this.activeFilms.splice(this.activeFilms.length - 1, 1);
      this.activeFilms.unshift(this.films[this.activeFilmIndex]);
      this.activeFilm++;
    }
  }

  goDown() {
    if (this.activeFilmIndex < this.films.length - 3) {
      this.activeFilmIndex++;
      this.activeFilms.splice(0, 1);
      this.activeFilms.push(this.films[this.activeFilmIndex + 2]);
      this.activeFilm--;
    }
  }

  nextTrailer() {
    if (this.activeTrailer < this.films[this.activeElement].trailers.length - 1) {
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[++this.activeTrailer]);
    }
  }

  previousTrailer() {
    if (this.activeTrailer > 0) {
      this.url = this.sanitizer.bypassSecurityTrustResourceUrl(this.films[this.activeElement].trailers[--this.activeTrailer]);
    }
  }

  @HostListener('window:keydown', ['$event.key'])
  goUpOrDown(event_key: string) {
    switch (event_key) {
      case "s":
        if (this.activeFilm >= 2) {
          this.goDown();
        }
        if (this.activeFilm < this.films.length - 3) {
          this.activeFilm++;
          if (this.activeFilm < 0) {
            this.activeFilm = 0;
          }
          this.changeActiveElement(this.activeFilm);
        }
        return false;
      case "w":

        if (this.activeFilm < this.films.length - 4) {
          this.goUp();
        }
        if (this.activeFilm > 0) {
          this.activeFilm--;
          if (this.activeFilm > 2) {
            this.activeFilm = 2;
          }
          this.changeActiveElement(this.activeFilm);
        }
        return false;
      case "a":
        this.previousTrailer();
        return false;
      case "d":
        this.nextTrailer();
        return false;
      default:
        break;
    }
  }
}

/*
A Marvel Studios új filmjében Thort pörölyétől megfosztva bebörtönzik az univerzum túlsó felén.
    Az idővel versenyt futva próbál visszajutni Asgardba, és megállítani a Ragnarököt;
    egy háborút, ami otthonának pusztulásával és az asgardi civilizáció eltűnésével járhat,
    és amit egy mindenható új ellenség, a könyörtelen Hela idézett elő.
    Először azonban túl kell élnie egy halálos gladiátorviadalt,
    amelyben ellenfele korábbi szövetségese és szintén a Bosszúállók tagja: a hihetetlen Hulk!
*/
