package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.EmployeeType;
import util.DBConnection;
import util.DBSQLServer;
import util.Utility;

public class EmployeeTypeModel {

    private EmployeeType employeeType;
    private Connection connection;
    private Connection connectionSQLServer;

    public EmployeeTypeModel(EmployeeType employeeType) {
        this.employeeType = employeeType;
        this.connection = DBConnection.getInstance().connect();
        this.connectionSQLServer = DBSQLServer.getInstance().connect();
    }

    public boolean insert() {
        CallableStatement cStmt1, cStmt2;
        try {
            cStmt1 = connection.prepareCall(Utility.INSERT_EMPLOYEE_TYPE);

            cStmt1.setFloat(1, employeeType.getHourSalary());
            cStmt1.setFloat(2, employeeType.getExtraHourSalary());
            cStmt1.setInt(3, employeeType.getQuantityHours());

            cStmt1.execute();
            
            cStmt2 = connectionSQLServer.prepareCall(Utility.INSERT_EMPLOYEE_TYPE);

            cStmt2.setFloat(1, employeeType.getHourSalary());
            cStmt2.setFloat(2, employeeType.getExtraHourSalary());
            cStmt2.setInt(3, employeeType.getQuantityHours());

            cStmt2.execute();
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
            DBSQLServer.getInstance().disconnect(); 
        }
    }

    public EmployeeType update() {
        CallableStatement cStmt1, cStmt2;
        try {
            cStmt1 = connection.prepareCall(Utility.UPDATE_EMPLOYEE_TYPE);

            cStmt1.setInt(1, employeeType.getEmployeeTypeCode());
            cStmt1.setFloat(2, employeeType.getHourSalary());
            cStmt1.setFloat(3, employeeType.getExtraHourSalary());
            cStmt1.setInt(4, employeeType.getQuantityHours());

            cStmt1.execute();
                       
            cStmt2 = connectionSQLServer.prepareCall(Utility.UPDATE_EMPLOYEE_TYPE);

            cStmt2.setInt(1, employeeType.getEmployeeTypeCode());
            cStmt2.setFloat(2, employeeType.getHourSalary());
            cStmt2.setFloat(3, employeeType.getExtraHourSalary());
            cStmt2.setInt(4, employeeType.getQuantityHours());

            cStmt2.execute();
            return employeeType;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return null;
        } finally {
            DBConnection.getInstance().disconnect();
            DBSQLServer.getInstance().disconnect(); 
        }
    }

    public boolean delete() {
        CallableStatement cStmt1, cStmt2;
        try {
            cStmt1 = connection.prepareCall(Utility.DELETE_EMPLOYEE_TYPE);
            cStmt1.setInt(1, employeeType.getEmployeeTypeCode());           
                        
            cStmt2 = connection.prepareCall(Utility.DELETE_EMPLOYEE_TYPE);
            cStmt2.setInt(1, employeeType.getEmployeeTypeCode());
            boolean hasResult = cStmt2.execute();

            return hasResult;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
            DBSQLServer.getInstance().disconnect(); 
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
