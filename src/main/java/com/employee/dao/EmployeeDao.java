package com.employee.dao;

import java.util.Map;

import com.employee.exception.CustomException.DataNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.exception.CustomException.IdNotFoundException;
import com.employee.model.Employee;

/**
* <h> Inteface created for Employee database </h>
*/
public interface EmployeeDao {
    void addEmployee(final Employee employee) throws IdAlreadyExistsException;
    
    Map<Integer, Employee> viewEmployeeData() throws DataNotFoundException;
    
    void deleteEmployee(final int employeeId) throws IdNotFoundException;
    
    void updateEmployeeDetails(final Employee employee) throws IdNotFoundException;
}
