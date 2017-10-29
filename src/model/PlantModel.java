package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import util.DBConnection;
import util.Utility;

public class PlantModel {
	private Connection connection;	
	
	public PlantModel(){
		connection = DBConnection.getInstance().connect();
	}
	
	public boolean modifyPlantNumber (int newCode){
		CallableStatement cStmt;
		try {
			cStmt = connection.prepareCall(Utility.MODIFY_PLANT_CODE);
			cStmt.setInt(1, newCode);
			boolean hadResults = cStmt.execute();
			return hadResults;
		} catch (SQLException | NullPointerException e) {
			System.err.println("No se pudo realizar la consulta");
		} finally {
			DBConnection.getInstance().disconnect();
		}
		return false;
	}
}
