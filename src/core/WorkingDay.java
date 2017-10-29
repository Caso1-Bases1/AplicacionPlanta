package core;

import java.sql.Date;

public class WorkingDay {
	private Date date;
	private boolean workingDay;
	public WorkingDay(Date date, boolean workingDay) {
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
