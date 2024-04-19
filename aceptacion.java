package jsafhdas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class aceptacion {
	private static String ID;
	public JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField txtID;

	public static String getID() {
		return ID;
	}

	public static void setID(String iD) {
		ID = iD;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aceptacion window = new aceptacion();
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
	public aceptacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 560, 188);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(102, 255, 204));
		panel.setBounds(0, 0, 544, 155);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("Escribe el ID del inmueble solicitado");
		lblID.setFont(new Font("Century Schoolbook", Font.BOLD, 21));
		lblID.setBounds(10, 26, 413, 26);
		panel.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(10, 63, 261, 33);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JButton btnAprobar = new JButton("Aprobar");
		btnAprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtID.getText().isEmpty()) {
					aceptado();
					limp();
				}else{
		JOptionPane.showMessageDialog(null, "Debes de llenar el ID");
				}
			}
		});
		btnAprobar.setFont(new Font("Century Schoolbook", Font.BOLD, 17));
		btnAprobar.setBounds(10, 107, 123, 33);
		panel.add(btnAprobar);
		
		JButton btnAprobarTodo = new JButton("Aprobar todo");
		btnAprobarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val();
			}
		});
		btnAprobarTodo.setFont(new Font("Century Schoolbook", Font.BOLD, 17));
		btnAprobarTodo.setBounds(143, 107, 178, 33);
		panel.add(btnAprobarTodo);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistAdm va = new VistAdm();
				frame.setVisible(false);
				va.frame.setVisible(false);
				va.frame.setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Century Schoolbook", Font.BOLD, 17));
		btnAtras.setBounds(331, 107, 123, 33);
		panel.add(btnAtras);
	}
	conection cn = new  conection();
	public boolean aceptado() {
		boolean ace = false;
		setID(txtID.getText());
		ace = cn.ac(this);
		if (ace==true) {
			JOptionPane.showMessageDialog(null, "Aprobado correctamente");
			
		}else {
			JOptionPane.showMessageDialog(null, "ID no encontrada");
		}
		return ace;
	}
	public void limp() {
		txtID.setText("");
	}
	
	public boolean aceptartodo() {
		boolean ac= false;
		cn.actodo();
		
		return ac;
	}
	
	public void val() {
		if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Todas las solicitudes se aceptaran");
			JOptionPane.showMessageDialog(null, "Para realizar esta accion escribe   'si'   en el campo de ID");
		}else if (txtID.getText().equals("si") || txtID.getText().equals("SI") || txtID.getText().equals("Si") || txtID.getText().equals("sI")) {
			aceptartodo();
			JOptionPane.showMessageDialog(null, "Todas las solicitudes se aceptaron");
		}else {
			JOptionPane.showMessageDialog(null, "El texto de confirmacion o no coincide  (si)");
			limp();
		}
		
		
		
		
		
	}
}
