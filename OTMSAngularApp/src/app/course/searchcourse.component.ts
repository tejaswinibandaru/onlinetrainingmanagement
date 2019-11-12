import { Component, OnInit } from '@angular/core';
import { CourseService } from '../service/courseservice';
import { Router } from '@angular/router';
import { Course } from '../model/course.model';

@Component({
    selector:'searchcourse',
    templateUrl:'searchcourse.component.html'
})
export class SearchCourseComponent implements OnInit{
    courseName:string;
    courses:Course[];
    
    loadComponent=false;
    constructor(private service:CourseService,private router:Router){
    }
    ngOnInit(){
        this.service.viewAllCourses().subscribe((data:Course[])=>{this.courses=data});
    }
    
    viewChapters(courseId:number){
        this.router.navigate(['/viewchapters',courseId]);
    }
}