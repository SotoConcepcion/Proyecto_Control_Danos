package jsafhdas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;

public class RegistroDanos {
	private static String nombreMo;
	private static String Lugar;
	private static String Usuario;
	private static String Descrip;
	private static String Cantidad;
	private static String Status = "pendiente";

	private JFrame frmRegistroDeDanos;
	private JTextField txtDescrip;
	private JTextField txtCantidad;
	private JTextField txtNombreMo;

	public static String getStatus() {
		return Status;
	}

	public static void setStatus(String status) {
		Status = status;
	}

	public static String getCantidad() {
		return Cantidad;
	}

	public static void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public static String getLugar() {
		return Lugar;
	}

	public static void setLugar(String lugar) {
		Lugar = lugar;
	}

	public static String getNombreMo() {
		return nombreMo;
	}

	public static void setNombreMo(String nombreMo) {
		RegistroDanos.nombreMo = nombreMo;
	}

	public static String getUsuario() {
		return Usuario;
	}

	public static void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public static String getDescrip() {
		return Descrip;
	}

	public static void setDescrip(String descrip) {
		Descrip = descrip;
	}

	public JFrame getFrmRegistrodedaos() {
		return frmRegistroDeDanos;
	}

	public void setFrmRegistrodedaos(JFrame frmRegistrodedaos) {
		this.frmRegistroDeDanos = frmRegistrodedaos;
	}

	public JTextField getTxtDescrip() {
		return txtDescrip;
	}

	public void setTxtDescrip(JTextField txtDescrip) {
		this.txtDescrip = txtDescrip;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public JTextField getTxtNombreMo() {
		return txtNombreMo;
	}

	public void setTxtNombreMo(JTextField txtNombreMo) {
		this.txtNombreMo = txtNombreMo;
	}

	public JTextField getTxtLugar() {
		return txtLugar;
	}

	public void setTxtLugar(JTextField txtLugar) {
		this.txtLugar = txtLugar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDanos window = new RegistroDanos();
					window.frmRegistroDeDanos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroDanos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeDanos = new JFrame();
		frmRegistroDeDanos.setTitle("RegistroDeDanos");
		frmRegistroDeDanos.setBounds(100, 100, 797, 388);
		frmRegistroDeDanos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeDanos.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 787, 356);
		frmRegistroDeDanos.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNombreDelMobiliario = new JLabel("Nombre del mobiliario");
		lblNombreDelMobiliario.setBounds(10, 11, 192, 29);
		panel.add(lblNombreDelMobiliario);
		lblNombreDelMobiliario.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 16));

		txtNombreMo = new JTextField();
		txtNombreMo.setBackground(new Color(255, 255, 255));
		txtNombreMo.setBounds(10, 37, 245, 34);
		panel.add(txtNombreMo);
		txtNombreMo.setToolTipText("");
		txtNombreMo.setColumns(10);

		JLabel lblLugar = new JLabel("Lugar donde se solicita");
		lblLugar.setBounds(10, 82, 265, 29);
		panel.add(lblLugar);
		lblLugar.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 16));

		txtLugar = new JTextField();
		txtLugar.setBounds(10, 115, 326, 34);
		panel.add(txtLugar);
		txtLugar.setColumns(10);

		JLabel lblDescripcionDelPorque = new JLabel("Descripci\u00F3n");
		lblDescripcionDelPorque.setBounds(10, 160, 372, 34);
		panel.add(lblDescripcionDelPorque);
		lblDescripcionDelPorque.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 16));

		txtDescrip = new JTextField();
		txtDescrip.setBounds(10, 205, 497, 128);
		panel.add(txtDescrip);
		txtDescrip.setColumns(10);

		JLabel lblCantidadSolicitada = new JLabel("Cantidad de objetos solicitados");
		lblCantidadSolicitada.setBounds(409, 11, 265, 29);
		panel.add(lblCantidadSolicitada);
		lblCantidadSolicitada.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 16));

		txtCantidad = new JTextField();
		txtCantidad.setBounds(409, 37, 265, 34);
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);

		JButton btnAgregarReporte = new JButton("Agregar reporte");
		btnAgregarReporte.setBackground(new Color(0, 204, 51));
		btnAgregarReporte.setBounds(547, 205, 172, 34);
		panel.add(btnAgregarReporte);
		btnAgregarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtCantidad.getText().isEmpty() && !txtDescrip.getText().isEmpty()
						&& !txtNombreMo.getText().isEmpty()) {
					guardar();
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
				}

			}
		});
		btnAgregarReporte.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 16));

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(102, 255, 204));
		btnLimpiar.setBounds(547, 250, 172, 34);
		panel.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 16));

		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBackground(new Color(255, 51, 51));
		btnCerrarSesion.setBounds(547, 295, 172, 34);
		panel.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInicio pi = new PantallaInicio();
				frmRegistroDeDanos.setVisible(false);
				pi.getFrmInicio().setVisible(true);
			}
		});

		btnCerrarSesion.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 16));

	}

	conection cn = new conection();
	private JTextField txtLugar;

	public void limpiar() {
		txtDescrip.setText(" ");
		txtCantidad.setText(" ");
		txtNombreMo.setText(" ");
		txtLugar.setText(" ");

	}

	public boolean guardar() {
		boolean guardado = false;

		setNombreMo(txtNombreMo.getText());
		setCantidad(txtCantidad.getText());
		setUsuario(PantallaInicio.usuario);
		setDescrip(txtDescrip.getText());
		setStatus("Pendiente");
		setLugar(txtLugar.getText());
		guardado = cn.insertarRepote(this);
		if (guardado == true) {
			JOptionPane.showMessageDialog(null, "Reporte enviado");
		}
		return guardado;

	}

}
