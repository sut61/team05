import { TestBed, inject } from '@angular/core/testing';

import { CommentService } from './comment.service';

describe('Comment', () => {
    beforeEach(() => {
      TestBed.configureTestingModule({
        providers: [Comment]
      });
    });

    it('should be created', inject([CommentService], (service: CommentService) => {
      expect(service).toBeTruthy();
    }));
  });
