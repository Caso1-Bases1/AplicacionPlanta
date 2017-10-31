package core;

public class Holiday {
	private String date;
	private boolean doublePay;
	
	public Holiday(String date, boolean doublePay) {
		super();
		this.date = date;
		this.doublePay = doublePay;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
