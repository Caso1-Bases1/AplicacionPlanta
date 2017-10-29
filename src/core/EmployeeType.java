package core;

public class EmployeeType {
	private int employeeTypeCode;
	private float hourSalary;
	private float extraHourSalary;
	private int quantityHours;
	public EmployeeType(int employeeTypeCode, float hourSalary, float extraHourSalary, int quantityHours) {
		super();
		this.employeeTypeCode = employeeTypeCode;
		this.hourSalary = hourSalary;
		this.extraHourSalary = extraHourSalary;
		this.quantityHours = quantityHours;
	}
	public int getEmployeeTypeCode() {
		return employeeTypeCode;
	}
	public void setEmployeeTypeCode(int employeeTypeCode) {
		this.employeeTypeCode = employeeTypeCode;
	}
	public float getHourSalary() {
		return hourSalary;
	}
	public void setHourSalary(float hourSalary) {
		this.hourSalary = hourSalary;
	}
	public float getExtraHourSalary() {
		return extraHourSalary;
	}
	public void setExtraHourSalary(float extraHourSalary) {
		this.extraHourSalary = extraHourSalary;
	}
	public int getQuantityHours() {
		return quantityHours;
	}
	public void setQuantityHours(int quantityHours) {
		this.quantityHours = quantityHours;
	}
	@Override
	public String toString() {
		return "EmployeeType [employeeTypeCode=" + employeeTypeCode + ", hourSalary=" + hourSalary
				+ ", extraHourSalary=" + extraHourSalary + ", quantityHours=" + quantityHours + "]";
	}	
}
