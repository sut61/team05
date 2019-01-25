import { TestBed, inject } from '@angular/core/testing';

import { RepairinfoService } from './repairinfo.service';

describe('RepairinfoService', () => {
    beforeEach(() => {
      TestBed.configureTestingModule({
        providers: [RepairinfoService]
      });
    });
  
    it('should be created', inject([RepairinfoService], (service: RepairinfoService) => {
      expect(service).toBeTruthy();
    }));
  });