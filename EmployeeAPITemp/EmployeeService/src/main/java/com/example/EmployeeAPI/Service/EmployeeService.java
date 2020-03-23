package com.example.EmployeeAPI.Service;


import java.util.List;
import com.example.EmployeeAPI.Model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@Component
public interface EmployeeService {
    //save function
    public Employee saveEmployee(Employee employee);

    //view function
    public List<Employee> getAllEmployees();

    //search function by name
   List<Employee> getEmployeeByName(String employeeName);

    //delete function
    public void deleteEmployee(long id);
  //public void deleteEmployee(String employeeName);

    // update function
    Employee updateEmployee(String employeeName, Employee employee);

}
