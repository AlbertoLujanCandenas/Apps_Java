package poblacion;

import java.util.ArrayList;

public class Provincia {

	String nombre;
	String poblacion;
	ArrayList<Ciudades> listaCiudades = new ArrayList<Ciudades>();
	
	public Provincia() {
		super();
	}
	
	public Provincia(String nombre, String poblacion) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "Provincias [nombre=" + nombre + ", poblacion=" + poblacion +"]";
	}
}