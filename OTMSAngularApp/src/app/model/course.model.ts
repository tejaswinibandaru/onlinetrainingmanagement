import { Chapter } from './chapter.model';

export class Course{
    courseId:number;
    courseName:string;
    chapterList:Chapter[];
    totalDuration:any;
    enrolledDate:any;
    category:string;
    registerFlag:number;
    deleteFlag:number;
}