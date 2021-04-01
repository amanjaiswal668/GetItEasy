import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-admin-login-register',
  templateUrl: './admin-login-register.component.html',
  styleUrls: ['./admin-login-register.component.css']
})
export class AdminLoginRegisterComponent implements OnInit {

  user !: User;

  constructor(private loginService : LoginService) { }

  ngOnInit(): void {
  }
  onSubmitSignUp(){
    this.user.type='ADMIN';
    this.loginService.doSignup(this.user).subscribe(
      (response:any)=>{  
        window.location.href="/login"
    },
  )
  }

}
