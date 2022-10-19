package model;


public class Ciudad {
	private String nombre;
	private String numHabitantes;
	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ciudad(String nombre, String numHabitantes) {
		super();
		this.nombre = nombre;
		this.numHabitantes = numHabitantes;
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
	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", numHabitantes=" + numHabitantes + "]";
	}
	
	

}
