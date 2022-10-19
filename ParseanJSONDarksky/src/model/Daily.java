package model;

import java.util.List;

public class Daily {

	private String summary;
	List<Data>data;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<Data> getDatos() {
		return data;
	}
	public void setDatos(List<Data> datos) {
		this.data = datos;
	}
	@Override
	public String toString() {
		return "Daily [summary=" + summary + ",\n datos=" + data + "]";
	}
	
	
}
