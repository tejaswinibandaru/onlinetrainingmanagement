import { Component, OnInit } from '@angular/core';

import { AuthenticationService } from '../service/authenticationservice';
import { SignUpInfo } from '../model/signupinfo.model';

@Component({
  selector: 'register',
  templateUrl: 'register.component.html',
})
export class RegisterComponent implements OnInit {
  form: any = {};
  signupInfo: SignUpInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthenticationService) { }

  ngOnInit() { }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUpInfo(
      this.form.username,
      this.form.password,
      this.form.email,
      this.form.phoneNumber,
      this.form.role,
      );

    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
