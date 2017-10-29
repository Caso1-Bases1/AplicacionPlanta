package core;

import java.util.ArrayList;
import java.util.List;

public class SystemStructures {
	private List<Employee> employeeList;
	private List<EmployeeType> employeeTypeList;
	private List<Holiday> holidayList;
	private List<WorkingDay> workingDaysList;
	private List<Marks> marksList;
	
	public SystemStructures() {
		employeeList = new ArrayList<>();
		employeeTypeList = new ArrayList<>();
		holidayList = new ArrayList<>();
		workingDaysList  = new ArrayList<>();
		marksList = new ArrayList<>();
	}
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	public List<EmployeeType> getEmployeeTypeList() {
		return employeeTypeList;
	}
	
	public void setEmployeeTypeList(List<EmployeeType> employeeTypeList) {
		this.employeeTypeList = employeeTypeList;
	}
	
	public List<Holiday> getHolidayList() {
		return holidayList;
	}
	
	public void setHolidayList(List<Holiday> holidayList) {
		this.holidayList = holidayList;
	}
	
	public List<WorkingDay> getWorkingDaysList() {
		return workingDaysList;
	}
	
	public void setWorkingDaysList(List<WorkingDay> workingDaysList) {
		this.workingDaysList = workingDaysList;
	}

	public List<Marks> getMarksList() {
		return marksList;
	}

	public void setMarksList(List<Marks> marksList) {
		this.marksList = marksList;
	}	
}
