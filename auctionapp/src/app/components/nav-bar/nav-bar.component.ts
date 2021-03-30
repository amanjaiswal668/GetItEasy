import { Component, Injectable, OnInit } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/product';
import { BiddinService } from 'src/app/services/biddin.service';
import { LoginService } from 'src/app/services/login.service';
import { ProductlistComponent } from '../productlist/productlist.component';
import {FormBuilder,FormGroup} from '@angular/forms'
import { ProductService } from 'src/app/services/product.service';

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
  product : Product = new Product();
  fileToUpload !: File
  message : any
 
  constructor(private loginService : LoginService,private router : Router, private biddingService : BiddinService,private productService : ProductService) { }


  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
  }

  logoutUser(){
    this.loginService.logout()
    localStorage.removeItem("name")
    location.reload()
  }

  onFileSelected(event : any){
    this.fileToUpload = event.target.files[0]
  }

  createProduct(){
    this.productService.createProduct(this.product).subscribe((data) => {
      this.productService.uploadImage(this.fileToUpload,data.productId).subscribe((data)=> this.message = data)
    },
    (error)=> {this.message = error})
  }

 
}
