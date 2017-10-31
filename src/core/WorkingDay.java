package core;

public class WorkingDay {
	
	private String date;
	private boolean workingDay;
	
	public WorkingDay(String date, boolean workingDay) {
		this.date = date;
		this.workingDay = workingDay;
	}
	
	public WorkingDay(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public boolean isWorkingDay() {
		return workingDay;
	}
	
	public void setWorkingDay(boolean workingDay) {
		this.workingDay = workingDay;
	}
	
	@Override
	public String toString() {
		return "WorkingDay [date=" + date + ", workingDay=" + workingDay + "]";
	}
}
