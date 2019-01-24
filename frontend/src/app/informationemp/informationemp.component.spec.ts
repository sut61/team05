import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InformationempComponent } from './informationemp.component';

describe('InformationempComponent', () => {
  let component: InformationempComponent;
  let fixture: ComponentFixture<InformationempComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InformationempComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InformationempComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
