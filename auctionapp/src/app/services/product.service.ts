import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../Model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = "http://localhost:8000/product";
  constructor(private http : HttpClient) { }

  getProduct(){
    return this.http.get(`${this.baseUrl}/getProduct`)
  }

  getAllProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.baseUrl}/getAllProducts`)
  }

  getMyProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.baseUrl}/getMyProducts`)
  }

}
