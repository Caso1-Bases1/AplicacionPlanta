package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import util.DBConnection;
import util.Utility;

public class PlantModel {

    private Connection connection;

    public PlantModel() {
        if (!DBConnection.isConnected()) {
            connection = DBConnection.getInstance().connect();
        }
    }

    public boolean modifyPlantNumber(int newCode) {
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

    public int getPlantNumber() {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.GET_PLANT_NUMBER);
            cStmt.registerOutParameter(1, Types.INTEGER);
            boolean hadResults = cStmt.execute();
            if (hadResults) {
                return cStmt.getInt(1) + 1;
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return -1;
        } finally {
            DBConnection.getInstance().disconnect();
        }
        return -1;
    }
}
