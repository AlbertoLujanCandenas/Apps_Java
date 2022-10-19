package poblacion;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Pais> listaPais = new ManejadorWeb("http://aiweb.cs.washington.edu/research/projects/xmltk/xmldata/data/mondial/mondial-3.0.xml").parsear();
		for (Pais pais: listaPais) System.out.println(pais);
	}
	//REALIZADO POR ALBERTO LUJAN CANDENAS 2º DAM
}
