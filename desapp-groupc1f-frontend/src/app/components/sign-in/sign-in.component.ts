import { Component, OnInit } from '@angular/core';
import { AuthService } from "../../services/auth-service/auth.service";
import * as firebase from 'firebase/app'

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(public authService: AuthService) { }
  ngOnInit() { }
}
