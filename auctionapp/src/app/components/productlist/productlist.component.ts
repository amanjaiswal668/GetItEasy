import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

product : any;
products: Product[] = [];
  constructor(private http: HttpClient, private service: ProductService, private router: Router) { }

  ngOnInit(): void {

    this.service.getAllProducts().subscribe((data) => this.products = data);
    console.log(this.products);
  }

}
