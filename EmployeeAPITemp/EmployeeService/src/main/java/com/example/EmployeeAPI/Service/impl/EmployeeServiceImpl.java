package com.example.EmployeeAPI.Service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.EmployeeAPI.Repository.EmployeeRepository;
import com.example.EmployeeAPI.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.example.EmployeeAPI.DAO.Employee_DAO;
import com.example.EmployeeAPI.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> result = (List<Employee>) employeeRepository.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Employee>();
        }
    }

//    @Override
//    public void deleteEmployee(String employeeName) {
//        employeeRepository.deleteByName(employeeName);
//        //return employeeRepository.deleteByName(employeeName);
//    }


    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public List<Employee> getEmployeeByName(String employeeName) {
        List<Employee> listDetails = employeeRepository.findAllEmployeeByNameIgnoreCase(employeeName);

//        if (listDetails.size()>0) {
//            return listDetails;
//        } else {
//            return null;
//        }

        return listDetails;
    }


    @Override
    public Employee updateEmployee(String employeeName, Employee employee) {
        for (int i = 0; i < getAllEmployees().size(); i++) {
            Employee employee1 = getAllEmployees().get(i);
            if (employee1.getEmployeeName().equals(employeeName)) {
                employee1.setEmployeeEmail(employee.getEmployeeEmail());
                employee1.setDateOfBirth(employee.getDateOfBirth());
                employee1.setSkills(employee.getSkills());
                employee1 = employeeRepository.save(employee1);

                return employee1;
            }
        }
        return employee;
    }
}
