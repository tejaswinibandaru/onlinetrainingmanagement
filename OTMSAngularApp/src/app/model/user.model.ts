import { Course } from './course.model';

export class User{
    userId:number;
    username:string;
    userPassword:string;
    email:string;
    phoneNumber:string;
    courseList:Course[];
    role:string;
    active:boolean;
}