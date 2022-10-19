package model;

public class Currently {

	private String summary;
	private String precipProbability;
	private String temperature;
	private String humidity;
	private String visibility;
	
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
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	@Override
	public String toString() {
		return "Currently [summary=" + summary + ", precipProbability=" + precipProbability + ", temperature="
				+ temperature + ", humidity=" + humidity + ", visibility=" + visibility + "]";
	}
	
	
	
	
}
