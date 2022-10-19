package model;

public class DarkSky {

	private float latitude;
	private float longitude;
	private String timezone;
	private Currently currently;
	private Daily daily;
	

	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	@Override
	public String toString() {
		return "DarkSky [latitude=" + latitude + ", longitude=" + longitude + ", timezone=" + timezone + ",\n currently="
				+ currently + ",\n daily=" + daily + "]";
	}
	
	
	
}
