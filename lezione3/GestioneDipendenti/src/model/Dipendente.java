package model;

import java.util.Objects;

public class Dipendente extends Persona {
	//L'ereditarietà non è un copia e incolla: ciò che è privato continua ad essere privato. Ciò che è private rimane privato anche
	//in caso di ereditarietà. Ciò che è protected invece è private solo in caso di istanza.
	private String titoloDiStudio;
	private String ruoloAziendale;
	private double stipendio;
	
	public Dipendente() {}
	
	public Dipendente(int id, String nome, String cognome, String luogoDiNascita, String dataDiNascita, String sesso,
			String codiceFiscale, String titoloDiStudio, String ruoloAziendale, double stipendio) {
		super(id, nome, cognome, luogoDiNascita, dataDiNascita, sesso, codiceFiscale);
		this.titoloDiStudio = titoloDiStudio;
		this.ruoloAziendale = ruoloAziendale;
		this.stipendio = stipendio;
	}
	
	/*costruttore di copia
	 * 
	 * Permette di creare un oggetto copiandolo da un altro oggetto
	 * 
	 * */
	public Dipendente(Dipendente other) {
		super(other.getId(), other.getNome(), other.getCognome(), other.getLuogoDiNascita(), other.getDataDiNascita(), other.getSesso(), other.getCodiceFiscale());
		this.titoloDiStudio = other.getTitoloDiStudio();
		this.ruoloAziendale = other.getRuoloAziendale();
		this.stipendio = other.getStipendio();
	}

	public String getTitoloDiStudio() {
		return titoloDiStudio;
	}
	public void setTitoloDiStudio(String titoloDiStudio) {
		this.titoloDiStudio = titoloDiStudio;
	}
	public String getRuoloAziendale() {
		return ruoloAziendale;
	}
	public void setRuoloAziendale(String ruoloAziendale) {
		this.ruoloAziendale = ruoloAziendale;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	@Override
	public String toString() {
		return super.toString() + ";" + this.titoloDiStudio + ";" + this.ruoloAziendale + ";" + this.stipendio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ruoloAziendale, stipendio, titoloDiStudio);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dipendente other = (Dipendente) obj;
		return Objects.equals(ruoloAziendale, other.ruoloAziendale)
				&& Double.doubleToLongBits(stipendio) == Double.doubleToLongBits(other.stipendio)
				&& Objects.equals(titoloDiStudio, other.titoloDiStudio);
	}
	
	
}