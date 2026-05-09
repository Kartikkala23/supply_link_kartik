import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from "../../../environments/environment";
import { Observable } from "rxjs";
import { Supplier } from "../../supplylink/types/Supplier";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private loginUrl = `${environment.apiUrl}`;
  //private loginUrl="https://orchardsolveone.lntedutech.com/project/2279/proxy/3306/"


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private http: HttpClient) { }

  login(user: Partial<Supplier>): Observable<{ [key: string]: string }> {
    return this.http.post<{ token: string }>(
      `${this.loginUrl}/user/login`,
      user,
      this.httpOptions
    );
  }

  getToken() {
    return localStorage.getItem("token");
  }
  getRole() {
    return localStorage.getItem("role");
  }


  createUser(user: Supplier): Observable<Supplier> {
    return this.http.post<Supplier>(`${this.loginUrl}/user/register`, user);
  }
}


// import { HttpClient } from "@angular/common/http";
// import { Injectable } from "@angular/core";
// import { Observable } from "rxjs";
// import { environment } from "../../../environments/environment";
// import { Supplier } from "../../supplylink/types/Supplier";

// @Injectable({
//     providedIn: "root",
// })
// export class AuthService {
//     // private loginUrl = `${environment.apiUrl}`; // adjust if needed
//     private loginUrl="https://orchardsolveone.lntedutech.com/project/2279/proxy/3306/"

//     constructor(private http: HttpClient) {}

//     login(credentials: { username: string; password: string }): Observable<any> {
//         return this.http.post(`${this.loginUrl}/user/login`, credentials);
//     }
//       createUser(user: Supplier): Observable<Supplier> {
//     return this.http.post<Supplier>(`${this.loginUrl}/user/register`, user);
//   }
// }