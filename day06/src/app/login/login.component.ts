import { Router } from '@angular/router';
import { TokenStorage } from './../utils/token.storage';
import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { AlertsService } from 'angular-alert-module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username : string;
  password : string;
  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorage,
    private alerts: AlertsService,
    private myRoute:Router) { }

  ngOnInit() {
  }

  login():void{
  
    this.authService.attemptAuth(this.username,this.password).subscribe(
      (data:any) =>{
        //console.log(data.Authorization);
        //save Token on Local Storage
        this.tokenStorage.saveToken(data.Authorization);
        this.myRoute.navigate(["home"]);
      },
      error => {
        console.log(error);
        this.alerts.setMessage('Login Failed!!','error');
      }
    );


  }

}
