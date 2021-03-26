import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  product:any

  constructor(private productService : ProductService) { }

  ngOnInit(): void {
  }

  getProduct(){
    this.productService.getProduct().subscribe(
      (response:any)=>{
        this.product = response;
        console.log(response.productName)
      },
      error=>{
        console.log(error)
      }
    )
  }

}
