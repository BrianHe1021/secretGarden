import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {first} from "rxjs/operators";
import {UserService} from "../_services";
import {User} from "../_models/user";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  currentUser: User;
  currentUserID: string;
  logged = false;

  constructor(private router: Router, private userService: UserService) {
  }

  ngOnInit() {
    this.currentUserID = localStorage.getItem('currentUserID');

    if (this.currentUserID != '-1') {
      this.logged = true;
      this.userService.getUerByuserid(this.currentUserID).pipe(first()).subscribe(user => {
        this.currentUser = user;
        //console.log(this.currentUser);
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
