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

public class EmployeeBySupervisorView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -14779813333331585L;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public EmployeeBySupervisorView() {
		this.setLayout(null);
		
		JLabel lblConsultarEmpleadosA = new JLabel("Consultar empleados a cargo de un supervisor");
		lblConsultarEmpleadosA.setBounds(88, 11, 295, 14);
		add(lblConsultarEmpleadosA);
		
		JLabel lblIngreseElCdigo = new JLabel("Ingrese el c\u00F3digo del supervisor");
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
					JOptionPane.showMessageDialog(null, "Ingrese el c�digo del supervisor");
				} else {
					int supervisorCode = 0;
					try {
						supervisorCode = Integer.parseInt(textField.getText());
						
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
						defaultController.getEmployeesBySupervisor(supervisorCode, defaultTableModel);
						
						add(new JScrollPane(table)).setBounds(25, 175, 550, 350);						
					} catch (NumberFormatException nfex){
						JOptionPane.showMessageDialog(null, "Ingrese el c�digo del supervisor correctamente");
					}
				}				
			}
		});
					
		btnBuscar.setBounds(99, 125, 89, 23);
		add(btnBuscar);			
	}
}
