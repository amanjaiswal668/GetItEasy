import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../model/login-request';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:8000/auth"

  constructor(private http : HttpClient) { }

  doLogin(login:LoginRequest){
    return this.http.post(`${this.url}/login`,login)
  }

  doSignup(user:User){
    return this.http.post(`${this.url}/signup`,user)
  }

  loginUser(token: string){
    localStorage.setItem("token",token);
    return true;
  }

  isLoggedIn(){
   let token = localStorage.getItem("token");
   if(token==undefined || token =='' || token == null){
     return false;
   }else{
     return true;
   }
  }

   logout(){
     localStorage.removeItem('token');
     localStorage.removeItem('name');
     return true;
   }

   getToken(){
    return localStorage.getItem('token')
  }
}

