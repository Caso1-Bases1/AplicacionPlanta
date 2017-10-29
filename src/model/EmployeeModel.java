package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Employee;
import util.DBConnection;
import util.Utility;
import view.PrincipalWindow;

public class EmployeeModel {
	
	private Employee employee;
	private Connection connection;
	
	public EmployeeModel(Employee employee){
		this.employee = employee;
		connection = DBConnection.getInstance().connect();
	}
	
	public boolean insert() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.INSERT_EMPLOYEE);
			
			cStmt.setString(1, employee.getName());
			cStmt.setString(2, employee.getApellidos());
			cStmt.setString(3, employee.getAdmissionDate());
			cStmt.setString(4, employee.getDepartureDate());
			cStmt.setFloat(5, employee.getSalary());
			cStmt.setString(6, employee.getDepartment());
			cStmt.setInt(7, employee.getSupervisorCode());
			cStmt.setInt(8, employee.getEmployeeType());
			cStmt.setInt(9, PrincipalWindow.PLANT_NUMBER);
			
			cStmt.execute();
			return true;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return false;
		} finally {
			DBConnection.getInstance().disconnect();
		}		
	}

	public Employee update() {
		return employee;
	}

	public boolean delete() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.DELETE_EMPLOYEE);
			cStmt.setInt(1, employee.getEmployee_code());
			cStmt.execute();				
			return true;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return false;
		} finally {
			DBConnection.getInstance().disconnect();
		}		
	}

	public Employee search() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.SEARCH_EMPLOYEE);
			cStmt.setInt(1, employee.getEmployee_code());
			ResultSet rs = cStmt.executeQuery();
			
			while (rs.next()){
				employee.setName(rs.getString("nombre"));
				employee.setApellidos(rs.getString("apellidos"));
				employee.setAdmissionDate(rs.getString("fecha_ingreso"));
				employee.setDepartment(rs.getString("fecha_salida"));
				employee.setSalary(Float.parseFloat(rs.getString("salario_bruto")));
				employee.setDepartment(rs.getString("departamento"));
				employee.setSupervisorCode(Integer.parseInt(rs.getString("supervidor")));
				employee.setEmployeeType(Integer.parseInt(rs.getString("tipo_empleado")));
				employee.setIdPlant(Integer.parseInt(rs.getString("id_planta")));
			}
			return employee;					
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return null;
		} finally {
			DBConnection.getInstance().disconnect();
		}			
	}
}
