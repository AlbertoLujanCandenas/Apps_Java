package model;

public class Marca {

	private String nombre;
	private int id;
	
	public Marca() {
		
	}

	public Marca(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Marca [nombre=" + nombre + ", id=" + id + "]";
	}
	
}
