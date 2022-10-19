package parser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Hora;

public class OpenWeatherMap {

	private Document doc;
	private ArrayList<Hora> horas;
	public OpenWeatherMap() {
		doc = new DOMParserWeb("http://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&mode=xml&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp").getDocumento();
	}
	public ArrayList<Hora> getHoras(){
		NodeList nodosHoras = doc.getElementsByTagName("time");
		horas = new ArrayList<Hora>();
		for(int i = 0; i<nodosHoras.getLength(); i++) {
			Hora hora = new Hora();
			Element nodohora = (Element) nodosHoras.item(i);
			hora.setFrom(nodohora.getAttribute("from"));
			hora.setTo(nodohora.getAttribute("to"));
			Element nodotemperatura = (Element) nodohora.getElementsByTagName("temperature").item(0);
			hora.setMax(nodotemperatura.getAttribute("max"));
			hora.setMin(nodotemperatura.getAttribute("min"));
			Element nodopronostico = (Element) nodohora.getElementsByTagName("symbol").item(0);
			hora.setProno(nodopronostico.getAttribute("name"));
			hora.setIcono(nodopronostico.getAttribute("var"));
			Element nodoprecipitacion = (Element) nodohora.getElementsByTagName("precipitation").item(0);
			hora.setPp(nodoprecipitacion.getAttribute("probability"));
			
			horas.add(hora);
		}
		return horas;
	}
}