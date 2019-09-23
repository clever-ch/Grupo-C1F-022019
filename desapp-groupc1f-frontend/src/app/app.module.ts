import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
          apiKey: 'AIzaSyB09o2z9h0n9JbH-z00PZu9xa6jzCRPLHg'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
