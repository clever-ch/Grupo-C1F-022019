import { TestBed } from '@angular/core/testing';

import { MenuScoreService } from './menu-score.service';

describe('MenuScoreService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MenuScoreService = TestBed.get(MenuScoreService);
    expect(service).toBeTruthy();
  });
});
