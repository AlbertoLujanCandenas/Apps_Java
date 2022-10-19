package modelMovie;

import java.util.List;

public class TMDBmovie {

	private List<Movie> results;

	public TMDBmovie(List<Movie> results) {
		super();
		this.results = results;
	}

	public List<Movie> getResults() {
		return results;
	}

	public void setResults(List<Movie> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "TMDBmovie [results=" + results + "]";
	}
	
}
