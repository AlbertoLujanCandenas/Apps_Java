package view;

import api.Manejador;
import modelMovie.TMDBmovie;
import modelPerson.TMDB;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//TMDB pruebaPerson = new Manejador("http://api.themoviedb.org/3/person/popular?api_key=b8a40ad963d530b1a6997d1be5fa52cf").getDataPerson();
		TMDBmovie pruebaMovie = new Manejador("http://api.themoviedb.org/3/movie/popular?api_key=b8a40ad963d530b1a6997d1be5fa52cf").getDataMovie();
		System.out.println(pruebaMovie);
	}

}
