package model;

import java.util.ArrayList;

public class Provincia {
	private String nombre;
	private String numHabitantes;
	private ArrayList<Ciudad> ciudades;
	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provincia(String nombre, String numHabitantes, ArrayList<Ciudad> ciudades) {
		super();
		this.nombre = nombre;
		this.numHabitantes = numHabitantes;
		this.ciudades = ciudades;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumHabitantes() {
		return numHabitantes;
	}
	public void setNumHabitantes(String numHabitantes) {
		this.numHabitantes = numHabitantes;
	}
	public ArrayList<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", numHabitantes=" + numHabitantes + ", ciudades=" + ciudades + "]";
	}
	
	

}
