import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AplicacionMarcas {

	private JFrame frame;
	private JTextField nombreEmpleado;
	private JTextField idEmpleado;
	private JTextField horaActual;
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionMarcas window = new AplicacionMarcas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacionMarcas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Aplicacion de Planta");
		frame.setBounds(100, 100, 568, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombreDeEmpleado = new JLabel("Nombre de Empleado");
		lblNombreDeEmpleado.setBounds(97, 21, 115, 14);
		frame.getContentPane().add(lblNombreDeEmpleado);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(97, 72, 115, 14);
		frame.getContentPane().add(lblIdentificacion);
		
		JLabel lblHoraActual = new JLabel("Hora Actual");
		lblHoraActual.setBounds(97, 127, 69, 14);
		frame.getContentPane().add(lblHoraActual);
		
		nombreEmpleado = new JTextField();
		nombreEmpleado.setBounds(288, 18, 132, 20);
		frame.getContentPane().add(nombreEmpleado);
		nombreEmpleado.setColumns(10);
		
		idEmpleado = new JTextField();
		idEmpleado.setBounds(288, 69, 132, 20);
		frame.getContentPane().add(idEmpleado);
		idEmpleado.setColumns(10);
		
		horaActual = new JTextField();
		horaActual.setBounds(288, 124, 132, 20);
		frame.getContentPane().add(horaActual);
		horaActual.setColumns(10);
		JButton btnHoraDeEntrada = new JButton("Hora de Entrada");
		btnHoraDeEntrada.setBounds(97, 202, 115, 23);
		frame.getContentPane().add(btnHoraDeEntrada);
		
		JButton btnSalida = new JButton("Hora de Salida");
		btnSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalida.setBounds(259, 202, 115, 23);
		frame.getContentPane().add(btnSalida);
		horaActual.setText(dateFormat.format(date));

		
	}
}
