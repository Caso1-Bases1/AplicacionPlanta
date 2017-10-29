package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.WorkingDayController;
import core.WorkingDay;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SearchWorkingDayView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -954420539966967682L;
	private JTextField textField;
	private JRadioButton rdbtnLaborable;
	private JRadioButton rdbtnNoLaborable;

	/**
	 * Create the panel.
	 */
	public SearchWorkingDayView() {
		this.setLayout(null);
		
		JLabel lblDasLaborables = new JLabel("D\u00EDas laborables");
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
				WorkingDayController controller = new WorkingDayController(new WorkingDay(date, 2));				
				WorkingDay workingDay = controller.search();
				
				if(workingDay != null){
					if (workingDay.isWorkingDay() == 1){
						rdbtnLaborable.setSelected(true);
						rdbtnNoLaborable.setSelected(false);
					} else if (workingDay.isWorkingDay() == 0){
						rdbtnLaborable.setSelected(false);
						rdbtnNoLaborable.setSelected(true);
					} else {
						rdbtnLaborable.setSelected(false);
						rdbtnNoLaborable.setSelected(false);
					} 
				} else {
					JOptionPane.showMessageDialog(null, "No existe un día laborable con ese fecha");
				}
			}
		});
		btnBuscar.setBounds(45, 110, 89, 23);
		add(btnBuscar);
		
		rdbtnLaborable = new JRadioButton("Laborable");
		rdbtnLaborable.setBounds(310, 49, 109, 23);
		add(rdbtnLaborable);
		
		rdbtnNoLaborable = new JRadioButton("No laborable");
		rdbtnNoLaborable.setBounds(310, 68, 109, 23);
		add(rdbtnNoLaborable);		
	}
}
