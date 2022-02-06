package com.employee.main;

import com.employee.exception.CustomException.DataNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.view.EmployeeDetails;

/**
 * <p>
 *     Employee Management System using Collection by implementing 
 *     CRUD OPERATIONS like, add employee details,view details,update
 *     if needed and delete the details by providing switch case to follow the flow
 *     as per user's choice.
 * </p>
 * 
 * @author Devidurga Arunachalam
 */
public class EmployeeManagement {
   	public static void main(String[] args) throws IdAlreadyExistsException, DataNotFoundException {
	   int choice;
	  
	   do {
			System.out.println(
			    "\nEmployee Management System\n1.Add Employee\n2.View EmployeeList\n3.Update Employee Details\n4.Delete Employee details\nEnter your choice :");
			choice = EmployeeDetails.SCANNER.nextInt();

			switch (choice) {
			case 1:
			    EmployeeDetails.addEmployee();
				break;
			case 2:
			    EmployeeDetails.viewEmployeeDetails();
				break;
			case 3:
			    EmployeeDetails.updateEmployeeDetails();
				break;
			case 4:
			    EmployeeDetails.deleteEmployee();
				break;
 			default:
			    EmployeeDetails.SCANNER.close();
				System.exit(0);
			}
		} while (true);
	}
}

