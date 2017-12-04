import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketPaymentInfoComponent } from './ticket-payment-info.component';

describe('TicketPaymentInfoComponent', () => {
  let component: TicketPaymentInfoComponent;
  let fixture: ComponentFixture<TicketPaymentInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketPaymentInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketPaymentInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
