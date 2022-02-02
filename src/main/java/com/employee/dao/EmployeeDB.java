package com.employee.dao;

import com.employee.model.Employee;
/**
* Inteface created for Employee database
*/
public interface EmployeeDB {
    void addEmployee(Employee employee);
    
    void viewEmployeeData();
    
    void deleteEmployee(int employeeId);
    
    void updateEmployeeDetails(Employee employee);
}
