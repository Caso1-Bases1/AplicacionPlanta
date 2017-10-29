package core;

import java.sql.Date;

public class Holiday {
	private Date date;
	private boolean doublePay;
	
	public Holiday(Date date, boolean doublePay) {
		super();
		this.date = date;
		this.doublePay = doublePay;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isDoublePay() {
		return doublePay;
	}
	public void setDoublePay(boolean doublePay) {
		this.doublePay = doublePay;
	}
	@Override
	public String toString() {
		return "Holaday [date=" + date + ", doublePay=" + doublePay + "]";
	}	
}
