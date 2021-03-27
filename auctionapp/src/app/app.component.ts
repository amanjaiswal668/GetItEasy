import { Component } from '@angular/core';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'auctionapp';


  public loggedIn = false;

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
  }
}
