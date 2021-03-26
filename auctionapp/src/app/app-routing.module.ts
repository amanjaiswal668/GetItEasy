import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { BuyerDashboardComponent } from './components/buyer-dashboard/buyer-dashboard.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { ProductlistComponent } from './components/productlist/productlist.component';

import { RegisterLoginComponent } from './components/register-login/register-login.component';
import { SellerDashboardComponent } from './components/seller-dashboard/seller-dashboard.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path:'', component:HomeComponent,pathMatch:"full"},
  {path:'login',component:RegisterLoginComponent,pathMatch:"full"},
  {path:'dashboard',component:DashboardComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'userallproduct',component:ProductlistComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'seller',component:SellerDashboardComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'buyer',component:BuyerDashboardComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'admin',component:AdminDashboardComponent,pathMatch:"full",canActivate:[AuthGuard]}
]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
