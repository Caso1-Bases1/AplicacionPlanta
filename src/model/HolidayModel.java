package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import core.Holiday;
import util.DBConnection;
import util.Utility;

public class HolidayModel {

	private Holiday holiday;
	private Connection connection;
	
	public HolidayModel(Holiday holiday){
		this.holiday = holiday;
		this.connection = DBConnection.getInstance().connect();
	}
	
	public HolidayModel() {
		this.connection = DBConnection.getInstance().connect();
	}

	public boolean insert() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.INSERT_HOLIDAY);
			
			cStmt.setString(1, holiday.getDate());
			cStmt.setBoolean(2, holiday.isDoublePay());
			
			cStmt.execute();
			if (cStmt.getUpdateCount() != 0){
				return true;
			}
			return false;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return false;
		} finally {
			DBConnection.getInstance().disconnect();
		}	
	}

	public Holiday update() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.UPDATE_HOLIDAY);
			
			cStmt.setString(1, holiday.getDate());
			cStmt.setBoolean(2, holiday.isDoublePay());
			
			cStmt.execute();
			return holiday;
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
			cStmt = connection.prepareCall(Utility.DELETE_HOLIDAY);
			cStmt.setString(1, holiday.getDate());
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

	public Holiday search() {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.SEARCH_HOLIDAY);
			cStmt.setString(1, holiday.getDate());
			ResultSet rs = cStmt.executeQuery();
			
			while (rs.next()) {				
				holiday.setDate(rs.getString("fecha"));
				holiday.setDoublePay(rs.getBoolean("pago_doble"));
				return holiday;
			}
			return null;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
			return null;
		} finally {
			DBConnection.getInstance().disconnect();
		}
	}

	public void getAllHolidays(DefaultTableModel model) {
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.GET_ALL_HOLIDAYS);
			ResultSet rs = cStmt.executeQuery();
			Object [] fila = new Object[3];
			while (rs.next()) {
				for (int i=0;i<2;i++) {
					Object object = rs.getObject(i+1);
					if (object instanceof Boolean){
						boolean doublePay = (Boolean) object;
						fila[i] = doublePay ? "Si": "No";
					} else {
						fila[i] = object;
					}
				      
				}				
				model.addRow(fila);
			}
			Object [] newIdentifiers = {"Fecha", "Es pagado doble"};
			model.setColumnIdentifiers(newIdentifiers);
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta"); 
			System.err.println(e.getMessage());
		} finally {
			DBConnection.getInstance().disconnect();
		}
	}
}
