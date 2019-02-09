import { TestBed, inject } from '@angular/core/testing';
import { BounceService } from './bounce.service';

describe('BounceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BounceService]
    });
  });

  it('should be created', inject([BounceService], (service: BounceService) => {
    expect(service).toBeTruthy();
  }));
});
