package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.HolidayController;
import core.Holiday;

public class SearchHolidayView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -163703165334380360L;
	private JTextField textField;
	private JRadioButton rdbtnPagado;
	/**
	 * Create the panel.
	 */
	public SearchHolidayView() {
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
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {							
				String [] dateParameters = textField.getText().split("-");
				@SuppressWarnings("deprecation")
				Date date = new Date(Integer.parseInt(dateParameters[0]), Integer.parseInt(dateParameters[1]), Integer.parseInt(dateParameters[2]));
				HolidayController controller = new HolidayController(new Holiday(date, false));				
				Holiday holiday = controller.search();
				
				if(holiday != null){
					if (holiday.isDoublePay()){
						rdbtnPagado.setSelected(true);
					} else {
						rdbtnPagado.setSelected(false);
					} 
				} else {
					JOptionPane.showMessageDialog(null, "No existe un día feriado con ese fecha");
				}
			}
		});
		btnBuscar.setBounds(45, 110, 89, 23);
		add(btnBuscar);
		
		rdbtnPagado = new JRadioButton("Pago doble");
		rdbtnPagado.setBounds(310, 68, 109, 23);
		add(rdbtnPagado);
	}
}
