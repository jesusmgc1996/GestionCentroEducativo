package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class ProfessorController {
	
	/**
	 * Método para obtener un registro
	 * @param str
	 * @return
	 */
	private static Professor getRecord(String str) {
		Professor p = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				p = new Professor();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("nombre"));
				p.setFirstSurname(rs.getString("apellido1"));
				p.setSecondSurname(rs.getString("apellido2"));
				p.setDni(rs.getString("dni"));
				p.setAddress(rs.getString("direccion"));
				p.setEmail(rs.getString("email"));
				p.setPhone(rs.getString("telefono"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Método para cargar el primer registro
	 * @return
	 */
	public static Professor getFirst() {
		return getRecord("select * from centroeducativo.profesor order by id limit 1");
	}
	
	/**
	 * Método para cargar el registro anterior
	 * @param id
	 * @return
	 */
	public static Professor getPrevious(int id) {
		return getRecord("select * from centroeducativo.profesor where id < " + id + " order by id desc limit 1");
	}
	
	/**
	 * Método para cargar el siguiente registro
	 * @param id
	 * @return
	 */
	public static Professor getNext(int id) {
		return getRecord("select * from centroeducativo.profesor where id > " + id + " order by id limit 1");
	}
	
	/**
	 * Método para cargar el último registro
	 * @return
	 */
	public static Professor getLast() {
		return getRecord("select * from centroeducativo.profesor order by id desc limit 1");
	}
	
	/**
	 * Método para modificar un registro
	 * @param s
	 * @return
	 */
	public static int update(Professor p) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update centroeducativo.profesor set nombre = ?, apellido1 = ?,"
					+ " apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ? where id = " + p.getId());
			ps.setString(1, p.getName());
			ps.setString(2, p.getFirstSurname());
			ps.setString(3, p.getSecondSurname());
			ps.setString(4, p.getDni());
			ps.setString(5, p.getAddress());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getPhone());
			affectedRows = ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
	
	/**
	 * Método para insertar un registro
	 * @param s
	 * @return
	 */
	public static int insert(Professor p) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into centroeducativo.profesor (id, nombre, apellido1,"
					+ " apellido2, dni, direccion, email, telefono) values (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, getNextValid(conn));
			ps.setString(2, p.getName());
			ps.setString(3, p.getFirstSurname());
			ps.setString(4, p.getSecondSurname());
			ps.setString(5, p.getDni());
			ps.setString(6, p.getAddress());
			ps.setString(7, p.getEmail());
			ps.setString(8, p.getPhone());
			affectedRows = ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
	
	/**
	 * Método para eliminar un registro
	 * @param id
	 * @return
	 */
	public static int delete(int id) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.profesor where id = " + id);
			affectedRows = ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return affectedRows;
	}
	
	/**
	 * Método para comprobar el siguiente registro válido
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public static int getNextValid(Connection conn) throws SQLException {
		int id = 1;
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.profesor");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1) + 1;
		}
		rs.close();
		ps.close();
		return id;
	}
	
	/**
	 * Método para guardar los registros en una lista
	 * @return
	 */
	public static List<Professor> getAll() {
		List<Professor> professors = new ArrayList<Professor>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.profesor");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setFirstSurname(rs.getString(3));
				p.setSecondSurname(rs.getString(4));
				p.setDni(rs.getString(5));
				p.setAddress(rs.getString(6));
				p.setEmail(rs.getString(7));
				p.setPhone(rs.getString(8));
				professors.add(p);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professors;
	}
	
}
