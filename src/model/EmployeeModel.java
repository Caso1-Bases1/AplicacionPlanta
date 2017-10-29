package model;

import core.Employee;

public class EmployeeModel {
	
	private Employee employee;
	
	public EmployeeModel(Employee employee){
		this.employee = employee;
	}
	
	public boolean insert() {
		return false;
	}

	public Employee update() {
		return employee;
	}

	public boolean delete() {		
		return false;
	}

	public Employee search() {		
		return employee;
	}
}
