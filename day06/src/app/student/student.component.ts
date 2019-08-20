import { StudentModel } from './../models/student.model';
import { StudentService } from './../services/student.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {
  _students: StudentModel[];
  constructor(private studentService:StudentService,
    private router: Router) { }

  ngOnInit() {
    this.studentService.getStudent().subscribe((students:StudentModel[])=>{
      this._students = students;
    });
  }
  addStudent(){
    //console.log('Ditekan saya');
    this.router.navigate(['student-add']);
  }

}
