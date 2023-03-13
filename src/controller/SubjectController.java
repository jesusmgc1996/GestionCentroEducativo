package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Subject;

public class SubjectController {
	
	/**
	 * Método para obtener un registro
	 * @param str
	 * @return
	 */
	private static Subject getRecord(String str) {
		Subject s = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				s = new Subject();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("nombre"));
				s.setAcronym(rs.getString("acronimo"));
				s.setCourseId(rs.getInt("curso_id"));
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
	public static Subject getFirst() {
		return getRecord("select * from centroeducativo.materia order by id limit 1");
	}
	
	/**
	 * Método para cargar el registro anterior
	 * @param id
	 * @return
	 */
	public static Subject getPrevious(int id) {
		return getRecord("select * from centroeducativo.materia where id < " + id + " order by id desc limit 1");
	}
	
	/**
	 * Método para cargar el siguiente registro
	 * @param id
	 * @return
	 */
	public static Subject getNext(int id) {
		return getRecord("select * from centroeducativo.materia where id > " + id + " order by id limit 1");
	}
	
	/**
	 * Método para cargar el último registro
	 * @return
	 */
	public static Subject getLast() {
		return getRecord("select * from centroeducativo.materia order by id desc limit 1");
	}
	
	/**
	 * Método para modificar un registro
	 * @param s
	 * @return
	 */
	public static int update(Subject s) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update centroeducativo.materia set"
					+ " nombre = ?, acronimo = ?, curso_id = ? where id = " + s.getId());
			ps.setString(1, s.getName());
			ps.setString(2, s.getAcronym());
			ps.setInt(3, s.getCourseId());
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
	public static int insert(Subject s) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into centroeducativo.materia"
					+ " (id, nombre, acronimo, curso_id) values (?, ?, ?, ?)");
			ps.setInt(1, getNextValid(conn));
			ps.setString(2, s.getName());
			ps.setString(3, s.getAcronym());
			ps.setInt(4, s.getCourseId());
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
			PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.materia where id = " + id);
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
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.materia");
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
	public static List<Subject> getAll() {
		List<Subject> subjects = new ArrayList<Subject>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.materia");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Subject s = new Subject();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setAcronym(rs.getString(3));
				s.setCourseId(rs.getInt(4));
				subjects.add(s);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjects;
	}
	
}
