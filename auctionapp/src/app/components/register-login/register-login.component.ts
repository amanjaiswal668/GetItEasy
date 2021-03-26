import { Component, Injectable, OnInit } from '@angular/core';
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

  credentials={
    username:'',
    password:''
  }

  constructor(private service:LoginService) { }

  ngOnInit(): void {
  }

  onSubmitLogin(){
    if(this.credentials.password!='' && this.credentials.username!='' && (this.credentials.password!=null && this.credentials.username!=null)){
      this.service.doLogin(this.credentials).subscribe(
        (response:any)=>{
            console.log(response.token);
            this.service.loginUser(response.token)
            // window.location.href="/dashboard"
            
            window.location.href="/userallproduct"
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
    if(this.credentials.password!='' && this.credentials.username!='' && (this.credentials.password!=null && this.credentials.username!=null)){
      this.service.doLogin(this.credentials).subscribe(
        (response:any)=>{
            console.log(response.token);
            this.service.loginUser(response.token)
            window.location.href="/dashboard"
        },
        error=>{
          console.log(error)
        }
      )
    }else{
      console.log("Fields are empty !!!")
    }
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
