import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {User} from "../_models/user"

@Injectable()

export class UserService {
  constructor(private http: HttpClient) {
  }

  signup(user: User) {
    return this.http.post(`http://localhost:8080/user/register?username=` + user.userName + `&password=` + user.password + `&email=` + user.email, user);
  }

  login(email: string, password: string) {
    return this.http.get<string>(`http://localhost:8080/user/login/getId?email=` + email + `&password=` + password);
  }

  getUerByuserid(userid: string) {
    return this.http.get<User>(`http://localhost:8080/user/getUserById?userid=` + userid);
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
    localStorage.removeItem('currentUser');
    localStorage.clear();

  }

}
