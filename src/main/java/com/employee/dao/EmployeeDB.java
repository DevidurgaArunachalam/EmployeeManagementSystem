package com.employee.dao;

import com.employee.model.Employee;

public interface EmployeeDB {
    void addEmployee(Employee employee);
    
    void viewEmployeeData();
    
    void deleteEmployee(int employeeId);
    
    void updateEmployeeDetails(Employee employee);
}
