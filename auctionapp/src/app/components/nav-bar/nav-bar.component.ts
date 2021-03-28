import { Component, OnInit } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { LoginService } from 'src/app/services/login.service';
import { ProductlistComponent } from '../productlist/productlist.component';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public loggedIn=false;
  name = localStorage.getItem('name');
  type = localStorage.getItem('type');
  

  constructor(private loginService : LoginService) { }

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
  }

  logoutUser(){
    this.loginService.logout()
    location.reload()
  }
}
