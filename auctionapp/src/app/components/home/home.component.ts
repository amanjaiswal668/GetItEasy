import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/Model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  product: Product = new Product;

  products : Product[] = [];

  constructor(private service: ProductService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts(){
    this.service.getAllProducts().subscribe((data)=>this.products = data)
  }

  setProduct(p : Product){
    this.product =p;
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

}
