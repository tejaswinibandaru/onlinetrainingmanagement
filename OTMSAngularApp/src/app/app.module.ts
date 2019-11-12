import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import {EmbedVideo} from 'ngx-embed-video'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ViewChaptersComponent } from './chapter/viewchapters.component';
import { AdminHomeComponent } from './adminhome/adminhome.component';
import { ViewChapterComponent } from './chapter/viewchapter.component';
import { ViewCoursesComponent } from './course/viewcourses.component';
import { LogoutComponent } from './logout/logout.component';
import { AddCourseComponent } from './course/addcourse.component';
import { UserHomeComponent } from './userhome/userhome.component';
import { SearchCourseComponent } from './course/searchcourse.component';

@NgModule({
  declarations: [
    AppComponent,HomeComponent,LoginComponent,RegisterComponent,ViewChaptersComponent,AdminHomeComponent,
    ViewChapterComponent,ViewCoursesComponent,LogoutComponent,AddCourseComponent,UserHomeComponent,SearchCourseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,HttpClientModule,EmbedVideo.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
