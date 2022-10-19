package modelPerson;

public class Actor {

	private long id;
	private String name;
	private double popularity;
	private String profile_path;
	
	public Actor(long id, String name, double popularity, String profile_path) {
		this.id = id;
		this.name = name;
		this.popularity = popularity;
		this.profile_path = profile_path;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPopularity() {
		return popularity;
	}
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	public String getProfile_path() {
		return profile_path;
	}
	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	@Override
	public String toString() {
		return "\nResultado [id = " + id + " name=" + name + ", popularity=" + popularity + ", profile_path=" + " https://image.tmdb.org/t/p/w500" + profile_path + "]\n";
	}
}