import { Chapter } from './chapter.model';

export class Course{
    courseId:number;
    courseName:string;
    chapterList:Chapter[];
    totalDuration:string;
    category:string;
    registerFlag:number;
    deleteFlag:number;


    constructor(courseName:string,totalDuration:string,category:string){
        this.courseName=courseName;
        this.totalDuration=totalDuration;
        this.category=category;
        this.registerFlag=0;
        this.deleteFlag=0
    }
}