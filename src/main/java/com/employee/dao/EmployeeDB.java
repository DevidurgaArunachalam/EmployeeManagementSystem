package com.employee.dao;

import java.util.Map;

import com.employee.model.Employee;

/**
* <h> Inteface created for Employee database </h>
*/
public interface EmployeeDB {
    void addEmployee(final Employee employee);
    
    Map<Integer, Employee> viewEmployeeData();
    
    void deleteEmployee(final int employeeId);
    
    void updateEmployeeDetails(final Employee employee);
}
