package api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import modelMovie.TMDBmovie;
import modelPerson.TMDBperson;

public class Manejador {

	private String jsonTxt = null;
	
	public Manejador(String url) {
		try {
			jsonTxt = IOUtils.toString(new URL(url),Charset.forName("utf-8"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TMDBperson getDataPerson() {
		TMDBperson tmdbPerson = new Gson().fromJson(jsonTxt, TMDBperson.class);
		return tmdbPerson;
	}
	
	public TMDBmovie getDataMovie() {
		TMDBmovie tmdbMovie = new Gson().fromJson(jsonTxt, TMDBmovie.class);
		return tmdbMovie;
	}
}
