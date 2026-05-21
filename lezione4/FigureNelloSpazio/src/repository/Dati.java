package repository;

public class Dati {
	private String tipo;
	private int contatore;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getContatore() {
		return contatore;
	}
	public void setContatore(int contatore) {
		this.contatore = contatore;
	}
	public Dati(String tipo, int contatore) {
		this.tipo = tipo;
		this.contatore = contatore;
	}
}
