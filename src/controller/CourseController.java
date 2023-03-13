package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseController {
	
	/**
	 * Método para obtener un registro
	 * @param str
	 * @return
	 */
	private static Course getRecord(String str) {
		Course c = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				c = new Course();
				c.setId(rs.getInt("id"));
				c.setDescription(rs.getString("descripcion"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * Método para cargar el primer registro
	 * @return
	 */
	public static Course getFirst() {
		return getRecord("select * from centroeducativo.curso order by id limit 1");
	}
	
	/**
	 * Método para cargar el registro anterior
	 * @param id
	 * @return
	 */
	public static Course getPrevious(int id) {
		return getRecord("select * from centroeducativo.curso where id < " + id + " order by id desc limit 1");
	}
	
	/**
	 * Método para cargar el siguiente registro
	 * @param id
	 * @return
	 */
	public static Course getNext(int id) {
		return getRecord("select * from centroeducativo.curso where id > " + id + " order by id limit 1");
	}
	
	/**
	 * Método para cargar el último registro
	 * @return
	 */
	public static Course getLast() {
		return getRecord("select * from centroeducativo.curso order by id desc limit 1");
	}
	
	/**
	 * Método para modificar un registro
	 * @param s
	 * @return
	 */
	public static int update(Course c) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update centroeducativo.curso"
					+ " set descripcion = ? where id = " + c.getId());
			ps.setString(1, c.getDescription());
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
	public static int insert(Course c) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into centroeducativo.curso"
					+ " (id, descripcion) values (?, ?)");
			ps.setInt(1, getNextValid(conn));
			ps.setString(2, c.getDescription());
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
			PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.curso where id = " + id);
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
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.curso");
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
	public static List<Course> getAll() {
		List<Course> courses = new ArrayList<Course>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.curso");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Course c = new Course();
				c.setId(rs.getInt(1));
				c.setDescription(rs.getString(2));
				courses.add(c);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}
	
}
