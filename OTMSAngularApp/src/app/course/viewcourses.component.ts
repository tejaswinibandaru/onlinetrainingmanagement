import { Component, OnInit } from '@angular/core';
import { CourseService } from '../service/courseservice';
import { Course } from '../model/course.model';
import { ChapterService } from '../service/chapterservice';
import { Router } from '@angular/router';

@Component({
    selector:'viewcourses',
    templateUrl:'viewcourses.component.html'
})
export class ViewCoursesComponent implements OnInit{
    courses:Course[]=[]
    constructor(private courseService:CourseService,private router:Router){

    }
    ngOnInit(){
        this.courseService.viewAllCourses().subscribe((data:Course[])=>{this.courses=data})
    }

    viewChapters(courseId:number){
        this.router.navigate(['/viewchapters',courseId]);
    }
}