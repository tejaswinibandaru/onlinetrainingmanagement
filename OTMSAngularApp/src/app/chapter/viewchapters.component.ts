import { Component, OnInit } from '@angular/core';
import { ChapterService } from '../service/chapterservice';
import { Chapter } from '../model/chapter.model';

@Component({
    selector:'viewchapters',
    templateUrl:'viewchapters.component.html'
})
export class ViewChaptersComponent implements OnInit{

    courseId:number;
    chapters:Chapter[];
    constructor(private service:ChapterService){
    }

    ngOnInit(){
        this.service.viewAllChapters(this.courseId).subscribe((data:Chapter[])=>{this.chapters=data});
    }

}