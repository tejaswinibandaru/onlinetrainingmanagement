import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn:'root'
})
export class CourseService{
    constructor(private courseHttp:HttpClient){}

    viewAllCourses(){
        return this.courseHttp.get('http://'+ window.location.hostname+':9083/onlinetraining/viewallcourses');
    }

    addCourse(course:any){
        return this.courseHttp.post('http://'+window.location.hostname+':9083/onlinetraining/addcourse',course);
    }

    deleteCourse(courseId:number){
        return this.courseHttp.put('http://'+window.location.hostname+':9083/onlinetraining/deletecourse?courseId='+courseId,null);
    }

    viewCourse(courseId:number){
        return this.courseHttp.get('http://'+window.location.hostname+':9083/onlinetraining/viewcourse?course='+courseId);
    }
}