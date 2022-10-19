package model;

public class Jugador {
		private int codjugador;
		private String nombre;
		
		public Jugador() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Jugador(int codjugador, String nombre) {
			super();
			this.codjugador = codjugador;
			this.nombre = nombre;
		}

		public int getCodjugador() {
			return codjugador;
		}

		public void setCodjugador(int codjugador) {
			this.codjugador = codjugador;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public String toString() {
			return "Jugador [codjugador=" + codjugador + ", nombre=" + nombre + "]";
		}
		
		
}
