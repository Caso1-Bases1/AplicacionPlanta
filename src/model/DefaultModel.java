package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import util.DBConnection;
import util.Utility;

public class DefaultModel {
	private Connection connection;
	
	public DefaultModel(){
		connection = DBConnection.getInstance().connect();
	}
	
	public int employeeNextCode(){
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.NEXT_EMPLOYEE_CODE);
			cStmt.registerOutParameter(1, Types.INTEGER);
			cStmt.execute();
			return cStmt.getInt(1) + 1;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta");
			System.err.println(e.getMessage());
			return -1; 
		} finally {
			DBConnection.getInstance().disconnect();
		}		
	}

	public int employeeTypeNextCode() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.NEXT_EMPLOYEE_TYPE_CODE);
			cStmt.registerOutParameter(1, Types.INTEGER);
			cStmt.execute();
			return cStmt.getInt(1) + 1;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta");
			System.err.println(e.getMessage());
			return -1; 
		} finally {
			DBConnection.getInstance().disconnect();
		}	
	}
}
