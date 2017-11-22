package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DefaultController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DismissedEmployeesView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7598840080868529165L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public DismissedEmployeesView() {
		this.setLayout(null);
		
		JLabel lblEmpleadosDadosDe = new JLabel("Empleados dados de baja en un periodo de tiempo");
		lblEmpleadosDadosDe.setBounds(86, 11, 341, 14);
		add(lblEmpleadosDadosDe);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(34, 55, 46, 14);
		add(lblDesde);
		
		textField = new JTextField();
		textField.setBounds(101, 52, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setBounds(212, 55, 46, 14);
		add(lblHasta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 52, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty()){
					DefaultTableModel defaultTableModel = new DefaultTableModel();
					table = new JTable(defaultTableModel);
					table.setFillsViewportHeight(true);
					table.setOpaque(false);	
					
					defaultTableModel.addColumn("Código de empleado");
					defaultTableModel.addColumn("Nombre");
					defaultTableModel.addColumn("Apellidos");
					defaultTableModel.addColumn("Fecha de ingreso");
					
					DefaultController defaultController = new DefaultController();
					defaultController.getDismissedEmployees(textField.getText(), textField_1.getText(), defaultTableModel);
					
					add(new JScrollPane(table)).setBounds(25, 200, 700, 300);
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese el rango de fechas");
				}
			}
		});
		btnBuscar.setBounds(447, 51, 89, 23);
		add(btnBuscar);
		
	}
}
