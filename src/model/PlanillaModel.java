/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import core.Planilla;
import core.SystemStructures;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;
import util.DBSQLServer;
import util.Utility;
import view.PrincipalWindow;

/**
 *
 * @author Nelson
 */
public class PlanillaModel {

    private Connection connection;
    private Connection connectionSQLServer;

    public PlanillaModel() {
        this.connection = DBConnection.getInstance().connect();
        this.connectionSQLServer = DBSQLServer.getInstance().connect();
    }

    public List<Planilla> getPlanilla(DefaultTableModel model, String fechaInicial, String fechaFinal, int periodoPago) {
        CallableStatement cStmt;
        int idPlanta = PrincipalWindow.PLANT_NUMBER;
        SystemStructures ss = new SystemStructures();
        List<Planilla> planillas = ss.getContenidoPlanilla();
        try {
            int idPlanilla = generarPlanillaSinConfirmar(fechaFinal);

            this.connection = DBConnection.getInstance().connect();
            cStmt = connection.prepareCall(Utility.GENERAR_PLANILLA);
            cStmt.setString(1, fechaInicial);
            cStmt.setString(2, fechaFinal);

            ResultSet rs = cStmt.executeQuery();
            Object[] fila = new Object[6];
            while (rs.next()) {
                Planilla planilla = new Planilla();
                planilla.setIdPlanilla(idPlanilla);
                planilla.setCodigoEmpleado(rs.getInt(1));
                planilla.setIdPlanta(idPlanta);
                planilla.setPeriodoPago(periodoPago);
                planilla.setSalarioBruto(rs.getFloat(5));
                planilla.setSalarioNeto(rs.getFloat(4));
                for (int i = 1; i < fila.length; i++) {
                    fila[i - 1] = rs.getObject(i + 1);
                }
                planillas.add(planilla);
                model.addRow(fila);
            }
            Object[] newIdentifiers = {"Nombre", "Apellido", "Salario Neto", "Salario Bruto"};
            model.setColumnIdentifiers(newIdentifiers);           
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
        } finally {
            DBConnection.getInstance().disconnect();
            DBSQLServer.getInstance().disconnect();
        }    
            
        return planillas;
    }

    private int generarPlanillaSinConfirmar(String fechaInicial) {
        CallableStatement cStmt;
        int idPlanta = PrincipalWindow.PLANT_NUMBER;
        int idPlanilla = 0;
        try {
            cStmt = connectionSQLServer.prepareCall(Utility.NUEVA_PLANILLA);
            cStmt.setInt(1, idPlanta);
            cStmt.setString(2, fechaInicial);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {
                idPlanilla = rs.getInt("idPlanilla");
            }            
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
        } finally {
            DBConnection.getInstance().disconnect();
            DBSQLServer.getInstance().disconnect();
        }
        return idPlanilla;                                        
    }
    
    public void aprovarPlanilla (List<Planilla> planillas, String fechaInicial){
        CallableStatement cStmt;
        int idPlanta = PrincipalWindow.PLANT_NUMBER;
        
        try {
            cStmt = connectionSQLServer.prepareCall(Utility.APROBAR_PLANILLA);
            cStmt.setInt(1, idPlanta);
            cStmt.setString(2, fechaInicial);
            cStmt.execute();
            
            
            for (Planilla planilla : planillas) {
                cStmt = connectionSQLServer.prepareCall(Utility.INGRESAR_CONTENIDO_PLANILLA);
                cStmt.setInt(1, planilla.getCodigoEmpleado());
                cStmt.setInt(2, planilla.getPeriodoPago());
                cStmt.setFloat(3, planilla.getSalarioBruto());
                cStmt.setFloat(4, planilla.getSalarioNeto());
                cStmt.setInt(5, planilla.getIdPlanilla());
                cStmt.setInt(6, planilla.getIdPlanta());
                cStmt.execute();
            }            
            
            JOptionPane.showMessageDialog(null, "Planilla aprobada");
        } catch (SQLException | NullPointerException e) {
            System.err.println("No se pudo realizar la consulta");
            System.err.println(e.getMessage());
        } finally {
            DBConnection.getInstance().disconnect();
            DBSQLServer.getInstance().disconnect();
        }
    }
}
