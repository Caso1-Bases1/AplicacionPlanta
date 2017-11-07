package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DefaultController;
import util.Utility;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeesLatesView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7122629924256816759L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	public EmployeesLatesView(){
		this.setLayout(null);
		
		JLabel lblTardaEnUn = new JLabel("Tard\u00EDa en un rango de fecha");
		lblTardaEnUn.setBounds(128, 11, 182, 14);
		add(lblTardaEnUn);
		
		JLabel lblHoraDeEntrada = new JLabel("Hora de entrada: ");
		lblHoraDeEntrada.setBounds(10, 48, 157, 14);
		add(lblHoraDeEntrada);
		
		textField = new JTextField(Utility.ENTRY_HOUR.split(" ")[1]);
		textField.setBounds(205, 45, 121, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility.ENTRY_HOUR = "0000-00-00" + " " + textField.getText();
				JOptionPane.showMessageDialog(null, "Hora de entrada modificada");
			}
		});
		btnModificar.setBounds(221, 80, 89, 23);
		add(btnModificar);
		
		JLabel lblFechaInicial = new JLabel("Fecha inicial");
		lblFechaInicial.setBounds(10, 123, 121, 14);
		add(lblFechaInicial);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 148, 121, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaFinal = new JLabel("Fecha final");
		lblFechaFinal.setBounds(203, 123, 80, 14);
		add(lblFechaFinal);
		
		textField_2 = new JTextField();
		textField_2.setBounds(197, 148, 121, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBucar = new JButton("Buscar");
		btnBucar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel defaultTableModel = new DefaultTableModel();
				table = new JTable(defaultTableModel);
				table.setFillsViewportHeight(true);
				table.setOpaque(false);	
				
				defaultTableModel.addColumn("Nombre");
				defaultTableModel.addColumn("Apellidos");
				defaultTableModel.addColumn("Hora de entrada");
				defaultTableModel.addColumn("Hora de salida");
				defaultTableModel.addColumn("Supervisor");
				defaultTableModel.addColumn("Departamento");
								
				DefaultController defaultController = new DefaultController();
				defaultController.getEmployeesLates(textField.getText(), textField_1.getText(), Utility.ENTRY_HOUR, defaultTableModel);
				
				add(new JScrollPane(table)).setBounds(25, 200, 700, 300);
			}
		});
		btnBucar.setBounds(351, 147, 89, 23);
		add(btnBucar);
		
	}
}
