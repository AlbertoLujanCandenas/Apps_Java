package DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Jugador;

public class DAOJugador {
	public ArrayList<Jugador> getJugadores(String equipo) {
		ResultSet rs;
		ArrayList<Jugador> lista = new ArrayList<Jugador>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT j.nombre from jugador j, plantilla p where j.codjugador=p.jugador and p.equipo="+equipo;
			rs = st.executeQuery(ordenSql);
			
			while (rs.next()) {
				Jugador jugador = new Jugador();
				jugador.setNombre(rs.getString("nombre"));
				
				
				lista.add(jugador);
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
