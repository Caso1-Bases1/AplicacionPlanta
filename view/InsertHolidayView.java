package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.HolidayController;
import core.Holiday;

public class InsertHolidayView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8499173701843047721L;
	private JTextField textField;
	private JRadioButton rdbtnPagado;
	/**
	 * Create the panel.
	 */
	public InsertHolidayView() {
		this.setLayout(null);
		
		JLabel lblDasLaborables = new JLabel("D\u00EDas feriados");
		lblDasLaborables.setBounds(172, 11, 172, 14);
		add(lblDasLaborables);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha");
		lblIngreseLaFecha.setBounds(45, 72, 105, 14);
		add(lblIngreseLaFecha);
		
		textField = new JTextField();
		textField.setBounds(143, 69, 141, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = textField.getText();
				HolidayController controller = new HolidayController(new Holiday(date, rdbtnPagado.isSelected()));				
				boolean holidayInserted = controller.insert();
				
				if(holidayInserted){
					JOptionPane.showMessageDialog(null, "Feriado ingresado"); 
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo ingresar el feriado");
				}
			}
		});
		btnIngresar.setBounds(45, 110, 89, 23);
		add(btnIngresar);
		
		rdbtnPagado = new JRadioButton("Pago doble");
		rdbtnPagado.setBounds(310, 68, 109, 23);
		add(rdbtnPagado);
	}
}
