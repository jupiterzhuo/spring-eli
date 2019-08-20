import { TokenStorage } from './../utils/token.storage';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = "http://localhost:8082/login";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http:HttpClient,
    private tokenStorage : TokenStorage,
    private myRoute: Router) { }

  attemptAuth(username: string, passsword: string): Observable<{}> {
    const dataCrendential = {
      username : username,
      password : passsword 
    }
    return this.http.post(apiUrl, dataCrendential, httpOptions);

  }
  isLoggedIn(){
    //console.log('Token :',this.tokenStorage.getToken());
    if(this.tokenStorage.getToken() == null)
      return false;
    else
      return true;
  }
  logout(){
    console.log('Logout');
    this.tokenStorage.signOut();
    this.myRoute.navigate(['login']);
  }
  
}
