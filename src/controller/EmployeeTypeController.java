package controller;

import core.EmployeeType;
import model.EmployeeTypeModel;

public class EmployeeTypeController {
	private EmployeeTypeModel employeeTypeModel;

	public EmployeeTypeController(EmployeeType employeeTypeModel) {
		this.employeeTypeModel = new EmployeeTypeModel(employeeTypeModel);
	}
	
	public boolean insert(){
		return this.employeeTypeModel.insert();
	}
	
	public EmployeeType update(){
		return this.employeeTypeModel.update();
	}
	
	public EmployeeType search(){
		return this.employeeTypeModel.search();
	}
	
	public boolean delete(){
		return this.employeeTypeModel.delete();
	}

	public EmployeeTypeModel getDefaultModel() {
		return employeeTypeModel;
	}

	public void setDefaultModel(EmployeeTypeModel employeeTypeModel) {
		this.employeeTypeModel = employeeTypeModel;
	}
}
