package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Utility;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		
		JMenuItem mntmNuevoDaLaborable = new JMenuItem("Nuevo d\u00EDa laborable");
		mntmNuevoDaLaborable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertWorkingDayView workingDayView = new InsertWorkingDayView();
				contentPane.removeAll();
				contentPane.add(workingDayView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnAdministrarFeriados.add(mntmNuevoDaLaborable);
		
		JMenuItem mntmBuscarDaLaborable = new JMenuItem("Buscar d\u00EDa laborable");
		mntmBuscarDaLaborable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchWorkingDayView workingDayView = new SearchWorkingDayView();
				contentPane.removeAll();
				contentPane.add(workingDayView).setBounds(0, 0, 800, 600);
				repaint();			
			}
		});
		mnAdministrarFeriados.add(mntmBuscarDaLaborable);
		
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
		
		JMenuItem mntmEliminarDaLaborable = new JMenuItem("Eliminar d\u00EDa laborable");
		mntmEliminarDaLaborable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteWorkingDayView workingDayView = new DeleteWorkingDayView();
				contentPane.removeAll();
				contentPane.add(workingDayView).setBounds(0, 0, 800, 600);
				repaint();				
			}
		});
		mnAdministrarFeriados.add(mntmEliminarDaLaborable);
		
		JMenu mnAdministrarDiasLaborables = new JMenu("Administrar feriados");
		mnDasLaborables.add(mnAdministrarDiasLaborables);
		
		JMenuItem mntmNuevoFeriado = new JMenuItem("Nuevo feriado");
		mntmNuevoFeriado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertHolidayView holidayView = new InsertHolidayView();
				contentPane.removeAll();
				contentPane.add(holidayView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnAdministrarDiasLaborables.add(mntmNuevoFeriado);
		
		JMenuItem mntmBuscarFeriado = new JMenuItem("Buscar feriado");
		mntmBuscarFeriado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchHolidayView holidayView = new SearchHolidayView();
				contentPane.removeAll();
				contentPane.add(holidayView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnAdministrarDiasLaborables.add(mntmBuscarFeriado);
		
		JMenuItem mntmModificarFeriado = new JMenuItem("Modificar feriado");
		mntmModificarFeriado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateHolidayView holidayView = new UpdateHolidayView();
				contentPane.removeAll();
				contentPane.add(holidayView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnAdministrarDiasLaborables.add(mntmModificarFeriado);
		
		JMenuItem mntmEliminarFeriado = new JMenuItem("Eliminar feriado");
		mntmEliminarFeriado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteHolidayView holidayView = new DeleteHolidayView();
				contentPane.removeAll();
				contentPane.add(holidayView).setBounds(0, 0, 800, 600);
				repaint();
			}
		});
		mnAdministrarDiasLaborables.add(mntmEliminarFeriado);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
