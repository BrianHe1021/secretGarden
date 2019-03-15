import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Theme} from "../_models/theme";
import {Post} from "../_models/post";


@Injectable()

export class ThemeService {
  constructor(private http: HttpClient) {
  }

  getAllTheme(){
    return this.http.get<Theme[]>("http://52.89.73.163:8080/theme/getAll");
  }

  getPostsByThemeId(themeId:string){
    return this.http.get<Post[]>("http://52.89.73.163:8080/post/getThemePosts?themeId=" + themeId);
  }

  getThemeByThemeId(themeId: string){
    return this.http.get<Theme>("http://52.89.73.163:8080/theme/getThemeById?themeId=" + themeId);
  }

}
