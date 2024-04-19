package jsafhdas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class RegistrarAdmin {
	public static String usuario;
	public static String contrasena;
	public static String correo;
	public static String noMatricula;

	public static String getUsuario() {
		return usuario;
	}

	public JTextField getTxtCodigoAcceso() {
		return txtCodigoAcceso;
	}

	public void setTxtCodigoAcceso(JTextField txtCodigoAcceso) {
		this.txtCodigoAcceso = txtCodigoAcceso;
	}

	public static void setUsuario(String usuario) {
		RegistrarAdmin.usuario = usuario;
	}

	public static String getContrasena() {
		return contrasena;
	}

	public static void setContrasena(String contrasena) {
		RegistrarAdmin.contrasena = contrasena;
	}

	public static String getCorreo() {
		return correo;
	}

	public static void setCorreo(String correo) {
		RegistrarAdmin.correo = correo;
	}

	public static String getNoMatricula() {
		return noMatricula;
	}

	public static void setNoMatricula(String noMatricula) {
		RegistrarAdmin.noMatricula = noMatricula;
	}

	public JFrame getFrame() {
		return frmRegistroDeAdmin;
	}

	public void setFrame(JFrame frame) {
		this.frmRegistroDeAdmin = frame;
	}

	public JFrame frmRegistroDeAdmin;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JTextField txtCorreo;
	private JTextField txtNoMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarAdmin window = new RegistrarAdmin();
					window.frmRegistroDeAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrarAdmin() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeAdmin = new JFrame();
		frmRegistroDeAdmin.setAlwaysOnTop(true);
		frmRegistroDeAdmin.setTitle("Registro de Admin");
		frmRegistroDeAdmin.setBounds(100, 100, 589, 296);
		frmRegistroDeAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeAdmin.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		panel.setBounds(0, 0, 581, 265);
		frmRegistroDeAdmin.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 11, 123, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 21));

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Century Schoolbook", Font.BOLD, 21));
		txtUsuario.setBounds(10, 35, 215, 23);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 69, 123, 29);
		panel.add(lblCorreo);
		lblCorreo.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 21));

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Century Schoolbook", Font.BOLD, 21));
		txtCorreo.setBounds(10, 94, 215, 23);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);

		JLabel lblCodigoDeAcceso = new JLabel("Codigo de acceso");
		lblCodigoDeAcceso.setBounds(10, 134, 190, 29);
		panel.add(lblCodigoDeAcceso);
		lblCodigoDeAcceso.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 21));

		txtCodigoAcceso = new JTextField();
		txtCodigoAcceso.setFont(new Font("Century Schoolbook", Font.BOLD, 21));
		txtCodigoAcceso.setBounds(10, 174, 215, 23);
		panel.add(txtCodigoAcceso);
		txtCodigoAcceso.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(315, 11, 190, 29);
		panel.add(lblContrasea);
		lblContrasea.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 21));

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(315, 35, 215, 23);
		panel.add(txtContrasena);

		JLabel lblNomatricula = new JLabel("NoMatricula");
		lblNomatricula.setBounds(315, 69, 178, 29);
		panel.add(lblNomatricula);
		lblNomatricula.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 21));

		txtNoMatricula = new JTextField();
		txtNoMatricula.setFont(new Font("Century Schoolbook", Font.BOLD, 21));
		txtNoMatricula.setBounds(315, 94, 215, 23);
		panel.add(txtNoMatricula);
		txtNoMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNoMatricula.getText().length() >= 14) {
					e.consume();
				}
			}

		});
		txtNoMatricula.setColumns(10);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(315, 136, 161, 29);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {

				if (!txtCodigoAcceso.getText().isEmpty() && !txtContrasena.getText().isEmpty()
						&& !txtCorreo.getText().isEmpty() && !txtNoMatricula.getText().isEmpty()
						&& !txtUsuario.getText().isEmpty()) {
					if (txtCodigoAcceso.getText().equals("153907")) {
						registrar();
					} else {
						JOptionPane.showMessageDialog(null, "El codigo de acceso no es el indicado");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Todos los campos deben de estar llenos");
				}

			}
		});
		btnNewButton.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(Color.ORANGE);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(315, 169, 161, 29);
		panel.add(btnCerrar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaInicio pi = new PantallaInicio();
				frmRegistroDeAdmin.setVisible(false);
				pi.frmInicio.setVisible(true);

			}
		});
		btnCerrar.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 16));
		btnCerrar.setBackground(Color.CYAN);
	}

	conection conec = new conection();
	private JTextField txtCodigoAcceso;

	public boolean registrar() {
		boolean registrado = false;

		setUsuario(txtUsuario.getText());
		setContrasena(txtContrasena.getText());
		setCorreo(txtCorreo.getText());
		setNoMatricula(txtNoMatricula.getText());
		registrado = conec.registrarAdministrador(this);

		if (registrado == true) {

			JOptionPane.showMessageDialog(null, "OK");
		}

		return registrado;
	}
}
