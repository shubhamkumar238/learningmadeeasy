import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private baseUrl = 'http://localhost:8080/';  

  constructor(private http:HttpClient) { }

  getAllCourses() : Observable<any>{
    return this.http.get(this.baseUrl+'courses');
  }
}
