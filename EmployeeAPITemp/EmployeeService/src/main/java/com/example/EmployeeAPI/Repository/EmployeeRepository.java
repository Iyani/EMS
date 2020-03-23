package com.example.EmployeeAPI.Repository;

import com.example.EmployeeAPI.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//   static void updateName(String employeeName) {
//   }

//   static void updateEmployee(String employeeName) {
//   }

   @Query("SELECT t FROM Employee t WHERE t.employeeName=:employeeName")
   List<Employee> findAllEmployeeByNameIgnoreCase(String employeeName);

   // List<Employee> deleteByName(String employeeName);
   @Modifying
   @Query("DELETE FROM Employee f WHERE f.employeeName=:employeeName")
   void deleteByName(String employeeName);
}


