import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreateEmployeeService {

  constructor(private http:HttpClient) { }

  public doRegistration(employee){
    console.log(employee);
    return this.http.post("http://localhost:8080/api/saveEmployee",employee, {responseType:'text' as 'json'})
  }

  public getAllEmployees(){
    return this.http.get("http://localhost:8080/api/employeesList")
  }

  //public deleteEmployee(employeeName){
    //    return this.http.delete("http://localhost:8080/api/deleteEmployee/"+employeeName)
  //}

  public deleteEmployeeById(id){
        return this.http.delete("http://localhost:8080/api/deleteEmployee/"+id)
  }
  public getEmployeeByName(employeeName){
        return this.http.get("http://localhost:8080/api/searchEmployee/"+employeeName)
  }

  public updateEmployee(employee){
        return this.http.put("http://localhost:8080/api/updateEmployee/"+employee.employeeName, employee)
  }
}
