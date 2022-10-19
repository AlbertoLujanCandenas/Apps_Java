package view;

import api.Manejador;
import modelMovie.TMDBmovie;
import modelPerson.TMDBperson;

public class Ejectutar {

	public static void main(String[] args) {

		TMDBperson personas = new Manejador("http://api.themoviedb.org/3/person/popular?api_key=b8a40ad963d530b1a6997d1be5fa52cf").getDataPerson();
		TMDBmovie peliculas = new Manejador("http://api.themoviedb.org/3/movie/popular?api_key=b8a40ad963d530b1a6997d1be5fa52cf").getDataMovie();
		System.out.println(peliculas);
		System.out.println(personas);
		}

}
