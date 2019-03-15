import { Component, OnInit } from '@angular/core';
import { ThemeService } from "../_services/theme.service";
import { first } from "rxjs/operators";
import { Theme } from "../_models/theme";

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.css']
})
export class ThemeListComponent implements OnInit {
  currentUserID: string;
  themeList: Theme [] = [];

  constructor(private themeService: ThemeService) { }

  ngOnInit() {
    this.currentUserID = localStorage.getItem('currentUserID');
    this.getAllTheme();

  }

  getAllTheme(){
    this.themeService.getAllTheme().pipe(first()).subscribe(result=>{
      this.themeList = result;
    });
  }

}
