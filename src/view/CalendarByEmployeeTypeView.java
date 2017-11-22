package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.DefaultController;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalendarByEmployeeTypeView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7925816733329897780L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public CalendarByEmployeeTypeView() {
		this.setLayout(null);
		
		JLabel lblCargarCalendarioPor = new JLabel("Cargar calendario por tipo de empleado");
		lblCargarCalendarioPor.setBounds(82, 11, 280, 14);
		add(lblCargarCalendarioPor);
		
		JLabel lblTipoDeEmpleado = new JLabel("Tipo de empleado");
		lblTipoDeEmpleado.setBounds(30, 61, 136, 14);
		add(lblTipoDeEmpleado);
		
		textField = new JTextField();
		textField.setBounds(255, 58, 107, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(30, 89, 46, 14);
		add(lblDesde);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 86, 107, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setBounds(203, 89, 46, 14);
		add(lblHasta);
		
		textField_2 = new JTextField();
		textField_2.setBounds(255, 89, 107, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago de la planilla");
		lblTipoDePago.setBounds(30, 132, 150, 14);
		add(lblTipoDePago);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("Seleccione");
		comboBox.addItem("Semanal");
		comboBox.addItem("Quincenal");
		comboBox.addItem("Mensual");
		comboBox.setBounds(255, 129, 107, 20);
		add(comboBox);
		
		JLabel lblFechaDePago = new JLabel("Fecha de pago");
		lblFechaDePago.setBounds(30, 175, 136, 14);
		add(lblFechaDePago);
		
		textField_3 = new JTextField();
		textField_3.setBounds(255, 172, 107, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas trabajadas por d\u00EDa");
		lblCantidadDeHoras.setBounds(30, 200, 220, 14);
		add(lblCantidadDeHoras);
		
		textField_4 = new JTextField();
		textField_4.setBounds(255, 203, 107, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "Seleccione el tipo de planilla");
				} else {
					try {
						DefaultController defaultController = new DefaultController();
						boolean exec = defaultController.generateCalendarByEmployeeType(Integer.parseInt(textField.getText()), textField_1.getText(),
								textField_2.getText(), (String) comboBox.getSelectedItem(), textField_3.getText(), Integer.parseInt(textField_4.getText()));
						if (exec){
							JOptionPane.showMessageDialog(null, "Calendario generado exitosamente");
						} else {
							JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar generar el calendario");
						}
					} catch (NumberFormatException nfex) {
						JOptionPane.showMessageDialog(null, "Algún valor ingresado es incorrecto");
					}
				}
			}
		});
		btnGenerar.setBounds(160, 247, 89, 23);
		add(btnGenerar);
	}
}
