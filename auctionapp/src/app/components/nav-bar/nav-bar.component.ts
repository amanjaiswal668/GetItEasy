import { Component, Injectable, OnInit } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/product';
import { BiddinService } from 'src/app/services/biddin.service';
import { LoginService } from 'src/app/services/login.service';
import { ProductlistComponent } from '../productlist/productlist.component';

@Injectable({
  providedIn: 'root'

})

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public loggedIn=false;
  name = localStorage.getItem('name');
  type = localStorage.getItem('type');
 
  

  constructor(private loginService : LoginService,private router : Router, private biddingService : BiddinService,private productList:ProductlistComponent) { }


  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
  }

  logoutUser(){
    this.loginService.logout()
    localStorage.removeItem("name")
    location.reload()
  }

  getBiddedProducts(){
    
//    this.biddingService.getBuyerBiddedProducts().subscribe((data) => this.products = data);
  this.productList.getMyBiddedProducts();
  }
 
}
