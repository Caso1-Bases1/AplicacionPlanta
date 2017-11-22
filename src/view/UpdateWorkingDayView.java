package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.WorkingDayController;
import core.WorkingDay;

public class UpdateWorkingDayView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7464671809538601558L;
	private JTextField textField;
	private JRadioButton rdbtnLaborable;
	private JRadioButton rdbtnNoLaborable;
	private JButton btnModificar;
	private WorkingDay workingDay;
	/**
	 * Create the panel.
	 */
	public UpdateWorkingDayView() {
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
				WorkingDayController controller = new WorkingDayController(new WorkingDay(textField.getText()));				
				workingDay = controller.search();
				
				if(workingDay != null){
					if (workingDay.isWorkingDay()){
						rdbtnLaborable.setSelected(true);
						rdbtnNoLaborable.setSelected(false);
					} else if (workingDay.isWorkingDay()){
						rdbtnLaborable.setSelected(false);
						rdbtnNoLaborable.setSelected(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No existe un día laborable con ese fecha");
				}
			}
		});
		btnBuscar.setBounds(45, 110, 89, 23);
		add(btnBuscar);
		
		rdbtnLaborable = new JRadioButton("Laborable");
		rdbtnLaborable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNoLaborable.setSelected(false);
			}
		});
		rdbtnLaborable.setBounds(310, 49, 109, 23);
		add(rdbtnLaborable);
		
		rdbtnNoLaborable = new JRadioButton("No laborable");
		rdbtnNoLaborable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLaborable.setSelected(false);
			}
		});
		rdbtnNoLaborable.setBounds(310, 68, 109, 23);
		add(rdbtnNoLaborable);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (workingDay == null){
					JOptionPane.showMessageDialog(null, "No existe un día laborable con esa fecha");
				} else {
					boolean isWorkingDay = false;
					if (rdbtnLaborable.isSelected()){
						isWorkingDay = true;
					} else if (rdbtnNoLaborable.isSelected()){
						isWorkingDay = false;
					}
					WorkingDayController controller = new WorkingDayController(new WorkingDay(workingDay.getDate(), isWorkingDay));					
					controller.update();
					JOptionPane.showMessageDialog(null, "Día laborable modificado");
				}
			}
		});
		btnModificar.setBounds(195, 110, 89, 23);
		add(btnModificar);
	}
}
