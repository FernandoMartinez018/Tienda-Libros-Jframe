package trabajofinal;

public class clasecompra {

	private String ISBN;
	private String Titulo;
	private int Cantidad;
	private float subTotal;
	
	public clasecompra(String iSBN, String titulo, int cantidad, float subTotal) {
		
		ISBN = iSBN;
		this.Titulo = titulo;
		this.Cantidad = cantidad;
		this.subTotal = subTotal;
		
		
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public float getsubTotal() {
		return subTotal;
	}
	public void setsubTotal(float subTotal) {
		subTotal = subTotal;
	}
	
	
}
