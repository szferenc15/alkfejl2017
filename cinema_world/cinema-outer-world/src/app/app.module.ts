import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

import { RouterModule, Routes } from '@angular/router';
import { CinemaTicketInfoComponent } from './cinema-ticket-info/cinema-ticket-info.component';
import { FilmComponent } from './film/film.component';
import { AwardsComponent } from './awards/awards.component';
import { SweepstakesComponent } from './sweepstakes/sweepstakes.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';

import { MatButtonModule } from '@angular/material/button';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'cinema-ticket-info', component: CinemaTicketInfoComponent },
  { path: 'films', component: FilmComponent },
  { path: 'sweepstakes', component: SweepstakesComponent },
  { path: 'awards', component: AwardsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CinemaTicketInfoComponent,
    FilmComponent,
    SweepstakesComponent,
    AwardsComponent,
    LoginComponent,
    RegisterComponent,
    PageNotFoundComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
