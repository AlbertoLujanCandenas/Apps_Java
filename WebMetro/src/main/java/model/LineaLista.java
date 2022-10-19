package model;

public class LineaLista {
	private int nlinea;
	private String inifin;
	
	public LineaLista() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LineaLista(int nlinea, String inifin) {
		super();
		this.nlinea = nlinea;
		this.inifin = inifin;
	}
	
	public int getNlinea() {
		return nlinea;
	}
	public void setNlinea(int nlinea) {
		this.nlinea = nlinea;
	}
	public String getInifin() {
		return inifin;
	}
	public void setInifin(String inifin) {
		this.inifin = inifin;
	}
	
	@Override
	public String toString() {
		return "LineaLista [nlinea=" + nlinea + ", inifin=" + inifin + "]";
	}
	
	
}