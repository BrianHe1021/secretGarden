import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Reply} from "../_models/reply";


@Injectable()

export class ReplyService {
  constructor(private http: HttpClient) {
  }

  creatReply(postId:string, content:string, replyLayerNum: string, userId:string, replyName:string){
    return this.http.get<string>("http://52.89.73.163:8080/reply/create?postId="+postId+"&content="+content+
      "&replyLayerNum="+replyLayerNum+"&userId="+userId+"&replyName="+replyName);
  }

  getReplyOfPost(postId: string){
    return this.http.get<Reply[]>("http://52.89.73.163:8080/post/getPostReplyById?postId="+postId);
  }

  getReplyByPostId(postId: string){
    return this.http.get<Reply[]>("http://52.89.73.163:8080/post/getReplysByPostId?postId="+postId);
  }
}
