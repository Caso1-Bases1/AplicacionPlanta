package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EmployeeController;
import core.Employee;

public class DeleteEmployeeView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8901734030971488733L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private Employee employeeInserted;
	/**
	 * Create the panel.
	 */
	public DeleteEmployeeView() {
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
		
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		textField_6.setEditable(false);
		textField_7.setEditable(false);
		textField_8.setEditable(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int plantNumber = PrincipalWindow.PLANT_NUMBER;
				
				if (!textField.getText().isEmpty()){
					try {
							Employee employee = new Employee(
									Integer.parseInt(textField.getText()), 
									"",
									"", 
									null, null, 
									0,
									"",
									0, 
									0,
									plantNumber);
							EmployeeController controller = new EmployeeController(employee);
							employeeInserted = controller.search();
							
							if (employeeInserted != null){
								textField_1.setText(employee.getName());
								textField_2.setText(employee.getApellidos());
								textField_3.setText(employee.getAdmissionDate());
								textField_4.setText(employee.getDepartureDate() == null ? "" : employee.getDepartureDate());
								textField_5.setText(employee.getSalary() + "");
								textField_6.setText(employee.getDepartment());
								textField_7.setText(employee.getSupervisorCode() + "");
								textField_8.setText(employee.getEmployeeType() + "");
							} else {
								JOptionPane.showMessageDialog(null, "No existe el empleado");
							}						
					} catch (NumberFormatException nfex) {
						JOptionPane.showMessageDialog(null, "Error en los valores ingresados");
					}
				}
			}
		});
		btnBuscar.setBounds(125, 289, 89, 23);
		add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (employeeInserted == null){
					JOptionPane.showMessageDialog(null, "Ingrese la información del empleado");
				} else {
					EmployeeController controller = new EmployeeController(employeeInserted);
					boolean deleted = controller.delete();
					if (deleted){
						JOptionPane.showMessageDialog(null, "El empleado ha sido eliminado");
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo eliminar el empleado");
					}
				}
			}
		});
		btnEliminar.setBounds(299, 289, 89, 23);
		add(btnEliminar);
	}
}
