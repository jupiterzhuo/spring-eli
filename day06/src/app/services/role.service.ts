import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = "http://localhost:8082/api/v1/roles";

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http:HttpClient) { }

  attemptAuth(username: string, ): Observable<{}> {
    const data = {
      name : username,
    }
    return this.http.post(apiUrl, data, httpOptions);

  }
}
