package model;

import java.util.ArrayList;

public class Pais {
	private String nombre;
	private String numHabitantes;
	private ArrayList<Provincia> provincias;
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pais(String nombre, String numHabitantes, ArrayList<Provincia> provincias) {
		super();
		this.nombre = nombre;
		this.numHabitantes = numHabitantes;
		this.provincias = provincias;
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
	public ArrayList<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(ArrayList<Provincia> provincias) {
		this.provincias = provincias;
	}
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", numHabitantes=" + numHabitantes + ", provincias=" + provincias + "]";
	}
	
	
	
}
