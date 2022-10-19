package poblacion;

public class Ciudades {

	 String nombre;
	 String poblacion;
	
	public Ciudades() {
		super();
	}
	public Ciudades(String nombre, String poblacion) {
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
		return "Ciudades [nombre=" + nombre + ", poblacion=" + poblacion + "]";
	}
}