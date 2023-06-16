package trabajofinal;

import java.util.ArrayList;

	public class catalogolibros{
		
	private ArrayList <libro1> catalogolibros;

	public catalogolibros() {
	
		catalogolibros = new ArrayList<libro1>();
		libro1 lib1 = new libro1("456-976-503","Algoritmica y Programacion", 57000);
		catalogolibros.add(lib1);
		libro1 lib2 = new libro1("634-300-523","Programacion en Java", 75000);
		catalogolibros.add(lib2);
		libro1 lib3 = new libro1("908-694-012","El lenguaje UML", 43700);
		catalogolibros.add(lib3);
		libro1 lib4 = new libro1("243-305-999","Usando JUnit", 60000);
		catalogolibros.add(lib4);
		libro1 lib5 = new libro1("103-976-453","Programacion en C#", 80000);
		catalogolibros.add(lib5);
	
	
	}
	public void Añadir (libro1 libr) {
		catalogolibros.add(libr);

	}
	public  libro1 Obtener(int posicion){
		return catalogolibros.get(posicion);

	}

	public int tamaño() {
		return catalogolibros.size();
	}
}


