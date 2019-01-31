import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from "@angular/router";


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
  ) { }

  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      email:['', Validators.compose([Validators.required, Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')])],
      username:['', Validators.required],
      password:['', Validators.compose([Validators.required, Validators.minLength(6)])]
    });
  }

  get f() { return this.signupForm.controls; }


  onSubmit(){
    this.submitted = true;

    if (this.signupForm.invalid) {
      return;
    }

    this.loading = true;
  }

}
