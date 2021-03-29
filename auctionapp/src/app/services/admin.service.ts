import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})

export class AdminService {

  url = "http://localhost:8000/admin"

  constructor(private http: HttpClient, private router: Router) { }

  getUserDetail(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}/getAllUsers`);
  }

  deleteUserDetail(id: number) {
    return this.http.delete(`${this.url}/deleteUser/${id}`);
  }

  deleteProductDetail(id : number){
    return this.http.delete(`${this.url}/admin/deleteProduct/${id}`);
  }
}
