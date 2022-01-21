package com.employee.main;

import com.employee.controller.EmployeeController;
import com.employee.view.EmployeeDetails;

public class EmployeeManagement extends EmployeeDetails {
	final static EmployeeController EMPLOYEECONTROLLER = new EmployeeController();
	
	public static void main(String[] args) {
		int choice;

		do {
			System.out.println(
					"\nEmployee Management System\n1.Add Employee\n2.View EmployeeList\n3.Update Employee Details\n4.Delete Employee details\nEnter your choice :");
			choice = SCANNER.nextInt();

			switch (choice) {
			case 1:
				EMPLOYEECONTROLLER.addDetails();
				break;
			case 2:
				EMPLOYEECONTROLLER.viewDetails();
				break;
			case 3:
				EMPLOYEECONTROLLER.updateDetails();
				break;
			case 4:
				EMPLOYEECONTROLLER.deleteDetails();
				break;
			default:
				SCANNER.close();
				System.exit(0);
			}
		} while (choice != 0);
	}

}