import { Component } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { AuthService } from "../../src/app/services/auth-service/auth.service";
import { CustomerService } from "../../src/app/services/customer-service/customer.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {  
  constructor(private translate: TranslateService, public authService: AuthService, public customerService: CustomerService) {
    translate.setDefaultLang('en');
  }

useLanguage(language: string) {
    this.translate.use(language);
    console.log("Resultado CustomerService");
    console.log(this.customerService.getCustomerList());
  }
}
