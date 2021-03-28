import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/product';
import { LoginService } from 'src/app/services/login.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  type = localStorage.getItem('type');
  btnContainer: any;

  product: Product = new Product;
  products: Product[] = [];
  constructor(private http: HttpClient, private service: ProductService, private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {

    if (this.loginService.isLoggedIn() && this.type === 'SELLER') {

      this.service.getMyProducts().subscribe((data) => this.products = data);
      console.log("SELLER");
    }

    else if (this.loginService.isLoggedIn() && this.type === 'BUYER') {
      this.service.getMyProducts().subscribe((data) => this.products = data);
      console.log("BUYER");
    }

    else {
      this.service.getAllProducts().subscribe((data) => this.products = data);
      console.log("NO USER");
    }

  }

  // Fetching a particular product details from the Product array.
  public setProduct(p: Product) {
    this.product = p;
  }

  public homeProduct() {
    this.service.getAllProducts().subscribe((data) => this.products = data);
  }
}


