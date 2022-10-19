package model;

public class Data {

	private String summary;
	private String precipProbability;
	private String humidity;
	private String pressure;
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPrecipProbability() {
		return precipProbability;
	}
	public void setPrecipProbability(String precipProbability) {
		this.precipProbability = precipProbability;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	@Override
	public String toString() {
		return "Datos [summary=" + summary + ", precipProbability=" + precipProbability + ", humidity=" + humidity
				+ ", pressure=" + pressure + "]";
	}
	
	
}
