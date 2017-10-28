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
	public static int PLANT_NUMBER = 0;
	
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
		
		JMenu mnTiposDeEmpleados = new JMenu("Tipos de empleados");
		mnMantenimiento.add(mnTiposDeEmpleados);
		
		JMenuItem mntmNuevoTipoDe = new JMenuItem("Nuevo tipo de empleado");
		mnTiposDeEmpleados.add(mntmNuevoTipoDe);
		
		JMenuItem mntmBuscarTipoDe = new JMenuItem("Buscar tipo de empleado");
		mnTiposDeEmpleados.add(mntmBuscarTipoDe);
		
		JMenuItem mntmModificarTipoDe = new JMenuItem("Modificar tipo de empleado");
		mnTiposDeEmpleados.add(mntmModificarTipoDe);
		
		JMenuItem mntmEliminarTipoDe = new JMenuItem("Eliminar tipo de empleado");
		mnTiposDeEmpleados.add(mntmEliminarTipoDe);
		
		JMenu mnDasLaborables = new JMenu("D\u00EDas laborables");
		mnMantenimiento.add(mnDasLaborables);
		
		JMenu mnAdministrarFeriados = new JMenu("Administrar feriados");
		mnDasLaborables.add(mnAdministrarFeriados);
		
		JMenuItem mntmNuevoDaLaborable = new JMenuItem("Nuevo d\u00EDa laborable");
		mnAdministrarFeriados.add(mntmNuevoDaLaborable);
		
		JMenuItem mntmBuscarDaLaborable = new JMenuItem("Buscar d\u00EDa laborable");
		mnAdministrarFeriados.add(mntmBuscarDaLaborable);
		
		JMenuItem mntmModificarDaLaborable = new JMenuItem("Modificar d\u00EDa laborable");
		mnAdministrarFeriados.add(mntmModificarDaLaborable);
		
		JMenuItem mntmEliminarDaLaborable = new JMenuItem("Eliminar d\u00EDa laborable");
		mnAdministrarFeriados.add(mntmEliminarDaLaborable);
		
		JMenu mnAdministrarDiasLaborables = new JMenu("Administrar dias laborables");
		mnDasLaborables.add(mnAdministrarDiasLaborables);
		
		JMenuItem mntmNuevoFeriado = new JMenuItem("Nuevo feriado");
		mnAdministrarDiasLaborables.add(mntmNuevoFeriado);
		
		JMenuItem mntmBuscarFeriado = new JMenuItem("Buscar feriado");
		mnAdministrarDiasLaborables.add(mntmBuscarFeriado);
		
		JMenuItem mntmModificarFeriado = new JMenuItem("Modificar feriado");
		mnAdministrarDiasLaborables.add(mntmModificarFeriado);
		
		JMenuItem mntmEliminarFeriado = new JMenuItem("Eliminar feriado");
		mnAdministrarDiasLaborables.add(mntmEliminarFeriado);
		
		JMenu mnCdigoDePlanta = new JMenu("C\u00F3digo de planta");
		mnMantenimiento.add(mnCdigoDePlanta);
		
		JMenuItem mntmModificarCdigoDe = new JMenuItem("Modificar c\u00F3digo de planta");
		mntmModificarCdigoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePlantCodeView upc = new UpdatePlantCodeView(PLANT_NUMBER);
				contentPane.add(upc).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnCdigoDePlanta.add(mntmModificarCdigoDe);
		
		JMenu btnMarcas = new JMenu("Marcas");
		menuBar.add(btnMarcas);
		
		JMenuItem mntmAbrirMdulo = new JMenuItem("Abrir m\u00F3dulo");
		mntmAbrirMdulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Utility.IS_MARCAS_OPEN){
					AplicacionMarcas window = new AplicacionMarcas();
					window.getFrame().setVisible(true);
				}
			}
		});
		btnMarcas.add(mntmAbrirMdulo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
