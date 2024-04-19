package jsafhdas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VistAdm {
	private static String ID;
	private static String Nombre;
	private static String Cantidad;
	private static String Usuario;
	private static String Descripcion;
	private static String Fecha;
	private static String Estatus;
	private static String Luga;
	private String [][] matriz = {};
	private String [] vector= {"ID","Nombre","Cantidad","Usuario","Descripcion","Fecha","Estatus","Lugar"};

	public static String getID() {
		return ID;
	}

	public static void setID(String iD) {
		ID = iD;
	}

	public static String getNombre() {
		return Nombre;
	}

	public static void setNombre(String nombre) {
		Nombre = nombre;
	}

	public static String getCantidad() {
		return Cantidad;
	}

	public static void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public static String getUsuario() {
		return Usuario;
	}

	public static void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public static String getDescripcion() {
		return Descripcion;
	}

	public static void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public static String getFecha() {
		return Fecha;
	}

	public static void setFecha(String fecha) {
		Fecha = fecha;
	}

	public static String getEstatus() {
		return Estatus;
	}

	public static void setEstatus(String estatus) {
		Estatus = estatus;
	}

	public static String getLuga() {
		return Luga;
	}

	public static void setLuga(String luga) {
		Luga = luga;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	

	public JFrame frame;
	
	private JTable table;
	private JButton btnSoli;
	private JButton btnBorrarTod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistAdm window = new VistAdm();
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
	public VistAdm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PreparedStatement st;
		ResultSet rs;
		String sql = "select * from dano where estatus = 'Pendiente'";
		conection cn = new conection();
		String [] dato = new String [8];
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1335, 912);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(0, 0, 1319, 873);
		frame.getContentPane().add(panel);
		
		
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setBounds(443, 5, 0, 0);
		panel.add(table);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Usuario");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Fecha");
		modelo.addColumn("Estatus");
		modelo.addColumn("Lugar");
		
		table.setModel(modelo);
		
		btnSoli = new JButton("Aprobar Solicitud");
		btnSoli.setBackground(new Color(204, 255, 153));
		btnSoli.setFont(new Font("Century Schoolbook", Font.BOLD, 17));
		btnSoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptacion ac = new aceptacion();
				ac.frame.setVisible(true);
				
			}
		});
		panel.add(btnSoli);
		
		btnBorrarTod = new JButton("Borrar todas las solicitudes");
		btnBorrarTod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				borrado();
			}
		});
		btnBorrarTod.setFont(new Font("Century Schoolbook", Font.BOLD, 17));
		btnBorrarTod.setBackground(new Color(204, 255, 153));
		panel.add(btnBorrarTod);
		
		Connection Conexion = cn.conectar();
		
		try {
			st = Conexion.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				dato[0] = rs.getString(1);
				dato[1] = rs.getString(2);
				dato[2] = rs.getString(3);
				dato[3] = rs.getString(4);
				dato[4] = rs.getString(5);
				dato[5] = rs.getString(6);
				dato[6] = rs.getString(7);
				dato[7] = rs.getString(8);
				modelo.addRow(dato);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	conection cn = new conection();
	public boolean borrado() {
		boolean br = false;
		br = cn.borrar();
		if (br==true) {
			JOptionPane.showMessageDialog(null, "Todos las solicitudes aceptadas se han eliminado");
		}else {
			JOptionPane.showMessageDialog(null, "No se a podido borrar las solicitudes aceptadas");
		}
		return br;
	}
	
}
