import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { MenuListComponent } from './components/menu-list/menu-list.component';
import { MenuDetailsComponent } from './components/menu-details/menu-details.component';
import { CreateMenuComponent } from './components/create-menu/create-menu.component';
import { UpdateMenuComponent } from './components/update-menu/update-menu.component';
//Translation
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    AccountListComponent,
    CreateAccountComponent,
    AccountDetailsComponent,
    UpdateAccountComponent,
    MenuListComponent,
    MenuDetailsComponent,
    CreateMenuComponent,
    UpdateMenuComponent
  ],
  imports: [
    BrowserModule,
    LeafletModule.forRoot(),
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (http: HttpClient) => {
          return new TranslateHttpLoader(http);
        },
        deps: [ HttpClient ]
      }
    }),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

// required for AOT compilation
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}