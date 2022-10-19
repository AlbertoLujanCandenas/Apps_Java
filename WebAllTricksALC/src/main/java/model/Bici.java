package model;

public class Bici {
	
	private int fav;
	private int precio;
	private String descripcion;
	private int marca;
	private String foto;
	private int id;
	
	public Bici() {
		
	}

	public Bici(int fav, int precio, String descripcion, int marca, String foto, int id) {
		this.fav = fav;
		this.precio = precio;
		this.descripcion = descripcion;
		this.marca = marca;
		this.foto = foto;
		this.id = id;
	}

	public int getFav() {
		return fav;
	}

	public void setFav(int fav) {
		this.fav = fav;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bici [fav=" + fav + ", precio=" + precio + ", descripcion=" + descripcion + ", marca=" + marca
				+ ", foto=" + foto + ", id=" + id + "]";
	}
	

}
