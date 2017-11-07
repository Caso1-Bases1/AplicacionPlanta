package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DefaultController;

public class EmployeesByDeparmentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6646435025228429264L;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public EmployeesByDeparmentView() {
this.setLayout(null);
		
		JLabel lblConsultarEmpleadosA = new JLabel("Consultar empleados por departamento");
		lblConsultarEmpleadosA.setBounds(88, 11, 295, 14);
		add(lblConsultarEmpleadosA);
		
		JLabel lblIngreseElCdigo = new JLabel("Ingrese el departamento ");
		lblIngreseElCdigo.setBounds(26, 77, 184, 14);
		add(lblIngreseElCdigo);
		
		textField = new JTextField();
		textField.setBounds(258, 74, 94, 20);
		add(textField);
		textField.setColumns(10);		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Si devuelve un resultado vuelve la tabla visible
				if (textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Ingrese el departamento");
				} else {
					String departmentCode = "";
					try {
						departmentCode = textField.getText();
						
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						table = new JTable(defaultTableModel);
						table.setFillsViewportHeight(true);
						table.setOpaque(false);	
						
						defaultTableModel.addColumn("Nombre");
						defaultTableModel.addColumn("Apellidos");
						defaultTableModel.addColumn("Fecha Ingreso");
						defaultTableModel.addColumn("Salario");
						defaultTableModel.addColumn("Apellidos");
						defaultTableModel.addColumn("Cod Supervisor");
						defaultTableModel.addColumn("Tipo empleado");
						
						DefaultController defaultController = new DefaultController();
						defaultController.getEmployeesByDepartment(departmentCode, defaultTableModel);
						
						add(new JScrollPane(table)).setBounds(25, 175, 550, 350);						
					} catch (NumberFormatException nfex){
						JOptionPane.showMessageDialog(null, "Ingrese el departamento correctamente");
					}
				}				
			}
		});
					
		btnBuscar.setBounds(99, 125, 89, 23);
		add(btnBuscar);	
	}

}
