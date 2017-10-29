package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.EmployeeController;
import core.Employee;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InsertEmployeeView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2589069129832800456L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public InsertEmployeeView() {
		this.setLayout(null);
		
		JLabel lblIngresoDeEmpleados = new JLabel("Ingreso de empleados");
		lblIngresoDeEmpleados.setBounds(167, 11, 161, 14);
		add(lblIngresoDeEmpleados);
		
		JLabel lblCdigoDeEmpleado = new JLabel("C\u00F3digo de empleado");
		lblCdigoDeEmpleado.setBounds(32, 48, 137, 14);
		add(lblCdigoDeEmpleado);
		
		textField = new JTextField();
		textField.setBounds(220, 45, 168, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 73, 137, 14);
		add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 70, 168, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(32, 98, 137, 14);
		add(lblApellidos);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 95, 168, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso");
		lblFechaDeIngreso.setBounds(32, 123, 137, 14);
		add(lblFechaDeIngreso);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 120, 168, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida");
		lblFechaDeSalida.setBounds(32, 148, 137, 14);
		add(lblFechaDeSalida);
		
		textField_4 = new JTextField();
		textField_4.setBounds(220, 145, 168, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblSalarioBruto = new JLabel("Salario bruto");
		lblSalarioBruto.setBounds(32, 173, 137, 14);
		add(lblSalarioBruto);
		
		textField_5 = new JTextField();
		textField_5.setBounds(220, 170, 168, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(32, 198, 137, 14);
		add(lblDepartamento);
		
		textField_6 = new JTextField();
		textField_6.setBounds(220, 195, 168, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setBounds(32, 222, 137, 14);
		add(lblSupervisor);
		
		textField_7 = new JTextField();
		textField_7.setBounds(220, 219, 168, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblTipoDeEmpleado = new JLabel("Tipo de empleado");
		lblTipoDeEmpleado.setBounds(32, 247, 137, 14);
		add(lblTipoDeEmpleado);
		
		textField_8 = new JTextField();
		textField_8.setBounds(220, 244, 168, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int plantNumber = PrincipalWindow.PLANT_NUMBER;
				
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() 
						|| textField_3.getText().isEmpty() || textField_5.getText().isEmpty() || textField_6.getText().isEmpty()
						|| textField_7.getText().isEmpty() || textField_8.getText().isEmpty()){
					try {
						Date fechaSalida = null;
						Date fechaIngreso = new Date();
						
						String [] dateParametters1 = textField_3.getText().split("-");
						
						fechaIngreso.setDate(Integer.parseInt(dateParametters1[0]));
						fechaIngreso.setMonth(Integer.parseInt(dateParametters1[1]));
						fechaIngreso.setYear(Integer.parseInt(dateParametters1[2]));
						
						if (!textField_4.getText().isEmpty()){
							String [] dateParametters = textField_4.getText().split("-");
							fechaSalida = new Date();
							fechaSalida.setDate(Integer.parseInt(dateParametters[0]));
							fechaSalida.setMonth(Integer.parseInt(dateParametters[1]));
							fechaSalida.setYear(Integer.parseInt(dateParametters[2]));
							
							Employee employee = new Employee(
									Integer.parseInt(textField.getText()), 
									textField_1.getText(),
									textField_2.getText(), 
									fechaIngreso, fechaSalida, 
									Float.parseFloat(textField_5.getText()),
									textField_6.getText(),
									Integer.parseInt(textField_7.getText()), 
									Integer.parseInt(textField_8.getText()),
									plantNumber);
							EmployeeController controller = new EmployeeController(employee);
							boolean employeeInserted = controller.insert();
							
							if (employeeInserted){
								JOptionPane.showMessageDialog(null, "Empleado ingresado");
							} else {
								JOptionPane.showMessageDialog(null, "No se pudo ingresar el empleado");
							}
						}
					} catch (NumberFormatException nfex) {
						JOptionPane.showMessageDialog(null, "Error en los valores ingresados");
					}
				}
			}
		});
		btnIngresar.setBounds(171, 290, 89, 23);
		add(btnIngresar);
	}
}
