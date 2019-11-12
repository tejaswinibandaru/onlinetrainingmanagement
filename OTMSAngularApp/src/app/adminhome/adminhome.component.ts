import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector:'adminhome',
    templateUrl:'adminhome.component.html'
})
export class AdminHomeComponent implements OnInit{

    constructor(private router:Router){}
    ngOnInit(){
        this.router.navigate(['/viewcourses']);
    }
}