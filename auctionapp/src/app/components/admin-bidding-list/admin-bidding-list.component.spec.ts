import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBiddingListComponent } from './admin-bidding-list.component';

describe('AdminBiddingListComponent', () => {
  let component: AdminBiddingListComponent;
  let fixture: ComponentFixture<AdminBiddingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminBiddingListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBiddingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
