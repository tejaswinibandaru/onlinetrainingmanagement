import { Component, OnInit } from '@angular/core';
import { ChapterService } from '../service/chapterservice';
import { Chapter } from '../model/chapter.model';
import { EmbedVideoService } from 'ngx-embed-video';

@Component({
    selector:'viewchapter',
    templateUrl:'viewchapter.component.html'
})
export class ViewChapterComponent{

    courseId:number;
    chapters:Chapter[];
    youtube_iframe:any;

    youtubeUrl = "https://www.youtube.com/watch?v=iHhcHTlGtRs";
    constructor(private service:ChapterService,private embedService: EmbedVideoService){
        this.youtube_iframe = this.embedService.embed(this.youtubeUrl,{
            attr: { width: 900, height: 500 }
        });
    }
}