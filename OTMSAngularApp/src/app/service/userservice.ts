import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn:'root'
})
export class UserService{
    constructor(private userHttp:HttpClient){}

    viewAllUsers(){
        return this.userHttp.get('http://'+ window.location.hostname+':9083/onlinetraining/viewallusers');
    }
}