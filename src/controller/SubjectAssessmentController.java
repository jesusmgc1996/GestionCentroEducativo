package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SubjectAssessment;

public class SubjectAssessmentController {
	
	/**
	 * Método para obtener un registro
	 * @param str
	 * @return
	 */
	private static SubjectAssessment getRecord(String str) {
		SubjectAssessment s = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				s = new SubjectAssessment();
				s.setId(rs.getInt("id"));
				s.setProfessorId(rs.getInt("idProfesor"));
				s.setStudentId(rs.getInt("idEstudiante"));
				s.setSubjectId(rs.getInt("idMateria"));
				s.setAssessment(rs.getFloat("valoracion"));
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
	public static SubjectAssessment getFirst() {
		return getRecord("select * from centroeducativo.valoracionmateria order by id limit 1");
	}
	
	/**
	 * Método para cargar el registro anterior
	 * @param id
	 * @return
	 */
	public static SubjectAssessment getPrevious(int id) {
		return getRecord("select * from centroeducativo.valoracionmateria where id < " + id + " order by id desc limit 1");
	}
	
	/**
	 * Método para cargar el siguiente registro
	 * @param id
	 * @return
	 */
	public static SubjectAssessment getNext(int id) {
		return getRecord("select * from centroeducativo.valoracionmateria where id > " + id + " order by id limit 1");
	}
	
	/**
	 * Método para cargar el último registro
	 * @return
	 */
	public static SubjectAssessment getLast() {
		return getRecord("select * from centroeducativo.valoracionmateria order by id desc limit 1");
	}
	
	/**
	 * Método para modificar un registro
	 * @param s
	 * @return
	 */
	public static int update(SubjectAssessment s) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update centroeducativo.valoracionmateria set"
					+ " idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ? where id = " + s.getId());
			ps.setInt(1, s.getProfessorId());
			ps.setInt(2, s.getStudentId());
			ps.setInt(3, s.getSubjectId());
			ps.setFloat(4, s.getAssessment());
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
	public static int insert(SubjectAssessment s) {
		int affectedRows = 0;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into centroeducativo.valoracionmateria"
					+ " (id, idProfesor, idEstudiante, idMateria, valoracion) values (?, ?, ?, ?, ?)");
			ps.setInt(1, getNextValid(conn));
			ps.setInt(2, s.getProfessorId());
			ps.setInt(3, s.getStudentId());
			ps.setInt(4, s.getSubjectId());
			ps.setFloat(5, s.getAssessment());
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
			PreparedStatement ps = conn.prepareStatement("delete from centroeducativo.valoracionmateria where id = " + id);
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
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.valoracionmateria");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1) + 1;
		}
		rs.close();
		ps.close();
		return id;
	}
	
}
