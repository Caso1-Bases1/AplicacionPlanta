package core;

public class Employee {
	private int employee_code;
	private String name;
	private String apellidos;
	private String admissionDate;
	private String departureDate;
	private float salary;
	private String department;
	private int supervisorCode;
	private int employeeType;
	private int idPlant;
	
	public Employee(int employee_code, String name, String apellidos, String admissionDate, String departureDate,
			float salary, String department, int supervisorCode, int employeeType, int idPlant) {
		super();
		this.employee_code = employee_code;
		this.name = name;
		this.apellidos = apellidos;
		this.admissionDate = admissionDate;
		this.departureDate = departureDate;
		this.salary = salary;
		this.department = department;
		this.supervisorCode = supervisorCode;
		this.employeeType = employeeType;
		this.idPlant = idPlant;
	}

	public Employee(int employeeCode) {
		this.employee_code = employeeCode;
	}

	public int getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(int employee_code) {
		this.employee_code = employee_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSupervisorCode() {
		return supervisorCode;
	}
	public void setSupervisorCode(int supervisorCode) {
		this.supervisorCode = supervisorCode;
	}
	public int getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}
	public int getIdPlant() {
		return idPlant;
	}
	public void setIdPlant(int idPlant) {
		this.idPlant = idPlant;
	}
	@Override
	public String toString() {
		return "Employee [employee_code=" + employee_code + ", name=" + name + ", apellidos=" + apellidos
				+ ", admissionDate=" + admissionDate + ", departureDate=" + departureDate + ", salary=" + salary
				+ ", department=" + department + ", supervisorCode=" + supervisorCode + ", employeeType=" + employeeType
				+ ", idPlant=" + idPlant + "]";
	}	
}
