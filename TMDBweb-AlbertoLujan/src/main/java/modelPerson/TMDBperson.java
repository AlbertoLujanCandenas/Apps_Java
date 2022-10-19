package modelPerson;

import java.util.List;

public class TMDBperson {

	private List<Actor> results;
	
	public TMDBperson(List<Actor> results) {
		super();
		this.results = results;
	}

	public List<Actor> getResults() {
		return results;
	}

	public void setResults(List<Actor> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "TMDBperson [results=" + results + "]";
	}
}
