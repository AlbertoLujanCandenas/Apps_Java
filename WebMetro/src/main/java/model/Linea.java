package model;

public class Linea {
	private int nlinea;
	private int eini;
	private int efin;
	
	public Linea() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Linea(int nlinea, int eini, int efin) {
		super();
		this.nlinea = nlinea;
		this.eini = eini;
		this.efin = efin;
	}
	
	public int getNlinea() {
		return nlinea;
	}
	public void setNlinea(int nlinea) {
		this.nlinea = nlinea;
	}
	public int getEini() {
		return eini;
	}
	public void setEini(int eini) {
		this.eini = eini;
	}
	public int getEfin() {
		return efin;
	}
	public void setEfin(int efin) {
		this.efin = efin;
	}
	
	@Override
	public String toString() {
		return "Linea [nlinea=" + nlinea + ", eini=" + eini + ", efin=" + efin + "]";
	}

}