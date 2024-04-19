package jsafhdas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PantallaInicio {
	public static String usuario;
	public static String contrasena;
	public static String admin;
	public static String contradmin;

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		PantallaInicio.usuario = usuario;
	}

	public static String getContrasena() {
		return contrasena;
	}

	public static void setContrasena(String contrasena) {
		PantallaInicio.contrasena = contrasena;
	}

	public static String getAdmin() {
		return admin;
	}

	public static void setAdmin(String admin) {
		PantallaInicio.admin = admin;
	}

	public static String getContradmin() {
		return contradmin;
	}

	public static void setContradmin(String contradmin) {
		PantallaInicio.contradmin = contradmin;
	}

	public RegisterUser getRu() {
		return ru;
	}

	public void setRu(RegisterUser ru) {
		this.ru = ru;
	}

	public JFrame getFrmInicio() {
		return frmInicio;
	}

	public void setFrmInicio(JFrame frmInicio) {
		this.frmInicio = frmInicio;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getPsContrasena() {
		return psContrasena;
	}

	public void setPsContrasena(JPasswordField psContrasena) {
		this.psContrasena = psContrasena;
	}

	public JTextField getTxtUsuarioAdmin() {
		return txtUsuarioAdmin;
	}

	public void setTxtUsuarioAdmin(JTextField txtUsuarioAdmin) {
		this.txtUsuarioAdmin = txtUsuarioAdmin;
	}

	public JPasswordField getPsContrasenaAdmin() {
		return psContrasenaAdmin;
	}

	public void setPsContrasenaAdmin(JPasswordField psContrasenaAdmin) {
		this.psContrasenaAdmin = psContrasenaAdmin;
	}

	RegisterUser ru = new RegisterUser();
	public JFrame frmInicio;
	private JTextField txtUsuario;
	private JPasswordField psContrasena;
	private JTextField txtUsuarioAdmin;
	private JPasswordField psContrasenaAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio window = new PantallaInicio();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaInicio() {
		initialize();
		conection con = new conection();

		con.conectar();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setResizable(false);
		frmInicio.setAutoRequestFocus(false);
		frmInicio.setAlwaysOnTop(true);
		frmInicio.setTitle("PANTALLA DE INICIO");
		frmInicio.setBounds(100, 100, 508, 308);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 509, 337);
		frmInicio.getContentPane().add(tabbedPane);

		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Reportar daño", null, layeredPane, null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 191, 216));
		panel.setBounds(0, 0, 503, 309);
		layeredPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(56, 11, 88, 42);
		panel.add(lblUsuario);
		lblUsuario.setFont(new Font("Century Schoolbook", Font.BOLD, 21));

		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(298, 11, 146, 42);
		panel.add(lblContrasena);
		lblContrasena.setFont(new Font("Century Schoolbook", Font.BOLD, 21));

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		txtUsuario.setBounds(20, 48, 153, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		psContrasena = new JPasswordField();
		psContrasena.setBounds(255, 48, 212, 20);
		panel.add(psContrasena);

		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setBounds(27, 120, 146, 33);
		panel.add(btnIniciarSesion);
		btnIniciarSesion.setBackground(Color.ORANGE);
		btnIniciarSesion.setForeground(new Color(0, 0, 0));
		btnIniciarSesion.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RegisterUser ru = new RegisterUser();
				ru.frmRegistroDeUsuario.setVisible(true);
				frmInicio.setVisible(false);

			}
		});
		btnRegistrar.setBounds(255, 120, 153, 33);
		panel.add(btnRegistrar);
		btnRegistrar.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnRegistrar.setBackground(Color.GREEN);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtUsuario.getText().isEmpty() && !psContrasena.getText().isEmpty()) {
					valid();
					frmInicio.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenas todos los campos");
				}

			}
		});

		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Administrador", null, layeredPane_1, null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(0, 0, 504, 309);
		layeredPane_1.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUsuarioAdmin = new JLabel("Usuario");
		lblUsuarioAdmin.setBounds(56, 11, 88, 42);
		panel_1.add(lblUsuarioAdmin);
		lblUsuarioAdmin.setFont(new Font("Century Schoolbook", Font.BOLD, 21));

		txtUsuarioAdmin = new JTextField();
		txtUsuarioAdmin.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		txtUsuarioAdmin.setBounds(20, 48, 153, 20);
		panel_1.add(txtUsuarioAdmin);
		txtUsuarioAdmin.setColumns(10);

		JLabel lblContrasenaAdmin = new JLabel("Contrase\u00F1a");
		lblContrasenaAdmin.setBounds(298, 11, 146, 42);
		panel_1.add(lblContrasenaAdmin);
		lblContrasenaAdmin.setFont(new Font("Century Schoolbook", Font.BOLD, 21));

		psContrasenaAdmin = new JPasswordField();
		psContrasenaAdmin.setBounds(255, 48, 212, 20);
		panel_1.add(psContrasenaAdmin);

		JButton btnIniciarSesionAdmin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesionAdmin.setBounds(27, 120, 146, 33);
		panel_1.add(btnIniciarSesionAdmin);
		btnIniciarSesionAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enconadmin() == true) {
					frmInicio.setVisible(false);
					VistAdm vd = new VistAdm();
					vd.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrectos");
					limpiar();
				}

			}
		});
		btnIniciarSesionAdmin.setForeground(Color.BLACK);
		btnIniciarSesionAdmin.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnIniciarSesionAdmin.setBackground(Color.ORANGE);

		JButton btnRegistrarAdmin = new JButton("Registrar");
		btnRegistrarAdmin.setBounds(255, 120, 153, 33);
		panel_1.add(btnRegistrarAdmin);
		btnRegistrarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarAdmin ra = new RegistrarAdmin();
				ra.frmRegistroDeAdmin.setVisible(true);
				frmInicio.setVisible(false);
			}
		});
		btnRegistrarAdmin.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnRegistrarAdmin.setBackground(Color.GREEN);
	}

	RegisterUser rus = new RegisterUser();
	RegistrarAdmin ra = new RegistrarAdmin();
	conection conec = new conection();

	public boolean encon() {
		boolean si = false;
		setUsuario(txtUsuario.getText());
		setContrasena(psContrasena.getText());

		si = conec.log(usuario, contrasena);
		if (si == true) {
			// JOptionPane.showMessageDialog(null, "encontrado");
			frmInicio.setVisible(false);
		} else {
			si = false;
			JOptionPane.showMessageDialog(null, "Usuario no registrado");
			rus.frmRegistroDeUsuario.setVisible(true);

		}
		return si;
	}

	public boolean enconadmin() {
		boolean si = false;
		setAdmin(txtUsuarioAdmin.getText());
		setContradmin(psContrasenaAdmin.getText());

		si = conec.logad(admin, contradmin);
		if (si == true) {
			// JOptionPane.showMessageDialog(null, "encontrado");

		} else {
			si = false;

		}
		return si;
	}

	public boolean valid() {
		boolean validar = false;

		if (encon() == true) {
			validar = true;
			RegistroDanos rd = new RegistroDanos();
		
			rd.getFrmRegistrodedaos().setVisible(true);
		}

		return validar;
	}

	public void camp() {
		if (!txtUsuario.getText().isEmpty() || !psContrasena.getText().isEmpty()) {
			txtUsuarioAdmin.setText("");
			psContrasenaAdmin.setText("");

		}

		if (!txtUsuarioAdmin.getText().isEmpty() || !psContrasenaAdmin.getText().isEmpty()) {
			txtUsuario.setText("");
			psContrasena.setText("");
		}

	}

	public void limpiar() {
		psContrasenaAdmin.setText("");
		psContrasena.setText("");
		txtUsuarioAdmin.setText("");
		txtUsuario.setText("");

	}
}
