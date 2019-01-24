import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegDComponent } from './reg-d.component';

describe('RegDComponent', () => {
  let component: RegDComponent;
  let fixture: ComponentFixture<RegDComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegDComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
