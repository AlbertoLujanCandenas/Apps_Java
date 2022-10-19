package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;

public class DAOBici {

	//SELECT obtener Bici
	public ArrayList<Bici> getBiciByMarca(String marca, String orden, String fav) {
		ResultSet rs;
		ArrayList<Bici> Bicis = new ArrayList<Bici>();

		Connection con = Conexion.conecta();
		Statement st;
		
		try {
			
			st = con.createStatement();
			String ordenSql = "select b.id, foto, marca, "
		   			+ "nombre nombremarca, descripcion, precio, fav "
		   			+ "from bici b, marca m "
		   			+ "where marca=m.id and fav like '"+fav+"' and "
		   			+ "marca like '"+marca+"' order by "+orden;;
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				
				Bici bici = new Bici();
				bici.setDescripcion(rs.getString("descripcion"));
				bici.setFav(rs.getInt("fav"));
				bici.setId(rs.getInt("id"));
				bici.setFoto(rs.getString("foto"));
				bici.setPrecio(rs.getInt("precio"));
				
				Bicis.add(bici);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return Bicis;
	}
	
	
	//UPDATE
	public ArrayList<Bici> setFav (String id, int fav) {
		ResultSet rs;
		ArrayList<Bici> Bicis = new ArrayList<Bici>();

		Connection con = Conexion.conecta();
		Statement st;
		
		try {
			
			st = con.createStatement();
		   	String ordenSql ="UPDATE bici SET fav = "+fav + " WHERE id = " + id;;
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				
				Bici bici = new Bici();
				bici.setFav(rs.getInt("fav"));
				bici.setId(rs.getInt("id"));
				
				Bicis.add(bici);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return Bicis;
	}
}