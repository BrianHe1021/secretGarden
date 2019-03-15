import { Component, OnInit } from '@angular/core';
import {ThemeService} from "../_services";
import {first} from "rxjs/operators";
import {Post} from "../_models/post";
import {ActivatedRoute, Router} from "@angular/router";
import {Theme} from "../_models/theme";

// @ts-ignore
@Component({
  selector: 'app-postlist',
  templateUrl: './postlist.component.html',
  styleUrls: ['./postlist.component.css']
})
export class PostlistComponent implements OnInit {
  postlist: Post[] = [];
  currentTheme: Theme;
  currentUserID: string;

  constructor(private themeService: ThemeService, private router: Router, private route: ActivatedRoute) {

  }

  ngOnInit() {
    let themeId = this.route.snapshot.paramMap.get('themeId');
    this.getCurrentTheme(themeId);
    this.getPosts(themeId);
    this.currentUserID = localStorage.getItem('currentUserID');
  }

  getPosts(themeId){
    this.themeService.getPostsByThemeId(themeId).pipe(first()).subscribe(result=>{
      this.postlist = result;
    })
  }

  getCurrentTheme(themeId){
    this.themeService.getThemeByThemeId(themeId).pipe(first()).subscribe(themeResult=>{
      this.currentTheme = themeResult;
    })
  }



}
