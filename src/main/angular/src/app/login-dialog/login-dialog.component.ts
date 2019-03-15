import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {
  loginResult: string;

  constructor(
    private router: Router,
    private dialogRef: MatDialogRef<LoginDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data
  ) {

    this.loginResult = data.loginResult;
  }

  ngOnInit() {
  }

  close() {
    this.dialogRef.close();
    window.location.reload();
  }

  getin() {
    this.dialogRef.close();
    window.location.reload();
  }

}
