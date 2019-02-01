import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {TeamPolicyComponent} from "./team-policy/team-policy.component";
import {ThemeListComponent} from "./theme-list/theme-list.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'teampolicy', component: TeamPolicyComponent},
  { path: 'themelist', component: ThemeListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
