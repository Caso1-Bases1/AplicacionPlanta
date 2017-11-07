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

public class EmployeesWithoutExitTimeView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1602295395657325017L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	public EmployeesWithoutExitTimeView (){
		this.setLayout(null);
		
		JLabel lblEmpleadosSinMarca = new JLabel("Empleados sin marca de salida en un periodo de tiempo");
		lblEmpleadosSinMarca.setBounds(117, 11, 324, 14);
		add(lblEmpleadosSinMarca);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(28, 47, 46, 14);
		add(lblDesde);
		
		textField = new JTextField();
		textField.setBounds(106, 44, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setBounds(221, 47, 46, 14);
		add(lblHasta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(305, 44, 86, 20);
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
					defaultTableModel.addColumn("Marca de entrada");
					
					DefaultController defaultController = new DefaultController();
					defaultController.getEmployeesWithOutExitTime(textField.getText(), textField_1.getText(), defaultTableModel);
					
					add(new JScrollPane(table)).setBounds(25, 200, 700, 300);
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese el rango de fechas");
				}
			}
		});
		btnBuscar.setBounds(453, 43, 89, 23);
		add(btnBuscar);
	}
}
