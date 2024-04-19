package jsafhdas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conection {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Connection conectar() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Danos", "root", "");
			// JOptionPane.showMessageDialog(null, "Conectado :D ");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

		return con;
	}

	public boolean registrarUsuario(RegisterUser ru) {
		String sql = "insert into usuario (Nombre,contrasena) values (?,?) ";
		boolean registrado = false;
		int exito;
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, RegisterUser.getUsuario());
			ps.setString(2, RegisterUser.getContrasena());

			exito = ps.executeUpdate();
			if (exito > 0) {
				JOptionPane.showMessageDialog(null, "OK");
				registrado = true;
			}
			conectar().close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

		return registrado;
	}

	public boolean log(String usuario, String contrasena) {
		boolean enco = false;
		String sql = "select * from usuario where nombre=? and contrasena=?";
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, PantallaInicio.getUsuario());
			ps.setString(2, PantallaInicio.getContrasena());
			rs = ps.executeQuery();

			if (rs.next()) {
				enco = true;
				
			}
			conectar().close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

		return enco;
	}
	
	
	public boolean logad(String usuario, String contrasena) {
		boolean enco = false;
		String sql = "select * from admin where nombre=? and contrasena=?";
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, PantallaInicio.getAdmin());
			ps.setString(2, PantallaInicio.getContradmin());
			rs = ps.executeQuery();

			if (rs.next()) {
				enco = true;
				
			}
			conectar().close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

		return enco;
	}
	

	public boolean registrarAdministrador(RegistrarAdmin registrarAdmin) {
		String sql = "insert into admin (nombre,contrasena,correo,noMatricula) values (?,?,?,?) ";
		boolean registrado = false;
		int exito;
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, RegistrarAdmin.getUsuario());
			ps.setString(2, RegistrarAdmin.getContrasena());
			ps.setString(3, RegistrarAdmin.getCorreo());
			ps.setString(4, RegistrarAdmin.getNoMatricula());
			exito = ps.executeUpdate();
			if (exito > 0) {
				// JOptionPane.showMessageDialog(null, "OK");
				registrado = true;
			}
			conectar().close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

		return registrado;

	}

	public boolean insertarRepote(RegistroDanos RD) {
		String sql = "insert into dano (Nombre,cantidad,usuario,descripcion,estatus,lugar) values (?,?,?,?,?,?) ";
		boolean registrado = false;
		int exito;
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, RegistroDanos.getNombreMo());
			ps.setString(2, RegistroDanos.getCantidad());
			ps.setString(3, RegistroDanos.getUsuario());
			ps.setString(4, RegistroDanos.getDescrip());
			ps.setString(5, RegistroDanos.getStatus());
			ps.setString(6, RegistroDanos.getLugar());

			exito = ps.executeUpdate();
			if (exito > 0) {
				JOptionPane.showMessageDialog(null, "OK");
				registrado = true;
			}
			conectar().close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

		return registrado;
	}

	
	public boolean ad(VistAdm va) {
		boolean ad = false;

		String sql = "select * from dano";

		try {

			ps = conectar().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				VistAdm.setID(rs.getString("ID"));
				VistAdm.setNombre(rs.getString("Nombre"));
				VistAdm.setCantidad(rs.getString("Cantidad"));
				VistAdm.setUsuario(rs.getString("Usuario"));
				VistAdm.setDescripcion(rs.getString("Descripcion"));
				VistAdm.setFecha(rs.getString("Fecha"));
				VistAdm.setEstatus(rs.getString("Estatus"));
				VistAdm.setLuga(rs.getString("lugar"));

			}
			conectar().close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

		return ad;
	}
	
	public boolean ac(aceptacion ac) {
		boolean ok = false;
		int a;
		String sql ="UPDATE dano SET Estatus = 'Aceptado' where id=?";
		
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, aceptacion.getID());
			a = ps.executeUpdate();
			if (a>0) {
				ok=true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
		}
		
		return ok;
	}
	
	public boolean actodo() {
		boolean ok = false;
		int a;
		String sql ="UPDATE dano SET Estatus = 'Aceptado'";
		
		try {
			ps = conectar().prepareStatement(sql);
		
			a = ps.executeUpdate();
			if (a>0) {
				ok=true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
		}
		
		return ok;
	}
	
	public boolean borrar() {
		boolean ok = false;
		int a;
		String sql ="DELETE FROM dano where Estatus = 'Aceptado'";
		
		try {
			ps = conectar().prepareStatement(sql);
		
			a = ps.executeUpdate();
			if (a>0) {
				ok=true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
		}
		
		return ok;
	}



}
