import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RepairinfoComponent } from './repairinfo.component';

describe('RepairinfoComponent', () => {
  let component: RepairinfoComponent;
  let fixture: ComponentFixture<RepairinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RepairinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RepairinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
