import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ViewChaptersComponent } from './chapter/viewchapters.component';
import { AdminHomeComponent } from './adminhome/adminhome.component';
import { ViewChapterComponent } from './chapter/viewchapter.component';
import { ViewCoursesComponent } from './course/viewcourses.component';
import { LogoutComponent } from './logout/logout.component';
import { AddCourseComponent } from './course/addcourse.component';
import { UserHomeComponent } from './userhome/userhome.component';
import { SearchCourseComponent } from './course/searchcourse.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'adminhome',component:AdminHomeComponent},
  {path:'userhome',component:UserHomeComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'addcourse',component:AddCourseComponent},
  {path:'viewcourses',component:ViewCoursesComponent},
  {path:'viewchapters/:courseId',component:ViewChaptersComponent},
  {path: 'viewchapter',component:ViewChapterComponent},
  {path:'searchcourse',component:SearchCourseComponent},
  {path: 'logout',component:LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
