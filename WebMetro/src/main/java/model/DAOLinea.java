package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;

public class DAOLinea {
	
	public ArrayList<LineaLista> getLineas() {
		
		//------Creamos los objetos que usaremos
		
		//Las tuplas de los resultados
		ResultSet rs;
		
		//Lista con las lineas que nos devuelve el select
		ArrayList<LineaLista> lista = new ArrayList<LineaLista>();
		
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
			
			//Creamos la query
			String ordenSql = "SELECT nlinea, e1.nombre||' - '||e2.nombre inifin FROM linea, estacion e1, estacion e2 WHERE e1.nestacion = eini AND e2.nestacion = efin ORDER BY nlinea";
			
			//Ejecutar la query
			rs = st.executeQuery(ordenSql);

			//Mientras el ResultSet(cursor) tenga tuplas se ejecute el while
			//El rs.next() tambien hace que se cambie de tupla
			while (rs.next()) {
				
				//Creamos un objeto Linea donde almacenar los datos de la linea
				LineaLista lineaLista = new LineaLista();
				
				//Para obtener el valor de una colmna de la tupla tenemos que hacer un get diciendo el tipo de dato y entre parentesis un string con el nombre de la columna
				lineaLista.setNlinea(rs.getInt("nlinea"));
				lineaLista.setInifin(rs.getString("inifin"));
				//Hemos llamado nlinea y inifini a las columnas de la tupla
				
				//Añadimos el objeto linea a la lista
				lista.add(lineaLista);
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
