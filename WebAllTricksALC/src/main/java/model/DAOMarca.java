package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;

public class DAOMarca {

	//SELECT obtener marcas
	public ArrayList<Marca> getMarca() {
		ResultSet rs;
		ArrayList<Marca> Marcas = new ArrayList<Marca>();

		Connection con = Conexion.conecta();
		Statement st;
		
		try {
			
			st = con.createStatement();
			String ordenSql = "SELECT * FROM Marca";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				
				Marca marca = new Marca();
				marca.setNombre(rs.getString("nombre"));
				marca.setId(rs.getInt("id"));
				
				Marcas.add(marca);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return Marcas;
	}
	
	//SELECT MARCA SOLA
	public String getMarcaSola(String id) {
		ResultSet rs;
		String nombreMarca = "";
		
		Connection con = Conexion.conecta();
		Statement st;
		
		try {
			
			st = con.createStatement();
			String ordenSql = "SELECT * FROM marca WHERE id = " + id;
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				
				Marca marcaSola = new Marca();
				marcaSola.setNombre(rs.getString("nombre"));
				marcaSola.setId(rs.getInt("id"));
				
				nombreMarca = marcaSola.getNombre();
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return nombreMarca;
	}
	
}
