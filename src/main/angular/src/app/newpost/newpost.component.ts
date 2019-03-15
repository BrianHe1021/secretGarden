import { Component, OnInit } from '@angular/core';
import { PostService } from "../_services";
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { first} from "rxjs/operators";
import { Location } from '@angular/common';

@Component({
  selector: 'app-newpost',
  templateUrl: './newpost.component.html',
  styleUrls: ['./newpost.component.css']
})

export class NewpostComponent implements OnInit {
  NewPostForm: FormGroup;
  submitted = false;
  submitResult: string;
  themeId: string;
  constructor(private postService: PostService,
              private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private  location: Location) { }

  ngOnInit() {
    this.NewPostForm = this.formBuilder.group({
      title:['', Validators.compose([Validators.required, Validators.maxLength(50)])],
      message:['', Validators.compose([Validators.required, Validators.maxLength(200)])],
      postName:['', Validators.compose([Validators.required,Validators.maxLength(20)])]
    })
  }

  get f() {
    return this.NewPostForm.controls;
  }

  creatNewPost(){
    this.themeId = this.route.snapshot.paramMap.get('themeId');
    let userid = localStorage.getItem('currentUserID');
    this.postService.creatPost(this.themeId, this.NewPostForm.value.title, this.NewPostForm.value.message, userid,
      this.NewPostForm.value.postName).pipe(first()).subscribe(result=>{
        this.submitResult = result;
      });
  }

  onSubmit() {
    this.submitted = true;

    if (this.NewPostForm.invalid) {
      return;
    }

    this.creatNewPost();
  }

  backtolast(){
    this.location.back();
  }
}
