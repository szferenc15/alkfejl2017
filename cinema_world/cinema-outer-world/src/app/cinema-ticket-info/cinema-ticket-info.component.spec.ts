import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CinemaTicketInfoComponent } from './cinema-ticket-info.component';

describe('CinemaTicketInfoComponent', () => {
  let component: CinemaTicketInfoComponent;
  let fixture: ComponentFixture<CinemaTicketInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CinemaTicketInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CinemaTicketInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
