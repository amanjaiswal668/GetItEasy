import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminLoginRegisterComponent } from './admin-login-register.component';

describe('AdminLoginRegisterComponent', () => {
  let component: AdminLoginRegisterComponent;
  let fixture: ComponentFixture<AdminLoginRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminLoginRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminLoginRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
