import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'auctionapp';


  public loggedIn = false;

  constructor(private loginService: LoginService,private router:Router) { }

  

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
  }

  isRegister(){
    return this.router.url === '/register';
  }

  isLogin(){
    return this.router.url === '/login';
  }
}
