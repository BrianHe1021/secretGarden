import { Component, OnInit } from '@angular/core';
import {PostService} from "../_services";
import {first} from "rxjs/operators";
import {Post} from "../_models/post";

@Component({
  selector: 'app-post-history',
  templateUrl: './post-history.component.html',
  styleUrls: ['./post-history.component.css']
})
export class PostHistoryComponent implements OnInit {
  currentUserID:string;
  postlist:Post[]=[];

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.currentUserID = localStorage.getItem('currentUserID');
    if(this.currentUserID!=null) {
      this.getMypost(this.currentUserID);

    };
  }

  getMypost(currentUserID:string){
    this.postService.getUserPosts(currentUserID).pipe(first()).subscribe(result=>{
      console.log(result);
      this.postlist = result;
      console.log(this.postlist);
    })
  }

}
