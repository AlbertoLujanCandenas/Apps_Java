package parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import model.Ciudad;
import model.Pais;
import model.Provincia;

public class ManejadorWeb extends DefaultHandler {

	private XMLReader xr;
	private String lastContent;
	private InputSource is;
	private ArrayList<Pais> listaPaises;
	private Pais pais;
	private ArrayList<Provincia> listaProvincias;
	private Provincia provincia;
	private ArrayList<Ciudad> listaCiudades;
	private Ciudad ciudad;
	private boolean isCity = false;

	public ManejadorWeb(String strUrl) {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setNamespaceAware(true);
		SAXParser parser;
		try {
			parser = parserFactory.newSAXParser();
			xr = parser.getXMLReader();
			this.is = new InputSource(new URL(strUrl).openStream());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		xr.setContentHandler(this);
		xr.setErrorHandler(this);
	}

	public ArrayList<Pais> parsear() {
		// En este caso como el xml esta en Internet debemos crear el stream y
		// con este el source
		try {
			// La llamada a este metodo es el que desencadena todo el proceso
			xr.parse(this.is);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return listaPaises;
	}

	@Override
	public void startDocument() throws SAXException {
		listaPaises = new ArrayList<Pais>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if (localName.equals("country")) {
			pais = new Pais();
			pais.setNumHabitantes(attributes.getValue("population"));
			pais.setNombre(attributes.getValue("name"));
			listaProvincias = new ArrayList<Provincia>();
			pais.setProvincias(listaProvincias);
		} else if (localName.equals("province")) {
			provincia = new Provincia();
			provincia.setNumHabitantes(attributes.getValue("population"));
			provincia.setNombre(attributes.getValue("name"));
			listaCiudades = new ArrayList<Ciudad>();
			provincia.setCiudades(listaCiudades);
		} else if (localName.equals("city")) {
			if (provincia == null) {
				listaCiudades = new ArrayList<Ciudad>();
				provincia = new Provincia("anonima", "0", listaCiudades);
				listaProvincias.add(provincia);
			}
			isCity = true;
			ciudad = new Ciudad();
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (localName.equals("country")) {
			listaPaises.add(pais);
			// la ponemos a null por si nos viene despues pais sin provincia
			provincia = null;
		} else if (localName.equals("province")) {
			listaProvincias.add(provincia);
		} else if (localName.equals("city")) {
			isCity = false;
			listaCiudades.add(ciudad);
		} else if (localName.equals("name") && isCity) {
			ciudad.setNombre(lastContent);
		} else if (localName.equals("population") && isCity) {
			ciudad.setNumHabitantes(lastContent);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		lastContent = String.valueOf(ch, start, length);
	}

}
