import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BiddingRequest } from 'src/app/Model/bidding-request';
import { Product } from 'src/app/Model/product';
import { BiddinService } from 'src/app/services/biddin.service';
import { LoginService } from 'src/app/services/login.service';
import { ProductService } from 'src/app/services/product.service';

@Injectable({
  providedIn: 'root'

})

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  type = localStorage.getItem('type');
  btnContainer: any;
  bidRequest: BiddingRequest = new BiddingRequest;
  message = "";

  product: Product = new Product;
  products: Product[] = [];

  constructor(private http: HttpClient, private service: ProductService, private router: Router, private loginService: LoginService, private biddingService: BiddinService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts() {
    if (this.loginService.isLoggedIn() && this.type === 'SELLER') {

      this.service.getMyProducts().subscribe((data) => this.products = data);
      console.log("SELLER");
    }

    else if (this.loginService.isLoggedIn() && this.type === 'BUYER') {
      this.service.getAllProducts().subscribe((data) => this.products = data);
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

  public addBidding() {
    this.bidRequest.productId = this.product.productId;
    this.biddingService.onBid(this.bidRequest).subscribe((data) => this.message = '###===Bidding Successfull===###', error => this.message = 'Unable to bid the product:(');

  }

  public updateProduct() {
    this.service.updateProduct(this.product).subscribe((data) => this.message = '###===Bidding Successfull===###', error => this.message = 'Unable to bid the product:(');
    window.location.reload();
  }

  deleteProductDetail(id: number) {
    this.service.deleteProduct(id).subscribe((data) => this.message = 'Product deleted ');
    window.location.reload();
  }

  searchProducts(key: any) {
    const results: Product[] = [];
    for (const product of this.products) {
      if (product.productName.toLowerCase().search(key.toLowerCase()) !== -1
        || product.productType.toLowerCase().search(key.toLowerCase()) !== -1
        || product.productDescription.toLowerCase().search(key.toLowerCase()) !== -1) {
        results.push(product);
      }
    }
    this.products = results;
    if (results.length === 0 || !key) {
      this.getAllProducts();
    }

  }

  getMyBiddedProducts() {
    this.biddingService.getBuyerBiddedProducts().subscribe((data) => (this.products = data));

  }

}
