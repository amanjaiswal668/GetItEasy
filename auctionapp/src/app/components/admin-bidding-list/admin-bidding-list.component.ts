import { Component, OnInit } from '@angular/core';
import { BidListModel } from 'src/app/Model/bid-list-model';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-bidding-list',
  templateUrl: './admin-bidding-list.component.html',
  styleUrls: ['./admin-bidding-list.component.css']
})
export class AdminBiddingListComponent implements OnInit {

  bidList: BidListModel[] = [];
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {

    this.adminService.getAllBidList().subscribe((data) => this.bidList = data);
  }

  sendEmail(id: number){
    this.adminService.sendMail(id);
  }
}
