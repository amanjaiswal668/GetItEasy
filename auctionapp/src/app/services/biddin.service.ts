import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BiddinService {

  url="http://localhost:8000/bid"

  constructor(private http : HttpClient) { }

  onBid(){
    this.http.post
  }

}
