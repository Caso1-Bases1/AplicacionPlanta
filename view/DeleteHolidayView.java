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

public class DeleteHolidayView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8217348967466424097L;
	private JTextField textField;
	private JRadioButton rdbtnPagado;
	private Holiday holiday;
	/**
	 * Create the panel.
	 */
	public DeleteHolidayView() {
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
				String date = textField.getText();
				HolidayController controller = new HolidayController(new Holiday(date, rdbtnPagado.isSelected()));				
				holiday = controller.search();
				
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
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (holiday == null){
					JOptionPane.showMessageDialog(null, "No existe un feriado con esa fecha");
				} else {					
					HolidayController controller = new HolidayController(holiday);
					controller.delete();
					JOptionPane.showMessageDialog(null, "Feriado eliminado");
				}
			}
		});
		btnEliminar.setBounds(195, 110, 89, 23);
		add(btnEliminar);
	}	
}
