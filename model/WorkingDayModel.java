package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.WorkingDay;
import util.DBConnection;
import util.Utility;

public class WorkingDayModel {

	private WorkingDay workinDay;
	private Connection connection;
	
	public WorkingDayModel(WorkingDay workinDay) {
		this.workinDay = workinDay;
		this.connection = DBConnection.getInstance().connect();
	}

	public boolean insert() {
		
		return false;
	}

	public WorkingDay update() {		
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.UPDATE_WORKING_DAY);
			
			cStmt.setString(1, workinDay.getDate());
			cStmt.setBoolean(2, workinDay.isWorkingDay());
			
			cStmt.execute();
			return workinDay;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return null;
		} finally {
			DBConnection.getInstance().disconnect();
		}
	}

	public boolean delete() {
		
		return false;
	}

	public WorkingDay search() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.SEARCH_WORKING_DAY);
			cStmt.setString(1, workinDay.getDate());
			ResultSet rs = cStmt.executeQuery();
			
			while (rs.next()) {
				workinDay.setDate(rs.getString("fecha"));
				workinDay.setWorkingDay(rs.getBoolean("trabajado"));				
			}
			return workinDay;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return null;
		} finally {
			DBConnection.getInstance().disconnect();
		}	
	}

}
