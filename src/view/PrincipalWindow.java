package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DefaultController;
import controller.PlantController;
import util.Utility;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PrincipalWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2243915517392760924L;
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
		PlantController plantController = new PlantController();
		PLANT_NUMBER = plantController.getPlantNumber();
		System.out.println("Numero de planta: " + PLANT_NUMBER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnMantenimiento.add(mnEmpleados);
		
		JMenuItem mntmNuevoEmpleado = new JMenuItem("Nuevo Empleado");
		mntmNuevoEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertEmployeeView employeeView = new InsertEmployeeView();
				contentPane.removeAll();
				contentPane.add(employeeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnEmpleados.add(mntmNuevoEmpleado);
		
		JMenuItem mntmBuscarEmpleado = new JMenuItem("Buscar Empleado");
		mntmBuscarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmployeeView employeeView = new SearchEmployeeView();
				contentPane.removeAll();
				contentPane.add(employeeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnEmpleados.add(mntmBuscarEmpleado);
		
		JMenuItem mntmModificarEmpleado = new JMenuItem("Modificar Empleado");
		mntmModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployeeView employeeView = new UpdateEmployeeView();
				contentPane.removeAll();
				contentPane.add(employeeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnEmpleados.add(mntmModificarEmpleado);
		
		JMenuItem mntmEliminarEmpleado = new JMenuItem("Eliminar Empleado");
		mntmEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployeeView employeeView = new DeleteEmployeeView();
				contentPane.removeAll();
				contentPane.add(employeeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnEmpleados.add(mntmEliminarEmpleado);
		
		JMenu mnTiposDeEmpleados = new JMenu("Tipos de empleados");
		mnMantenimiento.add(mnTiposDeEmpleados);
		
		JMenuItem mntmNuevoTipoDe = new JMenuItem("Nuevo tipo de empleado");
		mntmNuevoTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertEmployeeTypeView employeeTypeView = new InsertEmployeeTypeView();
				contentPane.removeAll();
				contentPane.add(employeeTypeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnTiposDeEmpleados.add(mntmNuevoTipoDe);
		
		JMenuItem mntmBuscarTipoDe = new JMenuItem("Buscar tipo de empleado");
		mntmBuscarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmployeeTypeView employeeTypeView = new SearchEmployeeTypeView();
				contentPane.removeAll();
				contentPane.add(employeeTypeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnTiposDeEmpleados.add(mntmBuscarTipoDe);
		
		JMenuItem mntmModificarTipoDe = new JMenuItem("Modificar tipo de empleado");
		mntmModificarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployeeTypeView employeeTypeView = new UpdateEmployeeTypeView();
				contentPane.removeAll();
				contentPane.add(employeeTypeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnTiposDeEmpleados.add(mntmModificarTipoDe);
		
		JMenuItem mntmEliminarTipoDe = new JMenuItem("Eliminar tipo de empleado");
		mntmEliminarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployeeTypeView employeeTypeView = new DeleteEmployeeTypeView();
				contentPane.removeAll();
				contentPane.add(employeeTypeView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnTiposDeEmpleados.add(mntmEliminarTipoDe);
		
		JMenu mnDasLaborables = new JMenu("D\u00EDas laborables");
		mnMantenimiento.add(mnDasLaborables);
		
		JMenu mnAdministrarFeriados = new JMenu("Administrar d\u00EDas laborables");
		mnDasLaborables.add(mnAdministrarFeriados);
		
		JMenuItem mntmModificarDaLaborable = new JMenuItem("Modificar d\u00EDa laborable");
		mntmModificarDaLaborable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				UpdateWorkingDayView workingDayView = new UpdateWorkingDayView();
				contentPane.removeAll();
				contentPane.add(workingDayView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnAdministrarFeriados.add(mntmModificarDaLaborable);
		
		JMenu mnAdministrarDiasLaborables = new JMenu("Administrar feriados");
		mnDasLaborables.add(mnAdministrarDiasLaborables);
		
		JMenuItem mntmNuevoFeriado = new JMenuItem("Nuevo feriado");
		mntmNuevoFeriado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(new InsertHolidayView()).setBounds(0, 0, 800, 150);
				contentPane.add(new HolidaysView()).setBounds(50, 200, 450, 600);
				repaint();				
			}
		});
		mnAdministrarDiasLaborables.add(mntmNuevoFeriado);
		
		JMenuItem mntmModificarFeriado = new JMenuItem("Modificar feriado");
		mntmModificarFeriado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(new UpdateHolidayView()).setBounds(0, 0, 800, 150);
				contentPane.add(new HolidaysView()).setBounds(50, 200, 450, 600);
				repaint();
			}
		});
		mnAdministrarDiasLaborables.add(mntmModificarFeriado);
		
		JMenuItem mntmEliminarFeriado = new JMenuItem("Eliminar feriado");
		mntmEliminarFeriado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(new DeleteHolidayView()).setBounds(0, 0, 800, 150);
				contentPane.add(new HolidaysView()).setBounds(50, 200, 450, 600);
				repaint();
			}
		});
		mnAdministrarDiasLaborables.add(mntmEliminarFeriado);
		
		JMenuItem mntmCargarCalendarioEn = new JMenuItem("Cargar calendario en blanco");
		mntmCargarCalendarioEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultController defaultController = new DefaultController();
				boolean result = defaultController.loadCalendar();
				if (result){
					JOptionPane.showMessageDialog(null, "Calendario generado");
				} else {
					JOptionPane.showMessageDialog(null, "Ya se ha cargado el calendario de este año, revise los días laborables");
				}
			}
		});
		mnDasLaborables.add(mntmCargarCalendarioEn);
		
		JMenu mnCdigoDePlanta = new JMenu("C\u00F3digo de planta");
		mnMantenimiento.add(mnCdigoDePlanta);
		
		JMenuItem mntmModificarCdigoDe = new JMenuItem("Modificar c\u00F3digo de planta");
		mntmModificarCdigoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePlantCodeView upc = new UpdatePlantCodeView(PLANT_NUMBER);
				contentPane.removeAll();
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
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmEmpleadosPorSupervisor = new JMenuItem("Empleados por supervisor");
		mnConsultas.add(mntmEmpleadosPorSupervisor);
		
		JMenuItem mntmEmpleadosPorDepartamentos = new JMenuItem("Empleados por departamentos");
		mnConsultas.add(mntmEmpleadosPorDepartamentos);
		
		JMenuItem mntmAusenciasPorPeriodo = new JMenuItem("Ausencias por periodo de tiempo");
		mnConsultas.add(mntmAusenciasPorPeriodo);
		
		JMenuItem mntmTardasPorPeriodo = new JMenuItem("Tard\u00EDas por periodo de tiempo");
		mnConsultas.add(mntmTardasPorPeriodo);
		
		JMenuItem mntmEmpleadoSinMarca = new JMenuItem("Empleado sin marca de salida por periodo de tiempo");
		mnConsultas.add(mntmEmpleadoSinMarca);
		
		JMenuItem rdbtnmntmMontoPorEmpleado = new JMenuItem("Monto por empleado por periodo de tiempo");
		mnConsultas.add(rdbtnmntmMontoPorEmpleado);
		
		JMenuItem mntmEmpleadosDadosDe = new JMenuItem("Empleados dados de baja en un periodo de tiempo");
		mnConsultas.add(mntmEmpleadosDadosDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
