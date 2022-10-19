package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;

public class DAOEstacion {
	
	public ArrayList<Estacion> getEstaciones(String nLinea) {
		
		//------Creamos los objetos que usaremos
		
		//Las tuplas de los resultados
		ResultSet rs;
		
		//Lista con las lineas que nos devuelve el select
		ArrayList<Estacion> lista = new ArrayList<Estacion>();
		
		//Conexion a la base de datos
		Connection con = Conexion.conecta();
		
		//Creamos la interfaz que representa un statement en SQL simple
		Statement st;
		//Si queremos una a la que podamos pasarle parametros necesitaremos una PreparedStatement
		
		try {
			
			//Instanciamos la interfaz que representa un statement en SQL simple para la conexion
			st = con.createStatement();
			/*
			 * 3 metodos principales:
			 * 	- execute: devuelve true si el primer objeto que se devuelve es un resultset
			 * 	- executeQuery(QUERY): devuelve un resultset con las tuplas, se le pasa entre parentesis la QUERY en String
			 * 	- executeUpdate: devuelve un int mostrando cuantas filas se han modificado, para updates, deletes e inserts
			 */
			
			//Creamos la query que nos devolvera en base a la linea que se haya introducido
			String ordenSql = "SELECT nombre FROM estacion e, le WHERE e.nestacion = le.nestacion AND nlinea = "+nLinea+" ORDER BY le.orden";
			
			//Ejecutar la query
			rs = st.executeQuery(ordenSql);

			//Mientras el ResultSet(cursor) tenga tuplas se ejecute el while
			//El rs.next() tambien hace que se cambie de tupla
			while (rs.next()) {
				
				//Creamos un objeto Linea donde almacenar los datos de la linea
				Estacion estacion = new Estacion();
				
				//Para obtener el valor de una colmna de la tupla tenemos que hacer un get diciendo el tipo de dato y entre parentesis un string con el nombre de la columna
				estacion.setNombre(rs.getString("nombre"));
				//Hemos llamado a la columna nombre
				
				//Añadimos el objeto linea a la lista
				lista.add(estacion);
			}
			
			//Cerramos todo lo que hemos abierto antes, esto tambien se puede hacer en el finally
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		
		return lista;
	}

}
