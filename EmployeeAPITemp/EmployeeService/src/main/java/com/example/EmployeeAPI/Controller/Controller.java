package com.example.EmployeeAPI.Controller;

import java.util.List;

import com.example.EmployeeAPI.Repository.EmployeeRepository;
import com.example.EmployeeAPI.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.EmployeeAPI.Model.Employee;

@RestController

@CrossOrigin(origins="http://localhost:4200")

@RequestMapping(value="/api/")
public class Controller {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("saveEmployee")
    public Employee saveEmployeeX(@RequestBody Employee employee) {
        Employee employee1= employeeService.saveEmployee(employee);
        return employee1;
    }

    @GetMapping("employeesList")
    public List<Employee> getAllEmployees(Employee employee){
        List<Employee> list = employeeService.getAllEmployees();
        return list;
    }

//    @DeleteMapping("deleteEmployee/{employeeName}")
//    public List<Employee> deleteEmployee(@PathVariable ("employeeName") String employeeName) {
//        employeeService.deleteEmployee(employeeName);
//        List<Employee> list = employeeService.getAllEmployees();
//        return list;
//    }

    @DeleteMapping("deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable ("id") int id) {
        employeeService.deleteEmployee(id);
        List<Employee> list = employeeService.getAllEmployees();
        return list;
    }

    @GetMapping("searchEmployee/{employeeName}")
    public List<Employee> getEmployeeByName (@PathVariable("employeeName") String employeeName) {
        List<Employee> list = employeeService.getEmployeeByName(employeeName);
        return list;

    }

    @PutMapping("updateEmployee/{employeeName}")
    public Employee updateEmployee(@PathVariable ("employeeName")  String employeeName,@RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeName, employee);
    }
}