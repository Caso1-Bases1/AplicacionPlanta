package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.PlantController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePlantCodeView extends JPanel {
	private JTextField textField_1;
	private int numeroPlanta;
	
	/**
	 * Create the panel.
	 */
	public UpdatePlantCodeView(int pNumeroPlanta) {
		setLayout(null);
		numeroPlanta = pNumeroPlanta;
		pNumeroPlanta = numeroPlanta;
		JLabel lblMidificarCdigoDe = new JLabel("Midificar c\u00F3digo de planta");		
		lblMidificarCdigoDe.setBounds(159, 33, 212, 14);
		add(lblMidificarCdigoDe);
		
		JLabel lblCdigoDePlanta = new JLabel("C\u00F3digo de planta");
		lblCdigoDePlanta.setBounds(66, 122, 140, 14);
		add(lblCdigoDePlanta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 119, 155, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codePlant = Integer.parseInt(textField_1.getText());
					numeroPlanta = codePlant;
					PlantController plantController = new PlantController();
					plantController.modifyPlantNumber(numeroPlanta);
				} catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Código incorrecto");
				}
			}
		});
		btnModificar.setBounds(173, 184, 89, 23);
		add(btnModificar);		
	}	
}
