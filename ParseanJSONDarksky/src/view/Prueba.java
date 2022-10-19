package view;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.DarkSky;

public class Prueba {

	public static void main (String args[]) {
		
		
		String urlTxt = "https://api.darksky.net/forecast/21259f9de3537b4f719c53580fa39c3a/39.8710026,-4.0251675?lang=es&exclude=minutely,hourly,alerts,flags";
		
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
		
		DarkSky darkSky = new Gson().fromJson(jsonTxt, DarkSky.class);
		
		System.out.println(darkSky);
		
		//Hecho por Alberto Luján Candenas
	}
}
