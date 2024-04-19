package jsafhdas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class RegisterUser {
	public static String usuario;
	public static String contrasena;

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		RegisterUser.usuario = usuario;
	}

	public static String getContrasena() {
		return contrasena;
	}

	public static void setContrasena(String contrasena) {
		RegisterUser.contrasena = contrasena;
	}

	public JFrame getFrame() {
		return frmRegistroDeUsuario;
	}

	public void setFrame(JFrame frame) {
		this.frmRegistroDeUsuario = frame;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtContrasena() {
		return txtContrase;
	}

	public void setTxtContrasena(JTextField txtContrasena) {
		this.txtContrase = (JPasswordField) txtContrasena;
	}

	JFrame frmRegistroDeUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser window = new RegisterUser();
					window.frmRegistroDeUsuario.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterUser() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeUsuario = new JFrame();
		frmRegistroDeUsuario.setAlwaysOnTop(true);
		frmRegistroDeUsuario.setTitle("Registro de Usuario");
		frmRegistroDeUsuario.setBounds(100, 100, 512, 303);
		frmRegistroDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeUsuario.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 191, 216));
		panel.setBounds(0, 0, 503, 273);
		frmRegistroDeUsuario.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 31, 121, 20);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 21));
		panel.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 21));
		lblContrasea.setBounds(10, 95, 139, 29);
		panel.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		txtUsuario.setBackground(new Color(250, 235, 215));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(168, 29, 198, 29);
		panel.add(txtUsuario);
		
		txtContrase = new JPasswordField();
		txtContrase.setBackground(new Color(250, 235, 215));
		txtContrase.setBounds(168, 99, 198, 29);
		panel.add(txtContrase);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(55, 164, 123, 29);
		panel.add(btnNewButton);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PantallaInicio pi = new PantallaInicio();
			pi.frmInicio.setVisible(true);
			frmRegistroDeUsuario.setVisible(false);
			}
		});
		btnCerrar.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 16));
		btnCerrar.setBackground(Color.MAGENTA);
		btnCerrar.setBounds(243, 164, 123, 29);
		panel.add(btnCerrar);

	}

	conection conec = new conection();
	private JTextField txtUsuario;
	private JPasswordField txtContrase;

	public boolean registrar() {
		boolean registrado = false;

		setUsuario(txtUsuario.getText());
		setContrasena(txtContrase.getText());
		conec.registrarUsuario(this);

		if (registrado == true) {
			JOptionPane.showMessageDialog(null, "OK");
		}

		return registrado;
	}
}
