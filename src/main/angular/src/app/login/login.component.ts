import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {LoginDialogComponent} from "../login-dialog/login-dialog.component";
import {UserService} from "../_services";
import {first} from "rxjs/operators";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;
  result = false;
  currentUserID: string;

  constructor(
    private formBuilder: FormBuilder,
    private dialog: MatDialog,
    private userService: UserService,
    private router: Router,
  ) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: [''],
      password: ['']
    });
  }

  get f() {
    return this.loginForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    this.userService.login(this.loginForm.controls['email'].value,
      this.loginForm.controls['password'].value).pipe(first()).subscribe(
        data=>{
          data.toString();

          if(data != '-1'){
            this.result = true;
            this.currentUserID = data;
            localStorage.setItem('currentUserID', JSON.stringify(this.currentUserID));
          };


          this.openLoginDialog();
        }, error => {

      }
    );

    this.result = false;
  }

  returnToNav(): boolean{
    if(this.result && this.submitted){
      return true;
    }else {
      return false;
    };
  }

  openLoginDialog():void {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      loginResult: this.result
    };

    this.dialog.open(LoginDialogComponent, dialogConfig);
  }


}
