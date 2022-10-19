package view;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonToken;

import model.Artista;
import model.Musica;

public class Prueba {

	public static void main(String[] args) {
		
		String urlTxt = "http://ws.audioscrobbler.com/2.0/?method=user.gettopartists&user=rj&api_key=35066a49f2deb23a3c35fd48ff5c9869&format=json";

		String jsonTxt = null;
		
		try {
			jsonTxt = IOUtils.toString(new URL(urlTxt));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Musica musica = new Gson().fromJson(jsonTxt, Musica.class);

		
		List<Artista> artistas = musica.getTopartists().getArtist();
		for (Artista artista : artistas) {
			System.out.println(artista);
		}
		//Hecho por Alberto Luján Candenas
	}
}