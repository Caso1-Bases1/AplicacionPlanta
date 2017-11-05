package controller;

import core.Employee;
import model.EmployeeModel;

public class EmployeeController {
	private EmployeeModel employeeModel;

	public EmployeeController(Employee employee) {
		this.employeeModel = new EmployeeModel(employee);
	}
	
	public boolean insert(){
		return this.employeeModel.insert();
	}
	
	public Employee update(){
		return this.employeeModel.update();
	}
	
	public Employee search(){
		return this.employeeModel.search();
	}
	
	public boolean delete(){
		return this.employeeModel.delete();
	}

	public EmployeeModel getDefaultModel() {
		return employeeModel;
	}

	public void setDefaultModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}
}
