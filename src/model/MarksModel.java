package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Marks;
import util.DBConnection;
import util.Utility;

public class MarksModel {
	private Marks mark;
	private Connection connection;
	
	public MarksModel(Marks mark){
		this.mark = mark;
		this.connection = DBConnection.getInstance().connect();
	}
	
	public int insert() {		
		CallableStatement cStmt;
		ResultSet rs = null;
		int codeResult = 2;
		try {			
			if (mark.getEndDateTime() == null) {
				System.out.println(1);
				cStmt = connection.prepareCall(Utility.ENTRY_MARK);
				cStmt.setInt(1, mark.getEmployeeCode());
				cStmt.setString(2, mark.getStartDateTime());
				rs = cStmt.executeQuery();
			} else if (mark.getStartDateTime() == null){
				System.out.println(2);
				cStmt = connection.prepareCall(Utility.EXIT_MARK);
				cStmt.setInt(1, mark.getEmployeeCode());
				cStmt.setString(2, mark.getEndDateTime());
				rs = cStmt.executeQuery();
			}					
			while (rs.next()) {
				codeResult = Integer.parseInt(rs.getString("codigo"));
			}
			return codeResult;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return codeResult;
		} finally {
			DBConnection.getInstance().disconnect();
		}	
	}

	public Marks update() {
		return mark;
	}

	public boolean delete() {
		
		return false;
	}

	public Marks search() {
		return mark;
	}
}
