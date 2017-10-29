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

import controller.WorkingDayController;
import core.WorkingDay;

public class InsertWorkingDayView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6581819332859501464L;
	private JTextField textField;
	private JRadioButton rdbtnLaborable;
	private JRadioButton rdbtnNoLaborable;
	/**
	 * Create the panel.
	 */
	public InsertWorkingDayView() {
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
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int isWorkingDay = rdbtnLaborable.isSelected() ? 1 : rdbtnNoLaborable.isSelected() ? 0 : 2;
				String [] dateParameters = textField.getText().split("-");
				@SuppressWarnings("deprecation")
				Date date = new Date(Integer.parseInt(dateParameters[0]), Integer.parseInt(dateParameters[1]), Integer.parseInt(dateParameters[2]));
				WorkingDayController controller = new WorkingDayController(new WorkingDay(date, isWorkingDay));				
				boolean workingDayInserted = controller.insert();
				
				if(workingDayInserted){
					JOptionPane.showMessageDialog(null, "Día laborable ingresado"); 
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo ingresar el día laborable");
				}
			}
		});
		btnIngresar.setBounds(45, 110, 89, 23);
		add(btnIngresar);
		
		rdbtnLaborable = new JRadioButton("Laborable");
		rdbtnLaborable.setBounds(310, 49, 109, 23);
		add(rdbtnLaborable);
		
		rdbtnNoLaborable = new JRadioButton("No laborable");
		rdbtnNoLaborable.setBounds(310, 68, 109, 23);
		add(rdbtnNoLaborable);	
	}
}
