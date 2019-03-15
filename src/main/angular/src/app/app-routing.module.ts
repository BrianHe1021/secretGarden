import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {TeamPolicyComponent} from "./team-policy/team-policy.component";
import {ThemeListComponent} from "./theme-list/theme-list.component";
import {PostlistComponent} from "./postlist/postlist.component";
import {PostHistoryComponent} from "./post-history/post-history.component";
import {NewpostComponent} from "./newpost/newpost.component";
import {UserProfileComponent} from "./user-profile/user-profile.component";
import {PostComponent} from "./post/post.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'teampolicy', component: TeamPolicyComponent},
  { path: 'themelist', component: ThemeListComponent},
  { path: 'posthistory', component: PostHistoryComponent},
  { path: 'newpost/:themeId', component: NewpostComponent},
  { path: 'userprofile', component: UserProfileComponent},
  { path: 'post/:postId', component: PostComponent},
  { path: 'postlist/:themeId', component: PostlistComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
