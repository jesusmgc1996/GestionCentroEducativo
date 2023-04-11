package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SexTypology;

public class SexTypologyController {

	/**
	 * Método para guardar los registros en una lista
	 * @return
	 */
	public static List<SexTypology> getAll() {
		List<SexTypology> sexTypologys = new ArrayList<SexTypology>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.tipologiasexo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SexTypology s = new SexTypology();
				s.setId(rs.getInt(1));
				s.setDescripcion(rs.getString(2));
				sexTypologys.add(s);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sexTypologys;
	}

	/**
	 * Método para guardar un registro
	 * @return
	 */
	public static SexTypology getSexTypology(int id) {
		SexTypology s = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.tipologiasexo where id = " + id);
			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				s = new SexTypology();
				s.setId(rs.getInt(1));
				s.setDescripcion(rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
