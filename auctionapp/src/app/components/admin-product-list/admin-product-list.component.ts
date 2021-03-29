import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-product-list',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.css']
})
export class AdminProductListComponent implements OnInit {

  message : any
  constructor(private adminService : AdminService) { }

  ngOnInit(): void {
  }

  deleteProduct(id: number) {
    this.adminService.deleteProductDetail(id).subscribe((data) => this.message = data);
    window.location.reload();
  }
}
