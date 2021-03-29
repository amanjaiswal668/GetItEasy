import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BiddingRequest } from '../Model/bidding-request';
import { Product } from '../Model/product';

@Injectable({
  providedIn: 'root'
})
export class BiddinService {

  url = "http://localhost:8000/bid"

  constructor(private http: HttpClient) { }

  onBid(biddingRequest: BiddingRequest) {
    console.log(biddingRequest);
    return this.http.post(`${this.url}/add`, biddingRequest);
  }

  getBuyerBiddedProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.url}/getMyBiddedProduct`);
  }

}
