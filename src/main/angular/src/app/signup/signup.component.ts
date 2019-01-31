import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {first} from "rxjs/operators";
import {UserService} from "../_services";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {SignupDialogComponent} from '../signup-dialog/signup-dialog.component';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  submitted = false;
  result = false;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private dialog: MatDialog,
    private router: Router,
  ) {
  }

  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      email: ['', Validators.compose([Validators.required, Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')])],
      userName: ['', Validators.required],
      password: ['', Validators.compose([Validators.required, Validators.minLength(6)])]
    });
  }

  get f() {
    return this.signupForm.controls;
  }


  onSubmit() {
    this.submitted = true;

    if (this.signupForm.invalid) {
      return;
    }

    this.userService.signup(this.signupForm.value).pipe(first()).subscribe(
      data => {
        data.toString();
        if(data){this.result = true;}
        this.openSignupDialog();
      },
      error=>{
      }
    );
    this.result = false;
  }

  openSignupDialog() {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      signupResult: this.result
  }
    this.dialog.open(SignupDialogComponent, dialogConfig);
  }

}
