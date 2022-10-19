package poblacion;

import java.util.ArrayList;

public class Pais {

	String nombre;
	String poblacion;
	ArrayList<Provincia> listaProvincias = new ArrayList<Provincia>();
	
public Pais() {
	
}

public Pais(String nombre, String poblacion) {
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
	return "Pais" + ", nombre=" + nombre + ", poblacion=" + poblacion + ", listaProvincias= " + listaProvincias + "]";
}
}