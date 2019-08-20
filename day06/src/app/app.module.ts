import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CustomMaterialModule  } from './custom-material.module';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenStorage } from './utils/token.storage';
import { AlertsModule } from 'angular-alert-module';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { AuthGuard } from './auth.guard';
import { RegisterComponent } from './register/register.component';
import { AuthInterceptor } from './services/auth.interceptor';
import { StudentAddComponent } from './student-add/student-add.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ToolbarComponent,
    HomeComponent,
    StudentComponent,
    RegisterComponent,
    StudentAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    HttpClientModule,
    AlertsModule.forRoot()
  ],
  providers: [
    TokenStorage,
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
