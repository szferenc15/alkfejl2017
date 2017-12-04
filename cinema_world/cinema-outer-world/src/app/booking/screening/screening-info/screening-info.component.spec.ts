import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScreeningInfoComponent } from './screening-info.component';

describe('ScreeningInfoComponent', () => {
  let component: ScreeningInfoComponent;
  let fixture: ComponentFixture<ScreeningInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScreeningInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScreeningInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
