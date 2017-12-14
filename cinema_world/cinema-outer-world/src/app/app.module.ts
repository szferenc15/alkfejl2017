import { TicketService } from './services/ticket.service';
import { RegisterService } from './services/register.service';
import { BookingService } from './services/booking.service';
import { TimePipe } from './pipes/time.pipe';
import { ScreeningService } from './services/screening.service';
import { CinemaService } from './services/cinema.service';
import { HttpModule } from '@angular/http';
import { TicketPaymentInfoComponent } from './booking/ticket-payment-info/ticket-payment-info.component';
import { ScreeningComponent } from './booking/screening/screening.component';
import { ScreeningInfoComponent } from './booking/screening/screening-info/screening-info.component';
import { UniqueFilter } from './pipes/unique-filter.pipe';
import { LogicalTransform } from './pipes/logical-transform.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

import { FilmService } from './services/film.service';

import { RouterModule, Routes } from '@angular/router';
import { CinemaTicketInfoComponent } from './cinema-ticket-info/cinema-ticket-info.component';
import { FilmComponent } from './film/film.component';
import { AwardsComponent } from './awards/awards.component';
import { SweepstakesComponent } from './sweepstakes/sweepstakes.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { BookingComponent } from './booking/booking.component';
import { FilmInfoComponent } from './film/film-info/film-info.component';
import { RoomStructureComponent } from './booking/room-structure/room-structure.component';
import { SummaryComponent } from './booking/summary/summary.component';
import { ProfileComponent } from './profile/profile.component';
import { AuthenticationService } from "./services/authentication.service";
import { CanActivateViaAuthGuard } from "./route-guards/authentication.guard";

import { MatButtonModule, MatSortModule,
         MatTableModule, MatSlideToggleModule,
         MatAutocompleteModule, MatFormFieldModule,
         MatInputModule, MatCardModule,
         MatListModule, MatSelectModule,
         MatDialogModule, MatCheckboxModule,
         MatStepperModule, MatDatepickerModule } from '@angular/material';
import { CdkTableModule } from '@angular/cdk/table';
import { BookingInfoComponent } from './booking/booking-info/booking-info.component';
import { AdminComponent } from './profile/admin/admin.component';


const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'cinema-ticket-info', component: CinemaTicketInfoComponent },
  { path: 'films', component: FilmComponent },
  { path: 'sweepstakes', component: SweepstakesComponent },
  { path: 'awards', component: AwardsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'booking', component: BookingComponent, canActivate: [CanActivateViaAuthGuard]},
  { path: 'profile', component: ProfileComponent, canActivate: [CanActivateViaAuthGuard] },
  { path: 'booking', component: BookingComponent},
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
    HomeComponent,
    BookingComponent,
    FilmInfoComponent,
    LogicalTransform,
    UniqueFilter,
    TimePipe,
    ScreeningComponent,
    ScreeningInfoComponent,
    TicketPaymentInfoComponent,
    RoomStructureComponent,
    SummaryComponent,
    ProfileComponent,
    BookingInfoComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    MatTableModule,
    MatSortModule,
    CdkTableModule,
    MatSlideToggleModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatListModule,
    MatSelectModule,
    MatDialogModule,
    MatCheckboxModule,
    MatStepperModule,
    MatDatepickerModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AuthenticationService,
              CanActivateViaAuthGuard,
              FilmService,
              CinemaService,
              ScreeningService,
              BookingService,
              RegisterService,
              TicketService],
  bootstrap: [AppComponent]
})
export class AppModule { }
