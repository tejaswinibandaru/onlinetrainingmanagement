/* import { Component } from '@angular/core';
import { Course } from '../model/course.model';
import { Chapter } from '../model/chapter.model';

@Component({
    selector:'addchapter',
    templateUrl:'addchapter.component.html'
})
export class AddChapterComponent{
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

    addCourse(){
        console.log("Add Course Button Clicked");
        this.course.chapterList=this.chapters;

    }
} */