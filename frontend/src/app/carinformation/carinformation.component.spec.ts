import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarinformationComponent } from './carinformation.component';

describe('CarinformationComponent', () => {
  let component: CarinformationComponent;
  let fixture: ComponentFixture<CarinformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarinformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarinformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
