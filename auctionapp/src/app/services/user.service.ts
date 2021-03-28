import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  url = "http://localhost:8000/user";

  constructor(private http: HttpClient) { }

  getMyData() {

    return this.http.get<User>(`${this.url}/getData`)

  }

  updateMyData(user: User): Observable<User> {

    return this.http.post<User>(`${this.url}/updateData`, user)

  }

}
