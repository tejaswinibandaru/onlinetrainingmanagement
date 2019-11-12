import { Component, OnInit } from '@angular/core';
import { ChapterService } from '../service/chapterservice';
import { Chapter } from '../model/chapter.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector:'viewchapters',
    templateUrl:'viewchapters.component.html'
})
export class ViewChaptersComponent implements OnInit{

    courseId:number;
    chapters:Chapter[];
    constructor(private service:ChapterService,private router:Router,private route:ActivatedRoute){
    }

    ngOnInit(){
        this.courseId=+this.route.snapshot.paramMap.get('courseId');
        this.viewChapters();
    }

    viewChapters(){
        this.service.viewAllChapters(this.courseId).subscribe((data:Chapter[])=>{this.chapters=data});
    }

    playVideo(){
        this.router.navigate(['/viewchapter'])
    }

}