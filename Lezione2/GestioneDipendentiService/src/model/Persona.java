package model;

import java.util.Objects;
import java.sql.Date;


public class Persona {
	private int id;
	private String nome;
	private String cognome;
	private String luogoDiNascita;
	private Date dataDiNascita;
	private String sesso;
	private String codiceFiscale;
	
	public Persona() {}
	
	
	
	public Persona(int id, String nome, String cognome, String luogoDiNascita, Date dataDiNascita, String sesso,
			String codiceFiscale) {
		super(); //Il metodo super() serve ad alimentare il costruttore della classe padre con la stessa firma del super
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoDiNascita = luogoDiNascita;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.codiceFiscale = codiceFiscale;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id; //meglio mettere sempre il this
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	@Override
	public String toString() {
		return this.id + ";" + this.nome + ";" + this.cognome + ";" + this.luogoDiNascita + ";" + this.dataDiNascita + ";" + this.sesso + ";" + this.codiceFiscale;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codiceFiscale, cognome, dataDiNascita, id, luogoDiNascita, nome, sesso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj; //cast: assegnamo all'oggetto obj di tipo Object il suo vero tipo (in questo caso Persona)
		//serve per dire esplicitamente che object si aspetti che sia di tipo Persona, così other può usare i metodi di Persona da obj
		return Objects.equals(codiceFiscale, other.codiceFiscale) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(dataDiNascita, other.dataDiNascita) && id == other.id
				&& Objects.equals(luogoDiNascita, other.luogoDiNascita) && Objects.equals(nome, other.nome)
				&& Objects.equals(sesso, other.sesso);
	}
}