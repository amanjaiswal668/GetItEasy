import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BiddingRequest } from '../Model/bidding-request';

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

}
