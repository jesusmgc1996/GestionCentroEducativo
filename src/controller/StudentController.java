package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentController {
	
	/**
	 * Método para obtener un registro
	 * @param str
	 * @return
	 */
	private static Student getRecord(String str) {
		Student s = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("nombre"));
				s.setFirstSurname(rs.getString("apellido1"));
				s.setSecondSurname(rs.getString("apellido2"));
				s.setDni(rs.getString("dni"));
				s.setAddress(rs.getString("direccion"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getString("telefono"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * Método para cargar el primer registro
	 * @return
	 */
	public static Student getFirst() {
		return getRecord("select * from centroeducativo.estudiante order by id limit 1");
	}
	
	/**
	 * Método para cargar el registro anterior
	 * @param id
	 * @return
	 */
	public static Student getPrevious(int id) {
		return getRecord("select * from centroeducativo.estudiante where id < " + id + " order by id desc limit 1");
	}
	
	/**
	 * Método para cargar el siguiente registro
	 * @param id
	 * @return
	 */
	public static Student getNext(int id) {
		return getRecord("select * from centroeducativo.estudiante where id > " + id + " order by id limit 1");
	}
	
	/**
	 * Método para cargar el último registro
	 * @return
	 */
	public static Student getLast() {
		return getRecord("select * from centroeducativo.estudiante order by id desc limit 1");
	}
	
	/**
	 * Método para modificar un registro
	 * @param s
	 * @return
	 */
	public static int update(Student s) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();

			PreparedStatement ps = conn.prepareStatement("update centroeducativo.estudiante set nombre = ?, apellido1 = ?,"
					+ " apellido2 = ?, dni = ?, direccion = ?, email = ?, telefono = ? where id = " + s.getId());
			ps.setString(1, s.getName());
			ps.setString(2, s.getFirstSurname());
			ps.setString(3, s.getSecondSurname());
			ps.setString(4, s.getDni());
			ps.setString(5, s.getAddress());
			ps.setString(6, s.getEmail());
			ps.setString(7, s.getPhone());
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
	public static int insert(Student s) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into centroeducativo.estudiante (id, nombre, apellido1,"
					+ " apellido2, dni, direccion, email, telefono) values (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, getNextValid(conn));
			ps.setString(2, s.getName());
			ps.setString(3, s.getFirstSurname());
			ps.setString(4, s.getSecondSurname());
			ps.setString(5, s.getDni());
			ps.setString(6, s.getAddress());
			ps.setString(7, s.getEmail());
			ps.setString(8, s.getPhone());
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
			PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.estudiante where id = " + id);
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
	 * @return
	 * @throws SQLException 
	 */
	public static int getNextValid(Connection conn) throws SQLException {
		int id = 1;
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.estudiante");
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
	public static List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.estudiante");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setFirstSurname(rs.getString(3));
				s.setSecondSurname(rs.getString(4));
				s.setDni(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setEmail(rs.getString(7));
				s.setPhone(rs.getString(8));
				students.add(s);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
}
