import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from "./components/login/login.component";
import { UserComponent } from "./components/user/user.component";
import { LogoutComponent } from "./components/logout/logout.component";

const routes: Routes = [
  { path: '', component: LoginComponent }, 
  { path: 'add-user', component: UserComponent }, 
  { path: 'logout', component: LogoutComponent } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})



export class AuthRoutingModule {

 
}