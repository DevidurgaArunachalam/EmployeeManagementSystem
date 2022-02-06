package com.employee.service;

import java.util.Map;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;
import com.employee.exception.CustomException.DataNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.exception.CustomException.IdNotFoundException;
import com.employee.model.Employee;

/**
 * <h> Implements the EmployeeDB interface </h>
 */
 public class EmployeeServiceImplVersion2 implements EmployeeDao {
    final EmployeeDaoImpl EMPLOYEE_DAO = new EmployeeDaoImpl();
    
   /**
    * Adds the employee details to the database
    * 
    * @throws IdAlreadyExistsException
    */
    public void addEmployee(Employee employee) throws IdAlreadyExistsException {
        EMPLOYEE_DAO.addEmployee(employee);
    }
 
   /**
    * Shows all the employee details from the database
    * 
    * @throws DataNotFoundException
    */
    public Map<Integer, Employee> viewEmployeeData() throws DataNotFoundException {
        return EMPLOYEE_DAO.viewEmployeeData();
    }

   /**
    * Deletes the employee deatails from the database
    * 
    * @throws IdNotFoundException
    */
    public void deleteEmployee(int employeeId) throws IdNotFoundException {
        EMPLOYEE_DAO.deleteEmployee(employeeId);
    }

   /**
    * Updates the employee details from the database
    * 
    *  @throws IdNotFoundException
    */
    public void updateEmployeeDetails(Employee employee) throws IdNotFoundException {
        EMPLOYEE_DAO.updateEmployeeDetails(employee);
    }
}
