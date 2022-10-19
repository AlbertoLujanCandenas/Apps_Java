package modelMovie;

import java.util.List;

public class TMDBmovie {

	private List<Pelicula> results;

	public TMDBmovie(List<Pelicula> results) {
		super();
		this.results = results;
	}

	public List<Pelicula> getResults() {
		return results;
	}

	public void setResults(List<Pelicula> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "TMDB [results=" + results + "]";
	}
}
