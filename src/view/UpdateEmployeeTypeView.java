package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EmployeeTypeController;
import core.EmployeeType;

public class UpdateEmployeeTypeView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7906837717125417612L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private EmployeeType employeeType;
	/**
	 * Create the panel.
	 */
	public UpdateEmployeeTypeView() {
		this.setLayout(null);
		
		JLabel lblTiposDeEmpleado = new JLabel("Tipos de empleado");
		lblTiposDeEmpleado.setBounds(172, 11, 147, 14);
		add(lblTiposDeEmpleado);
		
		JLabel lblCodigoTipoDe = new JLabel("Codigo tipo de empleado");
		lblCodigoTipoDe.setBounds(36, 46, 187, 14);
		add(lblCodigoTipoDe);
		
		textField = new JTextField();
		textField.setBounds(233, 43, 111, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblSalarioPorHora = new JLabel("Salario por hora");
		lblSalarioPorHora.setBounds(36, 86, 187, 14);
		add(lblSalarioPorHora);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 83, 111, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSalarioPorHora_1 = new JLabel("Salario por hora extra");
		lblSalarioPorHora_1.setBounds(36, 129, 187, 14);
		add(lblSalarioPorHora_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 126, 111, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCantidadDe = new JLabel("Cantidad de horas por semana");
		lblCantidadDe.setBounds(36, 176, 187, 14);
		add(lblCantidadDe);
		
		textField_3 = new JTextField();
		textField_3.setBounds(233, 173, 111, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()){
					try {										
						employeeType = new EmployeeType(Integer.parseInt(textField.getText()), 0, 0, 0);
						EmployeeTypeController controller = new EmployeeTypeController(employeeType);
						employeeType = controller.search();
						textField_1.setText(employeeType.getHourSalary() + "");
						textField_2.setText(employeeType.getExtraHourSalary() + "");
						textField_3.setText(employeeType.getQuantityHours() + "");
					} catch (NumberFormatException nfex){
						JOptionPane.showMessageDialog(null, "N�mero del tipo de empleado indicado es incorrecto");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese el n�mero del tipo de empleado");
				}
			}
		});
		btnBuscar.setBounds(117, 231, 89, 23);
		add(btnBuscar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (employeeType == null){
					JOptionPane.showMessageDialog(null, "Ingrese el tipo de empleado");
				} else {
					employeeType = new EmployeeType(Integer.parseInt(textField.getText()), Float.parseFloat(textField_1.getText()), 
							Float.parseFloat(textField_2.getText()), Integer.parseInt(textField_3.getText()));
					EmployeeTypeController controller = new EmployeeTypeController(employeeType);
					EmployeeType employeeTypeUpdated = controller.update();
					if (employeeTypeUpdated == null){
						JOptionPane.showMessageDialog(null, "No se puedo actualizar el tipo de empleado");
					} else {
						JOptionPane.showMessageDialog(null, "Tipo de empleado actualizado");
					}
				}
			}
		});
		btnModificar.setBounds(255, 231, 89, 23);
		add(btnModificar);
	}
}
