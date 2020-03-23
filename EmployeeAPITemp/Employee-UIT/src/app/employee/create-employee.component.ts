import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
//import * as EmailValidator from 'email-validator';
import {Employee} from '../Employee';
import { CreateEmployeeService} from '../create-employee.service';
import {ActivatedRoute,Router} from '@angular/router';
//import {IEmployee} from './IEmployee';
//import {ISkill} from './ISkill';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.styl']

})
export class CreateEmployeeComponent implements OnInit {

  constructor(private service:CreateEmployeeService, private router:Router, private route:ActivatedRoute) { }

    employeeForm: FormGroup;
    users:any;
    employee: Employee =new Employee("","","","");
    message:any;
    id:any;

  ngOnInit() {

    this.employeeForm = new FormGroup({
      employeeName: new FormControl('', Validators.required ),
      dateOfBirth : new FormControl('', Validators.required ),
      employeeEmail: new FormControl('', Validators.required);
      skills: new FormControl()
    });

     this.disableButtons(false,true);
    this.route.paramMap.subscribe(params => {
      const upEmployeeName = params.get('employeeName');
      if (upEmployeeName){
        this.getEmployee(upEmployeeName);
      }
    });
  }


   public boolean disableButtons(val1,val2){
    this.isSaveDisabled= val1;
    this.isUpdateDisabled =val2;
   }

  getEmployee(employeeName:string){
      this.disableButtons(true, false);
      let resp=this.service.getEmployeeByName(employeeName);
      resp.subscribe((data)=>this.editEmployee(data))
  }

  editEmployee(employee){
      this.employeeForm.patchValue({
        employeeName:employee[0].employeeName,
        dateOfBirth: employee[0].dateOfBirth,
        employeeEmail: employee[0].employeeEmail,
        skills: employee[0].skills
      });
      this.employeeForm.controls['employeeName'].disable();
  }


  onSubmit(): void {}

  public registerNow(){

    if (this.employeeForm.invalid){
       this.message = "Please fill the required details";
    }else{
      var partsOfStr = this.employee.skills.split(',');
      this.totalCount = partsOfStr.length;
      this.count =0
      for (let i = 0; i < this.totalCount; i++){
        if((partsOfStr[i] == "JAVA") || (partsOfStr[i] == "C") || (partsOfStr[i] == "Python") || (partsOfStr[i] == ".NET") || (partsOfStr[i] == "C#") || (partsOfStr[i] == "C++") || (partsOfStr[i] == "-")){
            this.count =this.count+1;
            if (this.count  == this.totalCount){
              let resp = this.service.doRegistration(this.employee);
              resp.subscribe((data)=> this.data)
              this.message = "Data successfully entered";
            }
        }else{
            this.message = "Skills should match with the list and put commas between two or more skills present";
        }
      }
    }
  }

  public updateNow(){

    var partsOfStr = this.employee.skills.split(',');
    this.totalCount = partsOfStr.length;
    this.count =0
    for (let i = 0; i < this.totalCount; i++){
      if((partsOfStr[i] == "JAVA") || (partsOfStr[i] == "C") || (partsOfStr[i] == "Python") || (partsOfStr[i] == ".NET") || (partsOfStr[i] == "C#") || (partsOfStr[i] == "C++")){
          this.count =this.count+1;
          if (this.count  == this.totalCount){
              this.service.updateEmployee(this.employee).subscribe(
                      () => this.router.navigate(['list'])
                );
          }
      }else{
          this.message = "Skills should match with the list and put commas between two or more skills present";
      }
    }
  }
}
