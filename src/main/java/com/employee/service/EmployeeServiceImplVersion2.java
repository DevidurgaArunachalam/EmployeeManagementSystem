package com.employee.service;

import com.employee.dao.EmployeeDB;
import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;

/**
 * Implements the EmployeeDB interface
 */
 public class EmployeeServiceImplVersion2 implements EmployeeDB {
    final EmployeeDao EMPLOYEEDAO = new EmployeeDao();
    
    public void addEmployee(Employee employee) {
        EMPLOYEEDAO.addEmployee(employee);
    }

    public void viewEmployeeData() {
        EMPLOYEEDAO.viewEmployeeData();
    }

    public void deleteEmployee(int employeeId) {
        EMPLOYEEDAO.deleteEmployee(employeeId);
    }

    public void updateEmployeeDetails(Employee employee) {
        EMPLOYEEDAO.updateEmployeeDetails(employee);
    }
}
