package core;

import java.util.Date;

public class WorkingDay {
	private Date date;
	private int workingDay;
	public WorkingDay(Date date, int workingDay) {
		super();
		this.date = date;
		this.workingDay = workingDay;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int isWorkingDay() {
		return workingDay;
	}
	public void setWorkingDay(int workingDay) {
		this.workingDay = workingDay;
	}
	@Override
	public String toString() {
		return "WorkingDay [date=" + date + ", workingDay=" + workingDay + "]";
	}
}
