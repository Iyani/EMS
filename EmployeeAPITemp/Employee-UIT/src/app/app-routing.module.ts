import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './employee/create-employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee.component';
import { TableEmployeeComponent } from './employee/table-employee.component';

const routes: Routes = [
  { path: 'create', component:CreateEmployeeComponent },
  { path: 'update/:employeeName', component:CreateEmployeeComponent },
  { path: 'list', component:TableEmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
