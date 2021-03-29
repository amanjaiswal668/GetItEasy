import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../Model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = "http://localhost:8000/product";
  constructor(private http: HttpClient) { }

  getProduct() {
    return this.http.get(`${this.baseUrl}/getProduct`)
  }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/getAllProducts`)
  }

  updateProduct(product: Product) {
    return this.http.post<Product>(`${this.baseUrl}/updateProduct`, product);
  }

  deleteProduct(id: number) {
    return this.http.delete(`${this.baseUrl}/deleteProduct/${id}`);
  }


  getMyProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/getMyProducts`)
  }

}
