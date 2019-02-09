import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarcontrolComponent } from './carcontrol.component';

describe('CarcontrolComponent', () => {
  let component: CarcontrolComponent;
  let fixture: ComponentFixture<CarcontrolComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarcontrolComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarcontrolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
