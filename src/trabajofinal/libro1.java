package trabajofinal;

	public class libro1{
		String ISBN;
		String Titulo;
		float Precio;


		public libro1(String iSBN, String titulo, float precio) {
			ISBN = iSBN;
			this.Titulo = titulo;
			this.Precio = precio;
			
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


		public float getPrecio() {
			return Precio;
		}


		public void setPrecio(float precio) {
			Precio = precio;
		}
	}
	

