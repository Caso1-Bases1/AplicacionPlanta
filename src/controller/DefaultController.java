package controller;

import javax.swing.table.DefaultTableModel;

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

	public boolean loadCalendar() {
		return defaultModel.loadCalendar();
	}
	
	public boolean getEmployeesBySupervisor(int supervisorCode, DefaultTableModel model){
		return defaultModel.getEmployeesBySupervisor(supervisorCode, model);
	}

	public boolean getEmployeesByDepartment(String departmentCode, DefaultTableModel defaultTableModel) {
		return defaultModel.getEmployeesByDepartment(departmentCode, defaultTableModel);
	}
	
	public boolean getEmployeesAbsece(String startDate, String endDate, DefaultTableModel defaultTableModel) {
		return defaultModel.getEmployeesAbsence(startDate, endDate, defaultTableModel);
	}

	public boolean getEmployeesLates(String startDate, String endDate, String entryHour, DefaultTableModel model) {
		return defaultModel.getEmployeesLates (startDate, endDate, entryHour, model);
	}

	public boolean getEmployeesWithOutExitTime(String startDate, String endDate, DefaultTableModel model) {
		return defaultModel.getEmployeesWithOutExitTime(startDate, endDate, model);
	}

	public boolean getDismissedEmployees(String startDate, String endDate, DefaultTableModel model) {
		return defaultModel.getDismissedEmployees(startDate, endDate, model);
	}

	public boolean generateCalendarByEmployeeType(int employeeType, String startDate, String endDate, String payroll, String payDate, int amountOfWorkingDays) {
		return defaultModel.generateCalendarByEmployeeType(employeeType, startDate, endDate, payroll, payDate, amountOfWorkingDays);
	}
	
	public boolean getPaymentByPeriodOfTime (int employeeCode, String startDate, String endDate, DefaultTableModel model){
		return defaultModel.getPaymentByPeriodOfTime (employeeCode, startDate, endDate, model);
	}
}
