package com.employee.service;

import java.util.Map;

import com.employee.dao.EmployeeDB;
import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;

/**
 * <h> Implements the EmployeeDB interface </h>
 */
 public class EmployeeServiceImplVersion2 implements EmployeeDB {
    final EmployeeDao EMPLOYEEDAO = new EmployeeDao();
    
    public void addEmployee(Employee employee) {
        EMPLOYEEDAO.addEmployee(employee);
    }
 
    public Map<Integer, Employee> viewEmployeeData() {
        return EMPLOYEEDAO.viewEmployeeData();
    }

    public void deleteEmployee(int employeeId) {
        EMPLOYEEDAO.deleteEmployee(employeeId);
    }

    public void updateEmployeeDetails(Employee employee) {
        EMPLOYEEDAO.updateEmployeeDetails(employee);
    }
}
