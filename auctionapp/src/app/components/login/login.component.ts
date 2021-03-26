import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials={
    username:'',
    password:''
  }

  constructor(private service:LoginService) { }

  ngOnInit(): void {
  }

  onSubmit(){
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

}
