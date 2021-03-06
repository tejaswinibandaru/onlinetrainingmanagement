import { Component, OnInit } from '@angular/core';

import { AuthenticationService } from '../service/authenticationservice';
import { TokenStorageService } from '../service/tokenstorageservice';
import { AuthLoginInfo } from '../model/authlogininfo.model';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: 'login.component.html',
})
export class LoginComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  authority:string;
  private loginInfo: AuthLoginInfo;

  constructor(private authService: AuthenticationService, private tokenStorage: TokenStorageService,private router:Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_USER') {
          this.authority = 'user';
          return false;
        }
        return true;
      });
    }
  }

  onSubmit() {
    console.log(this.form);

    this.loginInfo = new AuthLoginInfo(
      this.form.username,
      this.form.password);

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        if(this.authority==='admin'){
          this.router.navigate(['/adminhome']);
        }
        if(this.authority==='user'){
          this.router.navigate(['/userhome']);
        }
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage() {
    window.location.reload();
  }

  loadAdminPage(){
    this.router.navigate(['adminhome']);
  }

  loadUserPage(){
    this.router.navigate(['userhome']);
  }
}
