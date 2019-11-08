import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector:'home',
    templateUrl:'home.component.html'
})
export class HomeComponent{
    constructor(private router:Router){}

    login(){
        this.router.navigate(['/login']);
    }

    register(){
        this.router.navigate(['/register']);
    }
}