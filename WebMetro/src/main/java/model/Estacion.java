package model;

public class Estacion {
	private int nestacion;
	private String nombre;
	
	public Estacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estacion(int nestacion, String nombre) {
		super();
		this.nestacion = nestacion;
		this.nombre = nombre;
	}
	
	public int getNestacion() {
		return nestacion;
	}
	public void setNestacion(int nestacion) {
		this.nestacion = nestacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Estacion [nestacion=" + nestacion + ", nombre=" + nombre + "]";
	}
	
	
}
