package DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Equipo;

public class DAOEquipo {
		
	public ArrayList<Equipo> getEquipos() {
		ResultSet rs;
		ArrayList<Equipo> lista = new ArrayList<Equipo>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT codequipo,nombre from equipo";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Equipo equipo = new Equipo();
				equipo.setCodequipo(rs.getInt("codequipo"));
				equipo.setNombre(rs.getString("nombre"));
				
				lista.add(equipo);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}

}
