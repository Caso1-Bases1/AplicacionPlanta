package core;

public class Marks {
	private int marckCode;
	private int employeeCode;
	private String startDateTime;
	private String endDateTime;
	
	public Marks(int marckCode, int employeeCode, String startDateTime, String endDateTime) {
		super();
		this.marckCode = marckCode;
		this.employeeCode = employeeCode;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}
	
	public Marks(int marckCode, String startDateTime, String endDateTime) {
		this.marckCode = marckCode;
	}
	public int getMarckCode() {
		return marckCode;
	}
	public void setMarckCode(int marckCode) {
		this.marckCode = marckCode;
	}
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public 	String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	@Override
	public String toString() {
		return "Marks [marckCode=" + marckCode + ", employeeCode=" + employeeCode + ", startDateTime=" + startDateTime
				+ ", endDateTime=" + endDateTime + "]";
	}
}
