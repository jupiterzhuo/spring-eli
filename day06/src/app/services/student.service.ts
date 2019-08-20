import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { StudentModel } from '../models/student.model';
import { map } from 'rxjs/operators';
import { throwError } from 'rxjs';


const apiUrl = 'http://localhost:8082/api/v1/students';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  getStudent(): Observable<StudentModel[]> {
    return this.http.get<StudentModel[]>(apiUrl);
  }
  addNewStudent(student: StudentModel): Observable<StudentModel> {
    return this.http.post<StudentModel>(apiUrl, student);
  }
  updateStudent(student: StudentModel) {
  return this.http.put<StudentModel>(apiUrl, student);
  }
  deleteStudent(studentId:number) {
    return this.http.delete<StudentModel>(apiUrl, studentId);
    }
}
