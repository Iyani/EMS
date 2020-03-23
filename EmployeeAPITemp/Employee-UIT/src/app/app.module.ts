import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import {FormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './employee/create-employee.component';
import { TableEmployeeComponent } from './employee/table-employee.component';
import {HttpClientModule} from '@angular/common/http';
import {CreateEmployeeService} from './create-employee.service';


@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    TableEmployeeComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [CreateEmployeeService],
  bootstrap: [AppComponent]

})
export class AppModule { }
