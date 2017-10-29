package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DefaultController;
import controller.EmployeeTypeController;
import core.EmployeeType;

public class InsertEmployeeTypeView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1703645883544092726L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private EmployeeType employeeType;
	/**
	 * Create the panel.
	 */
	public InsertEmployeeTypeView() {
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
		
		DefaultController defaultController = new DefaultController();
		int nextCode = defaultController.employeeTypeNextCode();
		if (nextCode == -1){
			JOptionPane.showMessageDialog(null, "No se pudo realizar la conexión con la base de datos");
		} else {
			textField.setText(nextCode + "");
			textField.setEnabled(false);
		}
		
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
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()){
					try {										
						employeeType = new EmployeeType(Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), 
								Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()));
						EmployeeTypeController controller = new EmployeeTypeController(employeeType);
						boolean employeeTypeUpdated = controller.insert();
						
						if (employeeTypeUpdated){
							JOptionPane.showMessageDialog(null, "Tipo de empleado ingresado");
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo ingresar el tipo de empleado");
						}
					} catch (NumberFormatException nfex){
						JOptionPane.showMessageDialog(null, "Número del tipo de empleado indicado es incorrecto");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese el número del tipo de empleado");
				}
			}
		});
		btnIngresar.setBounds(168, 231, 89, 23);
		add(btnIngresar);
	}
}
