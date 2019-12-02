import { Component } from '@angular/core';
import { AuthService } from "../../services/auth-service/auth.service";
import * as firebase from 'firebase/app'

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  constructor(public authService: AuthService) {
    
  }

  signWithGoogle() {
    this.authService.afAuth.auth.signInWithPopup(new firebase.auth.GoogleAuthProvider());
    //this.authService.GoogleAuth();
  }

}
