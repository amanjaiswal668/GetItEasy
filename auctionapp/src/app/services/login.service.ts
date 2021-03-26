import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:8000/auth"

  constructor(private http : HttpClient) { }

  doLogin(credentials:any){
    return this.http.post(`${this.url}/login`,credentials)
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
     return true;
   }

   getToken(){
    return localStorage.getItem('token')
  }
}

