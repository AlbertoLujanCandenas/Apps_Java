package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;

public class DAOChiste {
	// select
	public void name() {
		
	}
		public ArrayList<Chiste> getChiste(String categoria) {
			ResultSet rs;
			ArrayList<Chiste> chistes = new ArrayList<Chiste>();

			Connection con = Conexion.conecta();
			Statement st;
			try {
				st = con.createStatement();
				String ordenSql = "SELECT * from CHISTE WHERE IDCATEGORIA = "+categoria;
				rs = st.executeQuery(ordenSql);

				while (rs.next()) {
					Chiste chiste = new Chiste();
					chiste.setAdopo(rs.getString("adopo"));
					chiste.setDescripcion(rs.getString("descripcion"));
					chiste.setId(rs.getInt("id"));
					chiste.setIdCategoria(rs.getInt("idCategoria"));
					chiste.setTitulo(rs.getString("titulo"));
					
					chistes.add(chiste);
				}
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al acceder a la BDs: " + e.getMessage());
			}
			return chistes;
		}
}