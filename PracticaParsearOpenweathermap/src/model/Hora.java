package model;

public class Hora {

	private String from;
	private String to;
	private String icono;
	private String pp;
	private String prono;
	private String max;
	private String min;
	
	public Hora() {
		
	}
	
	public Hora(String from, String to, String icono, String pp, String prono, String max, String min) {
		this.from = from;
		this.to = to;
		this.icono = icono;
		this.pp = pp;
		this.prono = prono;
		this.max = max;
		this.min = min;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public String getProno() {
		return prono;
	}

	public void setProno(String prono) {
		this.prono = prono;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public void conversionMax(String max) {
		this.max = max;
		int convertidoInt = Integer.parseInt(max);
		convertidoInt -= 275;
	}
	public void conversionMin(String min) {
		this.min = min;
		int convertidoInt = Integer.parseInt(min);
		convertidoInt -= 275;
	}
	
	@Override
	public String toString() {
		return "Hora [from=" + from + ", to=" + to + ", icono=" + icono + ", pp=" + pp + ", prono=" + prono + ", max="
				+ max + ", min=" + min + "]";
	}
}
