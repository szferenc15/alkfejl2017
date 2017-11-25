import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SweepstakesComponent } from './sweepstakes.component';

describe('SweepstakesComponent', () => {
  let component: SweepstakesComponent;
  let fixture: ComponentFixture<SweepstakesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SweepstakesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SweepstakesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
