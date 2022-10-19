package view;

import java.util.ArrayList;

import model.Pais;
import parser.ManejadorWeb;

public class Launch {
	
	public static void main(String[] args) {
		ArrayList<Pais> paises = new ManejadorWeb("http://aiweb.cs.washington.edu/research/projects/xmltk/xmldata/data/mondial/mondial-3.0.xml").parsear();
		
		for (Pais pais : paises) {
			if (pais.getNombre().equals("United Kingdom"))
				System.out.println(pais);
		}
	}

}
