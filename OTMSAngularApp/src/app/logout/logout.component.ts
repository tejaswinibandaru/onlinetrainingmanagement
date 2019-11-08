import { Component, OnInit } from "@angular/core";
import { TokenStorageService } from "../service/tokenstorageservice";

@Component({
    selector:'logout',
    templateUrl:'logout.component.html'
})
export class LogoutComponent implements OnInit{
    constructor(private service:TokenStorageService){}

    ngOnInit(){
        this.service.signOut();
    }

}