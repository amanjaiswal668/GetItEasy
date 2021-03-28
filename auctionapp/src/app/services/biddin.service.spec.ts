import { TestBed } from '@angular/core/testing';

import { BiddinService } from './biddin.service';

describe('BiddinService', () => {
  let service: BiddinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BiddinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
