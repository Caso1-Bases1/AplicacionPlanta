package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.table.DefaultTableModel;

import util.DBConnection;
import util.Utility;

public class DefaultModel {

    private Connection connection;

    public DefaultModel() {
        connection = DBConnection.getInstance().connect();
    }

    public int employeeNextCode() {
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

    public boolean loadCalendar() {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.LOAD_CALENDAR);
            boolean hasResults = cStmt.execute();
            System.out.println(hasResults);
            return hasResults;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
        } finally {
            DBConnection.getInstance().disconnect();
        }
        return false;
    }

    public boolean getEmployeesBySupervisor(int supervisorCode, DefaultTableModel model) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.EMPLOYEES_BY_SUPERVISOR);
            cStmt.setInt(1, supervisorCode);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"Nombre", "Apellido", "Fecha ingreso", "Salario", "Supervisor", "Tipo empleado"};
            model.setColumnIdentifiers(newIdentifiers);
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }

    public boolean getEmployeesByDepartment(String departmentCode, DefaultTableModel model) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.EMPLOYEES_BY_DEPARTMENT);
            cStmt.setString(1, departmentCode);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"Nombre", "Apellido", "Fecha ingreso", "Salario", "Supervisor", "Tipo empleado"};
            model.setColumnIdentifiers(newIdentifiers);
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }

    public boolean getEmployeesAbsence(String startDate, String endDate, DefaultTableModel model) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.EMPLOYEES_ABSENCE);
            cStmt.setString(1, startDate);
            cStmt.setString(2, endDate);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"Nombre", "Apellido", "Hora de entrada", "Hora de salida", "Supervisor", "Departamento"};
            model.setColumnIdentifiers(newIdentifiers);
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }

    public boolean getEmployeesLates(String startDate, String endDate, String entryHour, DefaultTableModel model) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.EMPLOYEES_LATES);
            cStmt.setString(1, startDate);
            cStmt.setString(2, endDate);
            cStmt.setString(3, entryHour);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"Nombre", "Apellido", "Hora de entrada", "Hora de salida", "Supervisor", "Departamento"};
            model.setColumnIdentifiers(newIdentifiers);
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }

    public boolean getEmployeesWithOutExitTime(String startDate, String endDate, DefaultTableModel model) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.EMPLOYEES_WITHOUT_EXIT_TIME);
            cStmt.setString(1, startDate);
            cStmt.setString(2, endDate);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[2];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"C�digo de empleado", "Marca de entrada"};
            model.setColumnIdentifiers(newIdentifiers);
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }

    public boolean getDismissedEmployees(String startDate, String endDate, DefaultTableModel model) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.EMPLOYEES_DISSMISED);
            cStmt.setString(1, startDate);
            cStmt.setString(2, endDate);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"C�digo de empleado", "Nombre", "Apellidos", "Fecha de ingreso"};
            model.setColumnIdentifiers(newIdentifiers);
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }

    public boolean generateCalendarByEmployeeType(int employeeType, String startDate, String endDate, String payroll, String payDate, int amountOfWorkingDays) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.LOAD_CALENDAR_BY_EMPLOYEE_TYPE);
            cStmt.setInt(1, employeeType);
            cStmt.setString(2, startDate);
            cStmt.setString(3, endDate);
            cStmt.setString(4, payroll);
            cStmt.setString(5, payDate);
            cStmt.setInt(6, amountOfWorkingDays);

            boolean hasResults = cStmt.execute();
            System.out.println(hasResults);
            return hasResults;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }

    public boolean getPaymentByPeriodOfTime(int employeeCode, String startDate, String endDate, DefaultTableModel model) {
        CallableStatement cStmt;
        try {
            cStmt = connection.prepareCall(Utility.PAYMEND_EMPLOYEE_PERIOD);
            cStmt.setInt(1, employeeCode);
            cStmt.setString(2, startDate);
            cStmt.setString(3, endDate);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[6];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"Código", "Nombre", "Apellidos", "Salario normal", "Salario extra", "Total salario"};
            model.setColumnIdentifiers(newIdentifiers);
            return true;
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
            return false;
        } finally {
            DBConnection.getInstance().disconnect();
        }
    }
}
