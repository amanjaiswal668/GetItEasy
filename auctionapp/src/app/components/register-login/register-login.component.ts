import { Component, Injectable, OnInit } from '@angular/core';
import { LoginRequest } from 'src/app/model/login-request';
import { User } from 'src/app/model/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-register-login',
  templateUrl: './register-login.component.html',
  styleUrls: ['./register-login.component.css']
})


@Injectable({
  providedIn: 'root'
})

export class RegisterLoginComponent implements OnInit {

  message=""

  login: LoginRequest = new LoginRequest;
  user : User = new User;
  

  constructor(private service:LoginService) { }

  ngOnInit(): void {
  }

  onSubmitLogin(){
    if(this.login.password!='' && this.login.username!='' && (this.login.password!=null && this.login.username!=null)){
      this.service.doLogin(this.login).subscribe(
        (response:any)=>{
            console.log(response.token);
            this.service.loginUser(response.token)
            if (response.type === 'SELLER') {
              window.location.href="/seller"
            } else if (response.type === 'BUYER') {
              window.location.href="/buyer"
            } else if (response.type === 'ADMIN') {
              window.location.href="/admin"
            } else { 

            }
           
        },
        error=>{
          this.message = "Username Or Password Incorrect !!!"
          console.log(error)
        }
      )
    }else{
      this.message="Fields are empty !!!";
      console.log("Fields are empty !!!")
    }
  }

  onSubmitSignUp(){
    console.log(this.user.type)
    this.service.doSignup(this.user).subscribe(
      (response:any)=>{  
        //window.location.href="/login"
    },
    error=>{
      this.message = "Email is already registered"
      console.log(error)
    }
  )
  }


  public signUp() {

    const sign_in_btn = document.querySelector("#sign-in-btn");
    const sign_up_btn = document.querySelector("#sign-up-btn");
    const container = document.querySelector(".container");

    sign_up_btn?.addEventListener("click", () => {
      container?.classList.add("sign-up-mode");
    });

    sign_in_btn?.addEventListener("click", () => {
      container?.classList.remove("sign-up-mode");
    });
    
  }

}
