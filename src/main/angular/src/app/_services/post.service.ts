import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Post} from "../_models/post";


@Injectable()

export class PostService {
  constructor(private http: HttpClient) {
  }

  creatPost(themeId:string, title:string, message:string, userId: string, postName:string){
    return this.http.get<string>("http://localhost:8080/post/create?themeId="+themeId+"&title="+title+"&message="+
      message+"&userId="+userId+"&postName="+postName);
  }

  getUserPosts(userId: string){
    return this.http.get<Post[]>("http://localhost:8080/post/getUserPosts?userId="+userId);
  }

  getPostByPostId(postId: string){
    return this.http.get<Post>("http://localhost:8080/post/getPostById?postId="+postId);
  }

  
}
