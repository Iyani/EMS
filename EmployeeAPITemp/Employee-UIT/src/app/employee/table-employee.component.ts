import { Component, OnInit } from '@angular/core';
import { CreateEmployeeService} from '../create-employee.service';
import {ActivatedRoute,Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-table-employee',
  templateUrl: './table-employee.component.html',
  styleUrls: ['./table-employee.component.styl']
})
export class TableEmployeeComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private service:CreateEmployeeService) { }
  users:any;
  employeeName:any;
  id:any;
  ngOnInit(): void {
   let resp=this.service.getAllEmployees();
    resp.subscribe((data)=>this.users=data)
  }

   //public delEmployee(employeeName:string){
     // let resp=this.service.deleteEmployee(employeeName);
      //resp.subscribe((data)=>this.users=data)
   //}

  public delEmployeeById(id:any){
    let resp=this.service.deleteEmployeeById(id);
    resp.subscribe((data)=>this.users=data)
  }

  public findEmployeeByName(){
    let resp=this.service.getEmployeeByName(this.employeeName);
    resp.subscribe((data)=>this.users=data)
  }

  public editEmployee(employeeName:string){

    this.router.navigate(['/update/'+employeeName]);

  }

}
