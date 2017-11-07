package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DefaultController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EmployeeAbsenceView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4318382909088468345L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public EmployeeAbsenceView() {
		this.setLayout(null);
		
		JLabel lblConsultaDeAusencias = new JLabel("Consulta de ausencias por periodo de tiempo");
		lblConsultaDeAusencias.setBounds(96, 11, 280, 14);
		add(lblConsultaDeAusencias);
		
		JLabel lblFechaInicial = new JLabel("Fecha inicial");
		lblFechaInicial.setBounds(28, 62, 92, 14);
		add(lblFechaInicial);
		
		JLabel lblFechaFinal = new JLabel("Fecha final");
		lblFechaFinal.setBounds(256, 62, 99, 14);
		add(lblFechaFinal);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty()){														
					DefaultTableModel defaultTableModel = new DefaultTableModel();
					table = new JTable(defaultTableModel);
					table.setFillsViewportHeight(true);
					table.setOpaque(false);	
					
					defaultTableModel.addColumn("Nombre");
					defaultTableModel.addColumn("Apellidos");
					defaultTableModel.addColumn("Hora de entrada");
					defaultTableModel.addColumn("Hora de salida");
					defaultTableModel.addColumn("Supervisor");
					defaultTableModel.addColumn("Departamento");
					
					
					DefaultController defaultController = new DefaultController();
					defaultController.getEmployeesAbsece(textField.getText(), textField_1.getText(), defaultTableModel);
					
					add(new JScrollPane(table)).setBounds(25, 200, 700, 300);
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese el rango de fechas");
				}
			}
		});
		btnConsultar.setBounds(57, 142, 89, 23);
		add(btnConsultar);
		
		textField = new JTextField();
		textField.setBounds(28, 87, 134, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 87, 134, 20);
		add(textField_1);
		textField_1.setColumns(10);
	}
}
