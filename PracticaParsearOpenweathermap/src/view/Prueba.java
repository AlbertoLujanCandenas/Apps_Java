package view;

import java.util.ArrayList;

import model.Hora;
import parser.OpenWeatherMap;

public class Prueba {

	public static void main(String[] args) {
		ArrayList<Hora> horas = new OpenWeatherMap().getHoras();
		
		for(Hora hora:horas) System.out.println(hora);
	}
}