import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {first} from "rxjs/operators";
import {UserService} from "../_services";
import {User} from "../_models/user";
import {LoginComponent} from "../login/login.component";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  currentUsername: string;
  currentUserID: string;
  logged = false;


  constructor(private router: Router, private userService: UserService) {
  }

  ngOnInit() {

    this.currentUserID = localStorage.getItem('currentUserID');

    if (this.currentUserID != null ) {
      this.logged = true;
      this.userService.getUerByuserid(this.currentUserID).pipe(first()).subscribe(result => {
        this.currentUsername = result.userName;
        localStorage.setItem('currentUser', JSON.stringify(result));
      });
    };
  }

  userLogout(): void {
    this.logged = false;
    localStorage.removeItem('currentUserID');
    localStorage.clear();
    this.router.navigate([''])
  }

}
