import { Component } from '@angular/core';
import { Course } from '../model/course.model';
import { Chapter } from '../model/chapter.model';
import { CourseService } from '../service/courseservice';
import { Router } from '@angular/router';

@Component({
    selector:'addcourse',
    templateUrl:'addcourse.component.html'
})
export class AddCourseComponent{
    isCourseAddedFailed=false;
    isCourseAdded=false;
    form:any={}
    courseName:string;
    totalDuration:string;
    category:string;
    chapterId:number;
    chapterTitle:string;
    videoUrl:string;
    course:Course={courseId:null,courseName:"",chapterList:null,totalDuration:"",category:"",registerFlag:0,deleteFlag:0};
    chapters:Chapter[]=[{
        chapterId:null,
        chapterTitle:null,
        videoUrl:null,
        bookmarkFlag:0,
        deleteFlag:0
    }];
    chaptersCount:number=1;

    constructor(private service:CourseService,private router:Router){

    }

    addChapter(){
        if(this.chaptersCount<=20){
            this.chapters.push({
                chapterId:null,
                chapterTitle:null,
                videoUrl:null,
                bookmarkFlag:0,
                deleteFlag:0
            });
            this.chaptersCount++;
        }
    }

    removeChapter(){
        this.chapters.pop();
        this.chaptersCount--;
    }

    onSubmit(){
        console.log("Add Course Button Clicked");
        this.course=new Course(this.form.coursename,this.form.duration,this.form.category);
        this.course.chapterList=this.chapters;
        this.service.addCourse(this.course).subscribe((data)=>{
            console.log(data);
            this.isCourseAdded=true;
            this.router.navigate(['/viewcourses']);
        },
        (error)=>{
            console.log(error.message);
        });

    }
}