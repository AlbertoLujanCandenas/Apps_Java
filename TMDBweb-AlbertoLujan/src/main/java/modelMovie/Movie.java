package modelMovie;

public class Movie {

	private String title;
	private String release_date;
	private String vote_average;
	private String backdrop_path;
	
	public Movie(String title, String release_date, String vote_average, String backdrop_path) {
		super();
		this.title = title;
		this.release_date = release_date;
		this.vote_average = vote_average;
		this.backdrop_path = backdrop_path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRelease_date() {
		return release_date;
	}


	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getVote_average() {
		return vote_average;
	}

	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", release_date=" + release_date + ", vote_average=" + vote_average
				+ ", backdrop_path=" + backdrop_path + "]";
	}
	
}
