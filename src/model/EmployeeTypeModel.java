package model;

import core.EmployeeType;

public class EmployeeTypeModel {
	
	private EmployeeType employeeType;
	
	public EmployeeTypeModel(EmployeeType employeeType){
		this.employeeType = employeeType;
	}
	
	public boolean insert() {	
		return false;
	}

	public EmployeeType update() {
		return employeeType;
	}

	public boolean delete() {		
		return false;
	}

	public EmployeeType search() {
		return employeeType;
	}
}
