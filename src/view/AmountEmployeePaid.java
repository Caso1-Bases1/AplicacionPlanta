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

public class AmountEmployeePaid extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7811028047564446157L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AmountEmployeePaid() {
		this.setLayout(null);
		
		
		JLabel lblMontoPagadoA = new JLabel("Monto pagado a un empleado en un periodo de tiempo");
		lblMontoPagadoA.setBounds(59, 11, 310, 14);
		add(lblMontoPagadoA);
		
		JLabel lblCdigoDeEmpleado = new JLabel("C\u00F3digo de empleado");
		lblCdigoDeEmpleado.setBounds(34, 58, 117, 14);
		add(lblCdigoDeEmpleado);
		
		textField = new JTextField();
		textField.setBounds(196, 55, 117, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaDesde = new JLabel("Fecha desde");
		lblFechaDesde.setBounds(34, 92, 117, 14);
		add(lblFechaDesde);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 89, 117, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setBounds(34, 129, 117, 14);
		add(lblHasta);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 126, 117, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Ingrese los campos");
				} else {
					try {
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						table = new JTable(defaultTableModel);
						table.setFillsViewportHeight(true);
						table.setOpaque(false);	
						
						defaultTableModel.addColumn("Código");
						defaultTableModel.addColumn("Nombre");
						defaultTableModel.addColumn("Apellido");
						defaultTableModel.addColumn("Salario normal");
						defaultTableModel.addColumn("Salario extra");
						defaultTableModel.addColumn("Salario total");
						
						DefaultController defaultController = new DefaultController();
						defaultController.getPaymentByPeriodOfTime(Integer.parseInt(textField.getText()), textField_1.getText(), 
								textField_2.getText(), defaultTableModel);
						
						add(new JScrollPane(table)).setBounds(50, 200, 550, 300);
					} catch (NumberFormatException nfex){
						JOptionPane.showMessageDialog(null, "Ingrese el código de empleado correctamente. Es un campo numérico");
					}
				}
			}
		});
		btnConsultar.setBounds(34, 167, 89, 23);
		add(btnConsultar);
	}
}
