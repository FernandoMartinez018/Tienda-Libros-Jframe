package trabajofinal;

import java.util.ArrayList;

public class catalogo1 {

	ArrayList<clasecompra> catalogo1;
	
	
	public catalogo1() {
		catalogo1 = new ArrayList<clasecompra>();
	}
	
	public void adiccionar(clasecompra com) {
		catalogo1.add(com);
	}
	
	public clasecompra Obtener(int posicion) {
		return catalogo1.get(posicion);
	}
	
	public int tamaño() {
		return catalogo1.size();
	}
	
	public void eliminar(String ISBN) {
		for (int i = 0; i < catalogo1.size(); i++) {
			if(catalogo1.get(i).getISBN().equals(ISBN)) {
				catalogo1.remove(i);
			}
		}
		
	}
	public float Compra_total() {
		
		float total=0;
		 for(int i= 0; i<catalogo1.size();i++ ) {
			 total=total+catalogo1.get(i).getsubTotal();
		 }
			 
		return total;
	}
}
