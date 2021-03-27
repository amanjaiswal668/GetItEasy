import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/Model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-seller-dashboard',
  templateUrl: './seller-dashboard.component.html',
  styleUrls: ['./seller-dashboard.component.css']
})
export class SellerDashboardComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {

    this.productService.getMyProducts().subscribe((data) => this.products = data);
  }

}
