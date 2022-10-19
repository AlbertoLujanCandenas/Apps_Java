package model;

public class Equipo {
		private int codequipo;
		private String nombre;
		public Equipo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Equipo(int codequipo, String nombre) {
			super();
			this.codequipo = codequipo;
			this.nombre = nombre;
		}
		public int getCodequipo() {
			return codequipo;
		}
		public void setCodequipo(int codequipo) {
			this.codequipo = codequipo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		@Override
		public String toString() {
			return "Equipo [codequipo=" + codequipo + ", nombre=" + nombre + "]";
		}
		
		
}
