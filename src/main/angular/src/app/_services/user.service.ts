import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {User} from "../_models/user"

@Injectable()

export class UserService {
  constructor(private http: HttpClient) {
  }

  signup(user: User) {
    return this.http.post(`http://52.89.73.163:8080/user/register?userName=` + user.userName
      + `&password=` + user.password + `&email=` + user.email, user);
  }

  login(email: string, password: string) {
    return this.http.get<string>(`http://52.89.73.163:8080/user/login/getId?email=` + email + `&password=` + password);
  }

  getUerByuserid(userId: string) {
    return this.http.get<User>(`http://52.89.73.163:8080/user/getUserById?userId=` + userId);
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
    localStorage.removeItem('currentUser');
    localStorage.clear();

  }

}
