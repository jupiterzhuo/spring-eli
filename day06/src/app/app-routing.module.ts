import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { StudentComponent } from './student/student.component';
import { RegisterComponent } from './register/register.component';
import { StudentAddComponent } from './student-add/student-add.component'
const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full', canActivate: [AuthGuard]},
  { path : 'login', component: LoginComponent },
  { path : 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  { path: 'student', component: StudentComponent, canActivate: [AuthGuard]},
  { path: 'student-add', component: StudentAddComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
