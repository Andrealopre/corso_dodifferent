package model;

public class Account {
	private int idAccount;
	private String nomeUtente;
	private String password;
	
	public Account() {
		
	}
	
	public Account(Account other) {
		this.nomeUtente = other.nomeUtente;
		this.password = other.password;
	}
	
	public Account(int id_account, String nomeUtente, String password) {
		super();
		this.idAccount = id_account;
		this.nomeUtente = nomeUtente;
		this.password = password;
	}

	public int getId_account() {
		return idAccount;
	}

	public void setId_account(int id_account) {
		this.idAccount = id_account;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", nomeUtente=" + nomeUtente + ", password=" + password + "]";
	}
	
	
}
