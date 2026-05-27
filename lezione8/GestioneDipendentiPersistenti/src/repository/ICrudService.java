package repository;

import java.util.List;

import model.*;

public interface ICrudService {
	//Funzioni account
	public boolean inserisciAccount(Account account);
	public Account leggiAccount(int id);
	public Account leggiAccount(Account account);
	public Account leggiAccount(String username);
	//Funzioni dipendente
	public boolean inserisciDipendente(Dipendente dipendente);
	public boolean inserisciRuoloAziendale(RuoloAziendale ruoloAziendale);
	public boolean rimuovi(int id);
	//Funzioni modifica dipendente
	public boolean modificaStringa(int id, String tabella, String colonna, String valore);
	public boolean modificaDecimale(int id, String tabella, String colonna, Double valore);
	public boolean modificaIntero(int id, String tabella, String colonna, int valore);
	//Funzioni di ricerca
	public List<Dipendente> leggiDipendenti();
	public Dipendente leggiDipendente(int id);
	public Dipendente leggiDipendente(String nome, String cognome);
	public List<RuoloAziendale> leggiRuoliAziendali();	
	public RuoloAziendale leggiRuoloAziendale(int id);
	public List<Account> leggiAccount();
	
}
