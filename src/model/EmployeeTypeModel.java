package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.EmployeeType;
import util.DBConnection;
import util.Utility;

public class EmployeeTypeModel {
	
	private EmployeeType employeeType;
	private Connection connection;
	
	public EmployeeTypeModel(EmployeeType employeeType){
		this.employeeType = employeeType;
		this.connection = DBConnection.getInstance().connect();
	}
	
	public boolean insert() {	
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.INSERT_EMPLOYEE_TYPE);
			
			cStmt.setFloat(1, employeeType.getHourSalary());
			cStmt.setFloat(2, employeeType.getExtraHourSalary());
			cStmt.setInt(3, employeeType.getQuantityHours());
			
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

	public EmployeeType update() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.MODIFY_EMPLOYEE_TYPE);
			
			cStmt.setInt(1, employeeType.getEmployeeTypeCode());
			cStmt.setFloat(2, employeeType.getHourSalary());
			cStmt.setFloat(3, employeeType.getExtraHourSalary());
			cStmt.setInt(4, employeeType.getQuantityHours());
			
			cStmt.execute();
			return employeeType;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return null;
		} finally {
			DBConnection.getInstance().disconnect();
		}	
	}

	public boolean delete() {		
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.DELETE_EMPLOYEE_TYPE);
			cStmt.setInt(1, employeeType.getEmployeeTypeCode());
			boolean hasResult = cStmt.execute();
			
			return hasResult;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return false;
		} finally {
			DBConnection.getInstance().disconnect();
		}
	}

	public EmployeeType search() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.SEARCH_EMPLOYEE_TYPE);
			cStmt.setInt(1, employeeType.getEmployeeTypeCode());
			ResultSet rs = cStmt.executeQuery();
			
			while (rs.next()) {
				employeeType.setExtraHourSalary(rs.getFloat("salario_extra"));
				employeeType.setHourSalary(rs.getFloat("salario_hora"));
				employeeType.setQuantityHours(rs.getInt("cantidad_horas_semana"));
			}
			return employeeType;					
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return null;
		} finally {
			DBConnection.getInstance().disconnect();
		}
	}
}
