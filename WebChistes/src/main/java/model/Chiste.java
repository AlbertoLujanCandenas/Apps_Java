package model;

public class Chiste {

	private String titulo;
	private int idCategoria;
	private String descripcion;
	private String adopo;
	private int id;
	
	public Chiste() {
	}

	public Chiste(String titulo, int idCategoria, String descripcion, String adopo, int id) {
		this.titulo = titulo;
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.adopo = adopo;
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAdopo() {
		return adopo;
	}

	public void setAdopo(String adopo) {
		this.adopo = adopo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Chiste [titulo=" + titulo + ", idCategoria=" + idCategoria + ", descripcion=" + descripcion + ", adopo="
				+ adopo + ", id=" + id + "]";
	}
}
