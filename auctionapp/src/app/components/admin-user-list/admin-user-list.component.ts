import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-user-list',
  templateUrl: './admin-user-list.component.html',
  styleUrls: ['./admin-user-list.component.css']
})
export class AdminUserListComponent implements OnInit {

  users: User[] = [];
  message: any;

  constructor(private http: HttpClient, private router: Router, private adminService: AdminService) { }

  ngOnInit(): void {
    this.getUserList();
  }

  getUserList() {
    this.adminService.getUserDetail().subscribe((data) => this.users = data);
  }

  deleteUser(id: number) {
    this.adminService.deleteUserDetail(id).subscribe((data) => this.message = data);
    window.location.reload();
  }

}
