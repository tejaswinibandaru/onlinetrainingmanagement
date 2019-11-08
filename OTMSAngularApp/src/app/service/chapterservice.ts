import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn:'root'
})
export class ChapterService{
    constructor(private courseHttp:HttpClient){}

    viewAllChapters(courseId:number){
        return this.courseHttp.get('http://'+ window.location.hostname+':9083/onlinetraining/viewallchapters?courseId='+courseId);
    }

    addChapter(chapter:any){
        return this.courseHttp.post('http://'+window.location.hostname+':9083/onlinetraining/addchapter',chapter);
    }

    deleteChapter(chapterId:number){
        return this.courseHttp.put('http://'+window.location.hostname+':9083/onlinetraining/deletechapter?chapterId='+chapterId,null);
    }

    viewChapter(chapterId:number){
        return this.courseHttp.get('http://'+window.location.hostname+':9083/onlinetraining/viewchapter?chapterId='+chapterId);
    }
}