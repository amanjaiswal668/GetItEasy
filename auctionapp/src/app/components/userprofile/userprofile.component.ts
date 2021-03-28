import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/product';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {

  user: User = new User;
  editing: boolean = false;

  constructor(private http: HttpClient, private router: Router, private userService: UserService) { }

  ngOnInit(): void {

    this.userService.getMyData().subscribe((data) => this.user = data);
  }

  public updateMyData(user: User) {
    this.userService.updateMyData(user).subscribe((data) => this.user = data);
    
  }

  public enableDisableEdit() {
    this.editing = true;
  }

  public saveData() {

    this.updateMyData(this.user);
    this.editing = false;
  }
}
