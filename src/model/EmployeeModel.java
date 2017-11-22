package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Employee;
import util.DBConnection;
import util.DBSQLServer;
import util.Utility;
import view.PrincipalWindow;

public class EmployeeModel {

    private Employee employee;
    private Connection connectionMySQL;
    private Connection connectionSQLServer;

    public EmployeeModel(Employee employee) {
        this.employee = employee;
        this.connectionMySQL = DBConnection.getInstance().connect();
        this.connectionSQLServer = DBSQLServer.getInstance().connect();
    }

    public boolean insert() {
        System.out.println(1);
        CallableStatement cStmt1, cStmt2;
        try {
            cStmt1 = connectionMySQL.prepareCall(Utility.INSERT_EMPLOYEE);

            cStmt1.setString(1, employee.getName());
            cStmt1.setString(2, employee.getApellidos());
            cStmt1.setString(3, employee.getAdmissionDate());
            cStmt1.setString(4, employee.getDepartureDate());
            cStmt1.setFloat(5, employee.getSalary());
            cStmt1.setString(6, employee.getDepartment());
            cStmt1.setInt(7, employee.getSupervisorCode());
            cStmt1.setInt(8, employee.getEmployeeType());
            cStmt1.setInt(9, PrincipalWindow.PLANT_NUMBER);

            cStmt1.execute();

            cStmt2 = connectionSQLServer.prepareCall(Utility.INSERT_EMPLOYEE);

            cStmt2.setString(1, employee.getName());
            cStmt2.setString(2, employee.getApellidos());
            cStmt2.setString(3, employee.getAdmissionDate());
            cStmt2.setString(4, employee.getDepartureDate());
            cStmt2.setFloat(5, employee.getSalary());
            cStmt2.setString(6, employee.getDepartment());
            cStmt2.setInt(7, employee.getSupervisorCode());
            cStmt2.setInt(8, employee.getEmployeeType());
            cStmt2.setInt(9, PrincipalWindow.PLANT_NUMBER);

            cStmt2.execute();
            System.out.println("insertó");
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

    public Employee update() {
        CallableStatement cStmt1, cStmt2;
        try {
            cStmt1 = connectionMySQL.prepareCall(Utility.UPDATE_EMPLOYEE);

            cStmt1.setInt(1, employee.getEmployee_code());
            cStmt1.setString(2, employee.getName());
            cStmt1.setString(3, employee.getApellidos());
            cStmt1.setString(4, employee.getAdmissionDate());
            cStmt1.setString(5, employee.getDepartureDate());
            cStmt1.setFloat(6, employee.getSalary());
            cStmt1.setString(7, employee.getDepartment());
            cStmt1.setInt(8, employee.getSupervisorCode());
            cStmt1.setInt(9, employee.getEmployeeType());
            cStmt1.setInt(10, PrincipalWindow.PLANT_NUMBER);

            cStmt1.execute();

            cStmt2 = connectionSQLServer.prepareCall(Utility.UPDATE_EMPLOYEE);

            cStmt2.setInt(1, employee.getEmployee_code());
            cStmt2.setString(2, employee.getName());
            cStmt2.setString(3, employee.getApellidos());
            cStmt2.setString(4, employee.getAdmissionDate());
            cStmt2.setString(5, employee.getDepartureDate());
            cStmt2.setFloat(6, employee.getSalary());
            cStmt2.setString(7, employee.getDepartment());
            cStmt2.setInt(8, employee.getSupervisorCode());
            cStmt2.setInt(9, employee.getEmployeeType());
            cStmt2.setInt(10, PrincipalWindow.PLANT_NUMBER);

            cStmt2.execute();
            return employee;
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
            cStmt1 = connectionMySQL.prepareCall(Utility.DELETE_EMPLOYEE);
            cStmt1.setInt(1, employee.getEmployee_code());
            cStmt1.execute();

            cStmt2 = connectionSQLServer.prepareCall(Utility.DELETE_EMPLOYEE);
            cStmt2.setInt(1, employee.getEmployee_code());
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

    public Employee search() {
        CallableStatement cStmt;
        try {
            cStmt = connectionMySQL.prepareCall(Utility.SEARCH_EMPLOYEE);
            cStmt.setInt(1, employee.getEmployee_code());
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {
                employee.setName(rs.getString("nombre"));
                employee.setApellidos(rs.getString("apellidos"));
                employee.setAdmissionDate(rs.getString("fecha_ingreso"));
                employee.setDepartureDate(rs.getString("fecha_salida"));
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
