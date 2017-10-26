package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Utility;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PrincipalWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalWindow frame = new PrincipalWindow();
					frame.setVisible(true);
					AplicacionMarcas window = new AplicacionMarcas();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnMantenimiento.add(mnEmpleados);
		
		JMenuItem mntmNuevoEmpleado = new JMenuItem("Nuevo Empleado");
		mnEmpleados.add(mntmNuevoEmpleado);
		
		JMenuItem mntmBuscarEmpleado = new JMenuItem("Buscar Empleado");
		mnEmpleados.add(mntmBuscarEmpleado);
		
		JMenuItem mntmModificarEmpleado = new JMenuItem("Modificar Empleado");
		mnEmpleados.add(mntmModificarEmpleado);
		
		JMenuItem mntmEliminarEmpleado = new JMenuItem("Eliminar Empleado");
		mnEmpleados.add(mntmEliminarEmpleado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAbrirMarcas = new JButton("Abrir Marcas");
		btnAbrirMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Utility.IS_MARCAS_OPEN){
					AplicacionMarcas window = new AplicacionMarcas();
					window.getFrame().setVisible(true);
				}
			}
		});
		contentPane.add(btnAbrirMarcas);
	}
}
