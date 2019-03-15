import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule} from "@angular/forms";
import { MatDialogModule } from "@angular/material";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NavbarComponent } from './navbar/navbar.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { SanitizeHtmlPipe } from './app.pipe';
import { AlertService, UserService, ThemeService, ReplyService, PostService } from "./_services";
import { AlertComponent } from "./_directives";
import { LoginComponent } from './login/login.component';
import { LoginDialogComponent } from './login-dialog/login-dialog.component';
import { SignupDialogComponent } from './signup-dialog/signup-dialog.component';
import { TeamPolicyComponent } from './team-policy/team-policy.component';
import { ThemeListComponent } from './theme-list/theme-list.component';
import { PostlistComponent } from './postlist/postlist.component';
import { PostComponent } from './post/post.component';
import { PostHistoryComponent } from './post-history/post-history.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { NewpostComponent } from './newpost/newpost.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    HomeComponent,
    AlertComponent,
    LoginComponent,
    LoginDialogComponent,
    SignupDialogComponent,
    TeamPolicyComponent,
    ThemeListComponent,
    PostlistComponent,
    PostComponent,
    PostHistoryComponent,
    UserProfileComponent,
    NewpostComponent,
    SanitizeHtmlPipe
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MatDialogModule,
    NgbModule,
    AppRoutingModule
  ],
  providers: [AlertService, UserService, ThemeService,  ReplyService, PostService],
  bootstrap: [AppComponent],
  entryComponents: [LoginDialogComponent,SignupDialogComponent]
})
export class AppModule { }
