import { Component, OnInit } from '@angular/core';
import {PostService, ReplyService, ThemeService} from "../_services";
import {first} from "rxjs/operators";
import {Post} from "../_models/post";
import {Theme} from "../_models/theme";
import {ActivatedRoute, Router} from "@angular/router";
import {Reply} from "../_models/reply";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  currentPost: Post;
  NewReplyForm: FormGroup;
  currentTheme: Theme;
  replylist: Reply[];
  themeId: string;
  submitted = false;
  submitResult: string;

  constructor(private postService: PostService, private themeService: ThemeService, private replyService: ReplyService,
              private router: Router, private route: ActivatedRoute, private formBuilder: FormBuilder,) { }

  ngOnInit() {
    this.getPostById();
    this.NewReplyForm = this.formBuilder.group({
      content:['', Validators.required],
      replyName:['', Validators.required]
    });
    this.getRepies();

  }
  get f() {
    return this.NewReplyForm.controls;
  }

  getPostById(){
    let postId = this.route.snapshot.paramMap.get('postId');
    this.postService.getPostByPostId(postId).pipe(first()).subscribe(postResult=>{
      this.currentPost = postResult;
      this.themeId = postResult.themeId.toString();
      this.getThemeById(this.themeId);
    });
  }

  getThemeById(themeId: string){
    this.themeService.getThemeByThemeId(themeId).pipe(first()).subscribe(result=>{this.currentTheme = result;});
  }

  getRepies(){
    let postId = this.route.snapshot.paramMap.get('postId');
    this.replyService.getReplyByPostId(postId).pipe(first()).subscribe(replyList=>{
      this.replylist = replyList;
    });
  }

  submitReply(){
    this.submitted = true;
    if (this.NewReplyForm.invalid) {
      return;
    }
    let postId = this.route.snapshot.paramMap.get('postId');
    let userId = localStorage.getItem('currentUserID');
    this.replyService.creatReply(postId, this.NewReplyForm.value.content, "0", userId, this.NewReplyForm.value.replyName).pipe(first()).subscribe(result=>{
      this.submitResult = result;
    });
  }

  submitReplytoLayer(layer: string){
    this.submitted = true;
    if (this.NewReplyForm.invalid) {
      return;
    }
    let postId = this.route.snapshot.paramMap.get('postId');
    let userId = localStorage.getItem('currentUserID');
    this.replyService.creatReply(postId, this.NewReplyForm.value.content, layer, userId, this.NewReplyForm.value.replyName).pipe(first()).subscribe(result=>{
      this.submitResult = result;
    });
  }

}
