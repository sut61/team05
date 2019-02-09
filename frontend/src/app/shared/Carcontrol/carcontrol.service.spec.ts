import { TestBed } from '@angular/core/testing';

import { CarcontrolService } from './carcontrol.service';

describe('CarcontrolService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CarcontrolService = TestBed.get(CarcontrolService);
    expect(service).toBeTruthy();
  });
});
