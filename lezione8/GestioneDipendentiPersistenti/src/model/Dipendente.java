package model;

import java.sql.Date;

public class Dipendente {
	// L'ereditarietà non è un copia e incolla: ciò che è privato continua ad essere
	// privato. Ciò che è private rimane privato anche
	// in caso di ereditarietà. Ciò che è protected invece è private solo in caso di
	// istanza.
	// private String titoloDiStudio;
	private int id;
	private String nome;
	private String cognome;
	private String luogoDiNascista;
	private Date dataDiNascita;
	private String sesso;
	private double stipendio;
	private Account account;
	private RuoloAziendale ruoloAziendale;
	private String codiceFiscale;

	public Dipendente() {
	}

	public Dipendente(int id, String nome, String cognome, String luogoDiNascista, Date dataDiNascita, String sesso,
			double stipendio, Account account, RuoloAziendale ruoloAziendale, String codiceFiscale) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoDiNascista = luogoDiNascista;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.stipendio = stipendio;
		this.account = account;
		this.ruoloAziendale = ruoloAziendale;
		this.codiceFiscale = codiceFiscale;
		
	}

	/*
	 * costruttore di copia
	 * 
	 * Permette di creare un oggetto copiandolo da un altro oggetto
	 * 
	 */
	public Dipendente(Dipendente other) {
		this.id = other.getId();
		this.nome = other.getNome();
		this.cognome = other.getCognome();
		this.luogoDiNascista = other.getLuogoDiNascista();
		this.dataDiNascita = other.getDataDiNascita();
		this.sesso = other.getSesso();
		this.ruoloAziendale = other.getRuoloAziendale();
		this.stipendio = other.getStipendio();
		this.account = other.getAccount();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getLuogoDiNascista() {
		return luogoDiNascista;
	}

	public void setLuogoDiNascista(String luogoDiNascista) {
		this.luogoDiNascista = luogoDiNascista;
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

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public RuoloAziendale getRuoloAziendale() {
		return ruoloAziendale;
	}

	public void setRuoloAziendale(RuoloAziendale ruoloAziendale) {
		this.ruoloAziendale = ruoloAziendale;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public int getIdRuoloAziendale() {
		return this.getRuoloAziendale().getIdRuoloAziendale();
	}
	
	public int getIdAccount() {
		return this.getAccount().getId_account();
	}

	@Override
	public String toString() {
		return "Dipendente id=" + id + ", nome=" + nome + ", cognome=" + cognome + "\nluogoDiNascista="
				+ luogoDiNascista + ", dataDiNascita=" + dataDiNascita + "\nsesso=" + sesso + ", stipendio=" + stipendio
				+ "\naccount=" + getIdAccount() + ", ruoloAziendale=" + getIdRuoloAziendale() + ", codiceFiscale=" + codiceFiscale;
	}
	
	

}