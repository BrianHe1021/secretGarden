import { Component, OnInit } from '@angular/core';
import { UserService} from "../_services";
import {first} from "rxjs/operators";
import {User} from "../_models/user";
import {FormBuilder, FormGroup} from "@angular/forms";
import { Location } from '@angular/common';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  currentUser: User;
  profileForm: FormGroup;

  constructor(private userService: UserService, private formBuilder: FormBuilder, private location: Location) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));

    if(this.currentUser!=null) {
      this.profileForm = this.formBuilder.group({
        userId: [this.currentUser.userId],
        userName: [this.currentUser.userName],
        password: [this.currentUser.password],
        email: [this.currentUser.email]
      });
    };
  }

  backtolast(){
    this.location.back();
  }

}
