import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {CoachModule} from "./coach/coach.module";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {CoachService} from "./coach/coach.service";
import {AppRoutingModule} from "./app-routing.module";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoachModule,
    HttpModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [CoachService],
  bootstrap: [AppComponent]
})
export class AppModule { }
