import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AdminProductListComponent } from './components/admin-product-list/admin-product-list.component';
import { AdminUserListComponent } from './components/admin-user-list/admin-user-list.component';
import { BuyerDashboardComponent } from './components/buyer-dashboard/buyer-dashboard.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { ProductlistComponent } from './components/productlist/productlist.component';

import { RegisterLoginComponent } from './components/register-login/register-login.component';
import { SellerDashboardComponent } from './components/seller-dashboard/seller-dashboard.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path:'', component:HomeComponent,pathMatch:"full"},
  {path:'login',component:RegisterLoginComponent,pathMatch:"full"},
  {path:'dashboard',component:DashboardComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'userallproduct',component:ProductlistComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'seller',component:SellerDashboardComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'buyer',component:BuyerDashboardComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'admin',component:AdminDashboardComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'myprofile',component:UserprofileComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'adminproductlist',component:AdminProductListComponent,pathMatch:"full",canActivate:[AuthGuard]},
  {path:'register',component:RegisterLoginComponent,pathMatch:"full"},
  {path:'footer',component:FooterComponent,pathMatch:"full"},
  {path:'aboutus',component:AboutUsComponent,pathMatch:"full"},
  {path:'adminuserlist',component:AdminUserListComponent,pathMatch:"full"}
]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
