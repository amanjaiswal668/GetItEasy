import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = "http://localhost:8000/product";
  constructor(private http : HttpClient) { }

  getProduct(){
    return this.http.get(`${this.baseUrl}/getProduct`)
  }

}
