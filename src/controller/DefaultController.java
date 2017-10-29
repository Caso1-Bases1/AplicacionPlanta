package controller;

import model.DefaultModel;

public class DefaultController {
	private DefaultModel defaultModel;
	
	public DefaultController(){
		defaultModel = new DefaultModel();
	}
	
	public int employeeNextCode(){
		return defaultModel.employeeNextCode();
	}
	
	public int employeeTypeNextCode (){
		return defaultModel.employeeTypeNextCode();
	}
}
