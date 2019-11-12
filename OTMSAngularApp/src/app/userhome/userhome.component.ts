import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector:'userhome',
    templateUrl:'userhome.component.html'
})
export class UserHomeComponent implements OnInit{
    constructor(private router:Router){

    }

    ngOnInit(){
        this.router.navigate(['/searchcourse']);
    }
}